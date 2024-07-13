package com.potaton.potato.domain.daily.controller;

import com.potaton.potato.domain.daily.dto.requestdto.DailyCompleteDto;
import com.potaton.potato.domain.daily.dto.responsedto.*;
import com.potaton.potato.domain.daily.service.DailyService;
import com.potaton.potato.domain.user.repository.UserJpaRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/daily")
public class DailyController {

    private DailyService dailyService;
    private UserJpaRepository userJpaRepository;

    @GetMapping()
    public ResponseEntity<List<DailyInfoDto>> getDailyList(){
        Long userId = 1L;
        List<DailyInfoDto> dailyList = dailyService.getDailyList(userId);

        return ResponseEntity.ok(dailyList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DailyReviewResponseDto>  getDailyReview(@PathVariable Long id){
        Long userId = 1L;
        Long dailyId = id;
        DailyReviewResponseDto dailyReview = dailyService.getDailyReview(userId, dailyId);

        return ResponseEntity.ok(dailyReview);
    }

    @GetMapping("/test/{id}")
    public ResponseEntity<DailyQuestionResponseDto> getDailyQuestion(@PathVariable Long id){
        DailyQuestionResponseDto dailyQuestion = dailyService.getDailyQuestion(id);

        return ResponseEntity.ok(dailyQuestion);
    }

    @PostMapping("/test/{id}")
    public ResponseEntity<String> compeleteDaily(@RequestBody  DailyCompleteDto dailyCompleteDto){
        dailyService.completeDaily(dailyCompleteDto);

        return ResponseEntity.ok("completeDaily success");
    }
}
