package com.api.logs.domain.normalizedlogs;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NormalizedLogsDTO {
    private Long id;
    private String interactionType;
    private Long frequency;
    private String gestureDirection;
    private LocalDateTime time;
}
