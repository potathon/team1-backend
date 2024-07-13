package com.potaton.potato.domain.daily.dto.responsedto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DailyInfoDto {
    private Long id;
    private LocalDateTime date;
    private Long answerCnt;
    private Boolean isDone;
}
