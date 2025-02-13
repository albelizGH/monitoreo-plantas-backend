package com.alejobeliz.projects.techforb.monitoreo_plantas.model;

import com.alejobeliz.projects.techforb.monitoreo_plantas.dto.request.reading.UpdateReadingRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Reading")
@Table(name = "readings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "readings_ok", nullable = false)
    private Integer readingsOk;

    @Column(name = "medium_alerts" , nullable = false)
    private Integer mediumAlerts;

    @Column(name = "red_alerts" , nullable = false)
    private Integer redAlerts;

    public void updateReadding(UpdateReadingRequestDTO updateReadingRequestDTO){
        if(updateReadingRequestDTO.readingsOk() != null){
            this.readingsOk = updateReadingRequestDTO.readingsOk();
        }
        if(updateReadingRequestDTO.mediumAlerts() != null){
            this.mediumAlerts = updateReadingRequestDTO.mediumAlerts();
        }
        if(updateReadingRequestDTO.redAlerts() != null){
            this.redAlerts = updateReadingRequestDTO.redAlerts();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getReadingsOk() {
        return readingsOk;
    }

    public void setReadingsOk(Integer readingsOk) {
        this.readingsOk = readingsOk;
    }

    public Integer getMediumAlerts() {
        return mediumAlerts;
    }

    public void setMediumAlerts(Integer mediumAlerts) {
        this.mediumAlerts = mediumAlerts;
    }

    public Integer getRedAlerts() {
        return redAlerts;
    }

    public void setRedAlerts(Integer redAlerts) {
        this.redAlerts = redAlerts;
    }
}
