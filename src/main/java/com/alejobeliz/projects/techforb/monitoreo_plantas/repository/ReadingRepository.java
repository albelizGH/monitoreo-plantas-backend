package com.alejobeliz.projects.techforb.monitoreo_plantas.repository;

import com.alejobeliz.projects.techforb.monitoreo_plantas.model.Reading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingRepository extends JpaRepository<Reading, Long> {
}
