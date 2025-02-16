package com.alejobeliz.projects.techforb.repository;

import com.alejobeliz.projects.techforb.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {
}
