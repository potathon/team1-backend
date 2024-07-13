package com.potaton.potato.domain.daily.dto.responsedto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DailyQuestionDto {
    private Long questionId;
    private String question;
    private LocalDateTime date;
}
