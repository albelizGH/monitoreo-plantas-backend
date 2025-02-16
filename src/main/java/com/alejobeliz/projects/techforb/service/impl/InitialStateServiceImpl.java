package com.alejobeliz.projects.techforb.service.impl;

import com.alejobeliz.projects.techforb.dto.response.*;
import com.alejobeliz.projects.techforb.entity.Reading;
import com.alejobeliz.projects.techforb.entity.User;
import com.alejobeliz.projects.techforb.repository.ReadingRepository;
import com.alejobeliz.projects.techforb.service.InitialStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class InitialStateServiceImpl implements InitialStateService {

    private final UserServiceImpl userService;
    private final ReadingServiceImpl readingService;
    private final ReadingRepository readingRepository;

    @Autowired
    public InitialStateServiceImpl(UserServiceImpl userService, ReadingServiceImpl readingService, ReadingRepository readingRepository) {
        this.userService = userService;
        this.readingService = readingService;
        this.readingRepository = readingRepository;
    }

    public DashboardInitialStateResponseDTO getInitialState(Long id) {
        User user = userService.getUserById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        UserResponseDTO userResponseDTO = new UserResponseDTO(user);

        List<Reading> readings = readingService.getAllReadings();
        List<TableResponseDTO> table= new ArrayList<>();
        List<Object[]> dataBaseResponse = readingRepository.getTableResponse();

        dataBaseResponse.stream().map(item ->
                new TableResponseDTO(
                        (Long) item[0],
                        (String) item[1],
                        new PlantResponseDTO.CountryResponseDTO((String) item[2], (String) item[3]),
                        (Long) item[4],
                        (Long) item[5],
                        (Long) item[6],
                        (Long) item[7]
                )

        ).collect(Collectors.toCollection(() -> table));

        int totalReadingsOk = 0;
        int totalMediumAlerts = 0;
        int totalRedAlerts = 0;
        int disabledSensors = 0;

        for (TableResponseDTO item : table) {
            totalReadingsOk += item.readingsOk();
            totalMediumAlerts += item.mediumAlerts();
            totalRedAlerts += item.redAlerts();
            disabledSensors += item.disabledSensors();
        }

        GlobalResponseDTO globalResponseDTO = new GlobalResponseDTO(totalReadingsOk, totalMediumAlerts, totalRedAlerts, disabledSensors);

        return new DashboardInitialStateResponseDTO(userResponseDTO, table, globalResponseDTO);
    }
}
