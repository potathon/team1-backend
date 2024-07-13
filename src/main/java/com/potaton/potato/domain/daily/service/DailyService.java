package com.potaton.potato.domain.daily.service;

import com.potaton.potato.domain.daily.dto.requestdto.DailyCompleteDto;
import com.potaton.potato.domain.daily.dto.responsedto.DailyInfoDto;
import com.potaton.potato.domain.daily.dto.responsedto.DailyQuestionDto;
import com.potaton.potato.domain.daily.dto.responsedto.DailyReviewDto;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface DailyService {
    List<DailyInfoDto> getDailyList();
    List<DailyReviewDto> getDailyReview(Long userId);
    List<DailyQuestionDto> getDailyQuestion();
    void completeDaily(DailyCompleteDto dailyCompleteDto);
    void registVoice(Long userId, MultipartFile voice);
}