package com.potaton.potato.domain.daily.dto.requestdto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DailyCompleteDto {
    private Long userId;
    private List<ReplyDto> replies;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class ReplyDto{
    private Long questionId;
    private String answer;
}
