package com.api.logs.domain.normalizedlogs;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "normalizedlogs")
public class NormalizedLogs {
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "interactionType")
    private String interactionType;

    @Column(name = "time", nullable = false)
    private LocalDateTime time;

    @Column(name = "frequency", nullable = false)
    private long frequency;

    @Column(name = "gestureDirection")
    private String gestureDirection;
}
