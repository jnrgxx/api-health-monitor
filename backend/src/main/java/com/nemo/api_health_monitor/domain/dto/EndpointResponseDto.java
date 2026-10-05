package com.nemo.api_health_monitor.domain.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record EndpointResponseDto(
    UUID id,
    String name,
    String url,
    String method,
    int interval_seconds,
    int expected_status,
    boolean is_active,
    LocalDateTime createdAt
) {

}
