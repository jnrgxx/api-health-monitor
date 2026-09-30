package com.nemo.api_health_monitor.controller;

import com.nemo.api_health_monitor.domain.dto.MonitoredEndpointRequestDto;
import com.nemo.api_health_monitor.domain.dto.MonitoredEndpointResponseDto;
import com.nemo.api_health_monitor.service.MonitoredEndpointService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * REST controller for Monitored Endpoints operations.
 *
 * All endpoints start with /api/v1/endpoints (inherited from class-level @RequestMapping)
 *
 * @RestController = @Controller + @ResponseBody (returns JSON automatically)
 */
@RestController
@RequestMapping("/api/v1/endpoints")
public class MonitoredEndpointController {

    private final MonitoredEndpointService monitoredEndpointService;

    public MonitoredEndpointController(MonitoredEndpointService monitoredEndpointService) {
        this.monitoredEndpointService = monitoredEndpointService;
    }

    /**
     * List all the monitored endpoints
     *
     * @return all the monitored endpoints
     */
    @GetMapping
    public ResponseEntity<List<MonitoredEndpointResponseDto>> listAllEndpoints() {

        // comes from the database
        // need a method from service to get list all endpoints
        return ResponseEntity.ok(monitoredEndpointService.listAllEndpoints());
    }

    /**
     * Get a specific monitored endpoint
     *
     * @return the monitored endpoints
     */
    @GetMapping("/{id}")
    public ResponseEntity<MonitoredEndpointResponseDto> getEndpoint(@Valid @RequestBody MonitoredEndpointRequestDto request) {
        // need a method from service to get the endpoint using the id
        return ResponseEntity.ok();
    }

//    @PostMapping
//    public


}

