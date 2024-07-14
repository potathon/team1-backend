package com.potaton.potato.domain.daily.service;

import com.potaton.potato.domain.daily.dto.requestdto.QuestionAnswerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    private RestTemplate restTemplate;

    @Async
    public void sendRepliesAsync(List<QuestionAnswerDto> replies) {
        String flaskServerUrl = "https://sprouted-potato.run.goorm.io/generate-feedback";

        for (QuestionAnswerDto reply : replies) {
            try {
                restTemplate.postForObject(flaskServerUrl, reply, String.class);
            } catch (Exception e) {
                // 오류 처리 (로깅 등)
                e.printStackTrace();
            }
        }
    }

}
