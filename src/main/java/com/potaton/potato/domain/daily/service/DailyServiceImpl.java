package com.potaton.potato.domain.daily.service;

import com.potaton.potato.domain.daily.dto.requestdto.DailyCompleteDto;
import com.potaton.potato.domain.daily.dto.requestdto.ReplyDto;
import com.potaton.potato.domain.daily.dto.responsedto.DailyInfoDto;
import com.potaton.potato.domain.daily.dto.responsedto.DailyQuestionDto;
import com.potaton.potato.domain.daily.dto.responsedto.DailyReviewDto;
import com.potaton.potato.domain.daily.entity.Answer;
import com.potaton.potato.domain.daily.entity.Daily;
import com.potaton.potato.domain.daily.entity.DailyQuestion;
import com.potaton.potato.domain.daily.entity.Question;
import com.potaton.potato.domain.daily.repository.*;
import com.potaton.potato.domain.user.entity.User;
import com.potaton.potato.domain.user.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DailyServiceImpl implements DailyService {

    private final AnswerJpaRepository answerJpaRepository;
    private final DailyJpaRepository dailyJpaRepository;
    private final DailyQuestionJpaRepository dailyQuestionJpaRepository;
    private final QuestionJpaRepository questionJpaRepository;
    private final TagJpaRepository tagJpaRepository;
    private final UserJpaRepository userJpaRepository;

    @Autowired
    public DailyServiceImpl(AnswerJpaRepository answerJpaRepository, DailyJpaRepository dailyJpaRepository, DailyQuestionJpaRepository dailyQuestionJpaRepository, QuestionJpaRepository questionJpaRepository, TagJpaRepository tagJpaRepository, UserJpaRepository userJpaRepository) {
        this.answerJpaRepository = answerJpaRepository;
        this.dailyJpaRepository = dailyJpaRepository;
        this.dailyQuestionJpaRepository = dailyQuestionJpaRepository;
        this.questionJpaRepository = questionJpaRepository;
        this.tagJpaRepository = tagJpaRepository;
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public List<DailyInfoDto> getDailyList(Long userId) {
        LocalDateTime today = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
        return dailyJpaRepository.findDailyWithAnswerCountsAndIsDone(today, userId);
    }


    @Override
    public List<DailyReviewDto> getDailyReview(Long userId, Long dailyId) {
        List<Answer> answers = answerJpaRepository.findByDailyId(dailyId);
        return answers.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DailyQuestionDto> getDailyQuestion(Long dailyId) {
        List<DailyQuestion> questions = dailyQuestionJpaRepository.findByDailyId(dailyId);
        return questions.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void completeDaily(DailyCompleteDto dailyCompleteDto) {
        List<ReplyDto> replies = dailyCompleteDto.getReplies();
        Long userId = dailyCompleteDto.getUserId();

        LocalDate today = LocalDate.now();


        User user = userJpaRepository.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));

        for(ReplyDto reply : replies){
            Question question = questionJpaRepository.findById(reply.getQuestionId())
                    .orElseThrow(() -> new RuntimeException("Question not found"));

            List<DailyQuestion> dailyQuestions = dailyQuestionJpaRepository.findByQuestionId(reply.getQuestionId());


            if (dailyQuestions.isEmpty()) {
                throw new RuntimeException("No Daily found for the given question");
            }

            // 필터링: daily의 날짜가 오늘인 것만 추려내기
            List<Daily> todaysDailies = dailyQuestions.stream()
                    .map(DailyQuestion::getDaily)
                    .filter(daily -> daily.getDate().toLocalDate().isEqual(today))
                    .toList();

            if (todaysDailies.isEmpty()) {
                throw new RuntimeException("No Daily found for the given question with today's date");
            }

            // Assuming there's only one Daily per question
            //하나의 문제를 여러 번 돌려쓰면 문제가 될 것.
            Daily daily = todaysDailies.get(0);

            Answer answer = Answer.builder()
                    .user(user)
                    .daily(daily)
                    .question(question)
                    .content(reply.getAnswer())
                    .build();

            answerJpaRepository.save(answer);
        }
    }


    @Override
    public void registVoice(Long userId, MultipartFile voice) {


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
