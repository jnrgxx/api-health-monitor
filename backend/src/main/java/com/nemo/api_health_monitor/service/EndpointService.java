package com.nemo.api_health_monitor.service;

import com.nemo.api_health_monitor.domain.dto.EndpointResponseDto;

import java.util.List;
import java.util.UUID;

public interface EndpointService {

    List<EndpointResponseDto> listAllEndpoints();

    EndpointResponseDto getEndpoint(UUID id);
}
