package com.alejobeliz.projects.techforb.monitoreo_plantas.repository;

import com.alejobeliz.projects.techforb.monitoreo_plantas.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
