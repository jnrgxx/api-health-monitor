package com.nemo.api_health_monitor.service;

import com.nemo.api_health_monitor.domain.dto.MonitoredEndpointResponseDto;

import java.util.List;

public interface MonitoredEndpointService {

    List<MonitoredEndpointResponseDto> listAllEndpoints();
}
