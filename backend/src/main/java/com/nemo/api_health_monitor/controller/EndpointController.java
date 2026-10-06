package com.nemo.api_health_monitor.controller;

import com.nemo.api_health_monitor.domain.dto.EndpointRequestDto;
import com.nemo.api_health_monitor.domain.dto.EndpointResponseDto;
import com.nemo.api_health_monitor.service.EndpointService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * REST controller for  Endpoints operations.
 *
 * All endpoints start with /api/v1/endpoints (inherited from class-level @RequestMapping)
 *
 * @RestController = @Controller + @ResponseBody (returns JSON automatically)
 */
@RestController
@RequestMapping("/api/v1/endpoints")
public class EndpointController {

    private final EndpointService endpointService;

    public EndpointController(EndpointService endpointService) {
        this.endpointService = endpointService;
    }

    /**
     * Get a specific  endpoint
     *
     * @return the  endpoints
     */
    @GetMapping("/{id}")
    public ResponseEntity<EndpointResponseDto> getEndpoint(@PathVariable UUID id) {
        // need a method from service to get the endpoint using the id
        return ResponseEntity.ok(endpointService.getEndpoint(id));
    }


    /**
     * List all the  endpoints
     *
     * @return all the  endpoints
     */
    @GetMapping
    public ResponseEntity<List<EndpointResponseDto>> listAllEndpoints() {

        // comes from the database
        // need a method from service to get list all endpoints
        return ResponseEntity.ok(endpointService.listAllEndpoints());
    }



//    POST   /api/endpoints          Register a new endpoint to monitor
    @PostMapping
    public ResponseEntity<EndpointResponseDto> addNewEndpoint(@Valid @RequestBody EndpointRequestDto request) {
        EndpointResponseDto endpoint = endpointService.addNewEndpoint(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(endpoint);
    }

//    PUT    /api/endpoints/{id}     Update endpoint (URL, interval, etc.)

//    DELETE /api/endpoints/{id}     Stop monitoring and delete

//    PATCH  /api/endpoints/{id}/toggle   Turn monitoring on or off


}

