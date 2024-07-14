package com.potaton.potato.domain.daily.dto.requestdto;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DailyCompleteDto implements Serializable {
    private Long userId;
    private List<ReplyDto> replies;
}


