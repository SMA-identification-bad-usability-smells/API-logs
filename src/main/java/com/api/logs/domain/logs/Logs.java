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
    private float coordinatesX;

    @Column(name = "coordinatesY", nullable = false)
    private float coordinatesY;

    @Column(name = "direction")
    private String direction;

    @Column(name = "target_element_id")
    private String targetElementId;

    @Column(name = "normalized")
    private boolean normalized;

    public Logs(
            String type,
            LocalDateTime timestamp,
            float coordinatesX,
            float coordinatesY,
            String direction,
            String targetElementId) {
        this.type = type;
        this.timestamp = timestamp;
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.direction = direction;
        this.targetElementId = targetElementId;
        this.normalized = false;
    }
}
