package com.alejobeliz.projects.techforb.repository;

import com.alejobeliz.projects.techforb.dto.response.TableResponseDTO;
import com.alejobeliz.projects.techforb.entity.Reading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReadingRepository extends JpaRepository<Reading, Long> {

    @Query("""
    SELECT 
        p.id AS id, 
        p.name AS name, 
        c.name AS country, 
        c.imageUrl AS countryUrl, 
        SUM(r.readingsOk) AS readingsOk, 
        SUM(r.mediumAlerts) AS mediumAlerts, 
        SUM(r.redAlerts) AS redAlerts, 
        COUNT(CASE WHEN r.disabled = true THEN 1 ELSE NULL END) AS disabled
    FROM 
        Reading r
    JOIN 
        r.plant p
    JOIN 
        p.country c
    GROUP BY 
        p.id, p.name, c.name, c.imageUrl
""")
    List<Object[]> getTableResponse();



}
