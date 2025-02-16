package com.alejobeliz.projects.techforb.entity;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "plants")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @OneToMany(mappedBy = "plant")
    private List<Reading> readings;
}
