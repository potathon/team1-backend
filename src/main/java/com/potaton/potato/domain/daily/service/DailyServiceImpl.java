package com.potaton.potato.domain.daily.service;

import com.potaton.potato.domain.daily.dto.requestdto.DailyCompleteDto;
import com.potaton.potato.domain.daily.dto.requestdto.ReplyDto;
import com.potaton.potato.domain.daily.dto.responsedto.DailyInfoDto;
import com.potaton.potato.domain.daily.dto.responsedto.DailyQuestionDto;
import com.potaton.potato.domain.daily.dto.responsedto.DailyReviewDto;
import com.potaton.potato.domain.daily.entity.Answer;
import com.potaton.potato.domain.daily.entity.DailyQuestion;
import com.potaton.potato.domain.daily.repository.*;
import com.potaton.potato.domain.user.entity.User;
import com.potaton.potato.domain.user.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    @Autowired
    public DailyServiceImpl(AnswerJpaRepository answerJpaRepository, DailyJpaRepository dailyJpaRepository, DailyQuestionJpaRepository dailyQuestionJpaRepository, QuestionJpaRepository questionJpaRepository, TagJpaRepository tagJpaRepository ) {
        this.answerJpaRepository = answerJpaRepository;
        this.dailyJpaRepository = dailyJpaRepository;
        this.dailyQuestionJpaRepository = dailyQuestionJpaRepository;
        this.questionJpaRepository = questionJpaRepository;
        this.tagJpaRepository = tagJpaRepository;
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
