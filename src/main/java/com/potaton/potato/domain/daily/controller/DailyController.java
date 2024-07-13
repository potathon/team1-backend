package com.potaton.potato.domain.daily.controller;

import com.potaton.potato.domain.daily.dto.requestdto.DailyCompleteDto;
import com.potaton.potato.domain.daily.dto.responsedto.DailyInfoDto;
import com.potaton.potato.domain.daily.dto.responsedto.DailyQuestionDto;
import com.potaton.potato.domain.daily.dto.responsedto.DailyReviewDto;
import com.potaton.potato.domain.daily.service.DailyService;
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

    @GetMapping("/")
    public ResponseEntity<List<DailyInfoDto>> getDailyList(){
        List<DailyInfoDto> dailyList = dailyService.getDailyList();

        return ResponseEntity.ok(dailyList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<DailyReviewDto>> getDailyReview(@PathVariable Long id){
        List<DailyReviewDto> dailyReview = dailyService.getDailyReview(id);

        return ResponseEntity.ok(dailyReview);
    }

    @GetMapping("/test/{id}")
    public ResponseEntity<List<DailyQuestionDto>> getDailyQuestion(){
        List<DailyQuestionDto> dailyQuestion = dailyService.getDailyQuestion();

        return ResponseEntity.ok(dailyQuestion);
    }

    @PostMapping("/test/{id}")
    public ResponseEntity<String> compeleteDaily(DailyCompleteDto dailyCompleteDto){
        dailyService.completeDaily(dailyCompleteDto);

        return ResponseEntity.ok("completeDaily success");
    }
}
