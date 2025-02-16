package com.alejobeliz.projects.techforb.entity;


import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "readings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plant_id", nullable = false)
    private Plant plant;

    @Column(name="readings_ok",nullable = false)
    private Integer readingsOk = 0;

    @Column(name="medium_alerts",nullable = false)
    private Integer mediumAlerts = 0;

    @Column(name="red_alerts",nullable = false)
    private Integer redAlerts = 0;

    @Column(nullable = false)
    private Boolean disabled = false;

    @Enumerated(EnumType.STRING)
    @Column(name = "reading_type",nullable = false)
    private ReadingType readingType;

}