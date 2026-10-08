package com.nemo.api_health_monitor.service;

import com.nemo.api_health_monitor.domain.dto.EndpointRequestDto;
import com.nemo.api_health_monitor.domain.dto.EndpointResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface EndpointService {

    List<EndpointResponseDto> listAllEndpoints();

    EndpointResponseDto getEndpoint(UUID id);

    EndpointResponseDto addNewEndpoint(EndpointRequestDto request);

    EndpointResponseDto updateEndpoint(@Valid EndpointRequestDto request, UUID id);

    EndpointResponseDto toggleMonitoring(UUID id);

    void deleteEndpoint(UUID id);
}
