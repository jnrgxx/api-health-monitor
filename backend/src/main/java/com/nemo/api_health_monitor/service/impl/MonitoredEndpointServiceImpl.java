package com.nemo.api_health_monitor.service.impl;

import com.nemo.api_health_monitor.domain.dto.MonitoredEndpointRequestDto;
import com.nemo.api_health_monitor.domain.dto.MonitoredEndpointResponseDto;
import com.nemo.api_health_monitor.domain.entity.MonitoredEndpoint;
import com.nemo.api_health_monitor.repository.MonitoredEndpointRepository;
import com.nemo.api_health_monitor.service.MonitoredEndpointService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class MonitoredEndpointServiceImpl implements MonitoredEndpointService {
    private final MonitoredEndpointRepository monitoredEndpointRepository;


    public List<MonitoredEndpointRequestDto> listAllEndpointss() {
        List<MonitoredEndpoint> endpoints = monitoredEndpointRepository.findAll();
        return ;
    }
}
