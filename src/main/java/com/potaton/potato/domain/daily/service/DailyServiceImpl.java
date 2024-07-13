package com.potaton.potato.domain.daily.service;

import com.potaton.potato.domain.daily.dto.requestdto.DailyCompleteDto;
import com.potaton.potato.domain.daily.dto.requestdto.ReplyDto;
import com.potaton.potato.domain.daily.dto.responsedto.DailyInfoDto;
import com.potaton.potato.domain.daily.dto.responsedto.DailyQuestionDto;
import com.potaton.potato.domain.daily.dto.responsedto.DailyReviewDto;
import com.potaton.potato.domain.daily.repository.*;
import com.potaton.potato.domain.user.entity.User;
import com.potaton.potato.domain.user.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
    public List<DailyInfoDto> getDailyList() {
        return List.of();
    }

    @Override
    public List<DailyReviewDto> getDailyReview(Long userId) {
        return List.of();
    }

    @Override
    public List<DailyQuestionDto> getDailyQuestion() {
        return List.of();
    }

    @Override
    public void completeDaily(DailyCompleteDto dailyCompleteDto) {
        List<ReplyDto> replies = dailyCompleteDto.getReplies();
        Long userId = dailyCompleteDto.getUserId();

        User user = userJpaRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

    }

    @Override
    public void registVoice(Long userId, MultipartFile voice) {

    }
}
