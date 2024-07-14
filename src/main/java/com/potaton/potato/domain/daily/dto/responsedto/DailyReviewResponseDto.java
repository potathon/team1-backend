package com.potaton.potato.domain.daily.dto.responsedto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DailyReviewResponseDto {
    private LocalDateTime date;
    private List<DailyReviewDto> questions;
}
