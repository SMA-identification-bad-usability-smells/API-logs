package com.api.logs.domain.logs;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "logs")
public class Logs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "type")
    private String type;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;

    @Column(name = "coordinatesX", nullable = false)
    private int coordinatesX;

    @Column(name = "coordinatesY", nullable = false)
    private int coordinatesY;

    @Column(name = "target_element_id")
    private String targetElementId;

    public Logs(String type, LocalDateTime timestamp, int coordinatesX, int coordinatesY, String targetElementId) {
        this.type = type;
        this.timestamp = timestamp;
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.targetElementId = targetElementId;
    }
}
