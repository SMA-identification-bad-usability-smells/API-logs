package com.api.logs.domain.logs;

import lombok.*;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LogsEntryDTO {
    private String user;

    private String type;

    private Instant timestamp;

    private float coordinatesX;

    private float coordinatesY;

    private String direction;

    private String targetElementId;
}
