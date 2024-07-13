package com.potaton.potato.domain.daily.service;

import com.potaton.potato.domain.daily.dto.requestdto.DailyCompleteDto;
import com.potaton.potato.domain.daily.dto.requestdto.ReplyDto;
import com.potaton.potato.domain.daily.dto.responsedto.*;
import com.potaton.potato.domain.daily.entity.Answer;
import com.potaton.potato.domain.daily.entity.Daily;
import com.potaton.potato.domain.daily.entity.DailyQuestion;
import com.potaton.potato.domain.daily.entity.Question;
import com.potaton.potato.domain.daily.repository.AnswerJpaRepository;
import com.potaton.potato.domain.daily.repository.DailyJpaRepository;
import com.potaton.potato.domain.daily.repository.DailyQuestionJpaRepository;
import com.potaton.potato.domain.daily.repository.QuestionJpaRepository;
import com.potaton.potato.domain.daily.repository.TagJpaRepository;
import com.potaton.potato.domain.user.entity.User;
import com.potaton.potato.domain.user.repository.UserJpaRepository;
import com.potaton.potato.global.file.FileStore;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DailyServiceImpl implements DailyService {

    private final AnswerJpaRepository answerJpaRepository;
    private final DailyJpaRepository dailyJpaRepository;
    private final DailyQuestionJpaRepository dailyQuestionJpaRepository;
    private final QuestionJpaRepository questionJpaRepository;
    private final TagJpaRepository tagJpaRepository;
    private final UserJpaRepository userJpaRepository;
    private final FileStore fileStore;

    @Autowired
    public DailyServiceImpl(AnswerJpaRepository answerJpaRepository, DailyJpaRepository dailyJpaRepository, DailyQuestionJpaRepository dailyQuestionJpaRepository, QuestionJpaRepository questionJpaRepository, TagJpaRepository tagJpaRepository, UserJpaRepository userJpaRepository, FileStore fileStore) {
        this.answerJpaRepository = answerJpaRepository;
        this.dailyJpaRepository = dailyJpaRepository;
        this.dailyQuestionJpaRepository = dailyQuestionJpaRepository;
        this.questionJpaRepository = questionJpaRepository;
        this.tagJpaRepository = tagJpaRepository;
        this.userJpaRepository = userJpaRepository;
        this.fileStore = fileStore;
    }

    @Override
    public List<DailyInfoDto> getDailyList(Long userId) {
        LocalDateTime today = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
        return dailyJpaRepository.findDailyWithAnswerCountsAndIsDone(today, userId);
    }


    @Override
    public DailyReviewResponseDto getDailyReview(Long userId, Long dailyId) {
        List<Answer> answers = answerJpaRepository.findByDailyId(dailyId);

        Daily daily = answers.get(0).getDaily();
        LocalDateTime date = daily.getDate();

        List<DailyReviewDto> reviewDtos = answers.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        return new DailyReviewResponseDto(date, reviewDtos);
    }

    @Override
    public DailyQuestionResponseDto getDailyQuestion(Long dailyId) {
        List<DailyQuestion> questions = dailyQuestionJpaRepository.findByDailyId(dailyId);

        Daily daily = questions.get(0).getDaily();
        LocalDateTime date = daily.getDate();

        List<DailyQuestionDto> dailyQuestionDtos = questions.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        return new DailyQuestionResponseDto(date, dailyQuestionDtos);
    }

    @Override
    public void completeDaily(DailyCompleteDto dailyCompleteDto, List<MultipartFile> records) {
        List<ReplyDto> replies = dailyCompleteDto.getReplies();
        Long userId = dailyCompleteDto.getUserId();

        LocalDateTime today = LocalDateTime.now();

        User user = userJpaRepository.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));

        int idx = 0;
        for(ReplyDto reply : replies){
            Question question = questionJpaRepository.findById(reply.getQuestionId())
                    .orElseThrow(() -> new RuntimeException("Question not found"));

            // 필터링: daily의 날짜가 오늘인 것만 추려내기
            Daily daily = dailyJpaRepository.findAll().stream()
                    .filter(x -> x.getDate().toLocalDate().equals((today.toLocalDate()))).findFirst()
                .orElseThrow(()-> {
//                    dailyJpaRepository.save(Daily.builder().date(LocalDateTime.now()).build());
                    return new RuntimeException("No Daily found for the given question with today's date");
                });

            // Assuming there's only one Daily per question
            //하루에 하나의 문제를 여러 번 돌려쓰면 문제가 될 것.
            String filePath = fileStore.storeFile(records.get(idx));
            Answer answer = Answer.builder()
                    .user(user)
                    .daily(daily)
                    .question(question)
                    .content(reply.getAnswer())
                    .file(filePath)
                    .build();

            answerJpaRepository.save(answer);
            idx += 1;
        }
    }

    private DailyReviewDto convertToDto(Answer answer) {
        return DailyReviewDto.builder()
                .question(answer.getQuestion().getContent()) // Assuming Question entity has a getContent() method
                .answer(answer.getContent())
                .recodeUrl(answer.getFile())
                .build();
    }

    private DailyQuestionDto convertToDto(DailyQuestion dailyQuestion) {
        return DailyQuestionDto.builder()
                .questionId(dailyQuestion.getQuestion().getId())
                .question(dailyQuestion.getQuestion().getContent()) // Assuming Question entity has a getContent() method
                .build();
    }
}
