package com.nemo.api_health_monitor.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record MonitoredEndpointRequestDto(
        @NotBlank(message = "Endpoint name is required")
        String name,
        String url,
        String method,
        int expected_status
) {
}
