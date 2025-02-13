package com.alejobeliz.projects.techforb.monitoreo_plantas.repository;

import com.alejobeliz.projects.techforb.monitoreo_plantas.model.PlantSensorReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlantSensorReadingRepository extends JpaRepository<PlantSensorReading, Long> {

    // Método para encontrar una combinación de plant_id, sensor_id y readings_id
    Optional<PlantSensorReading> findByPlantIdAndSensorIdAndReadingId(Long plantId, Long sensorId, Long readingId);

    // Obtener todas las lecturas para una planta específica, independientemente del sensor
    List<PlantSensorReading> findByPlantId(Long plantId);


    Optional<PlantSensorReading> findByPlantIdAndSensorId(Long plantId, Long sensorId);
}
