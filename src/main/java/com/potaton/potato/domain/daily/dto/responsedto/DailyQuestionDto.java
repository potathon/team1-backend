package com.potaton.potato.domain.daily.dto.responsedto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DailyQuestionDto {
    private Long questionId;
    private String question;

}
