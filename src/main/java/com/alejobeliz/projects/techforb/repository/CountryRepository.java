package com.alejobeliz.projects.techforb.repository;

import com.alejobeliz.projects.techforb.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findByName(String name);
}
