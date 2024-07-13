package com.potaton.potato.domain.daily.service;

import com.potaton.potato.domain.daily.dto.requestdto.DailyCompleteDto;
import com.potaton.potato.domain.daily.dto.responsedto.*;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface DailyService {
    List<DailyInfoDto> getDailyList(Long userId);
    DailyReviewResponseDto getDailyReview(Long userId, Long dailyId);
    DailyQuestionResponseDto getDailyQuestion(Long dailyId);
    void completeDaily(DailyCompleteDto dailyCompleteDto, List<MultipartFile> records);
}
