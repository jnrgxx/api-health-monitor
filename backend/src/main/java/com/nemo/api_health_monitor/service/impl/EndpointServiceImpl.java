package com.nemo.api_health_monitor.service.impl;

import com.nemo.api_health_monitor.domain.dto.EndpointRequestDto;
import com.nemo.api_health_monitor.domain.dto.EndpointResponseDto;
import com.nemo.api_health_monitor.domain.entity.Endpoint;
import com.nemo.api_health_monitor.exception.DuplicateEndpointException;
import com.nemo.api_health_monitor.exception.EndpointNotFoundException;
import com.nemo.api_health_monitor.mapper.EndpointMapper;
import com.nemo.api_health_monitor.repository.EndpointRepository;
import com.nemo.api_health_monitor.repository.ResultsRepository;
import com.nemo.api_health_monitor.service.EndpointService;
import jakarta.persistence.Column;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class EndpointServiceImpl implements EndpointService {
    private final EndpointRepository endpointRepository;
    private final ResultsRepository resultsRepository;
    private EndpointMapper endpointMapper;

    public EndpointServiceImpl(EndpointRepository endpointRepository, ResultsRepository resultsRepository, EndpointMapper endpointMapper) {
        this.endpointRepository = endpointRepository;
        this.resultsRepository = resultsRepository;
        this.endpointMapper = endpointMapper;
    }

    @Override
    public EndpointResponseDto getEndpoint(UUID id) {
        Endpoint endpoint = endpointRepository.findById(id)
                .orElseThrow(() -> new EndpointNotFoundException(
                        "Endpoint not found with id: " + id
                ));
        return endpointMapper.toDto(endpoint);
    }

    @Override
    public List<EndpointResponseDto> listAllEndpoints() {
        List<Endpoint> endpoints = endpointRepository.findAll();

        return endpoints.stream().map(endpoint -> endpointMapper.toDto(endpoint)).toList();

//        Statement Lambda version:

//        return endpoints.stream().map(endpoint -> {
//            return endpointMapper.toDto(endpoint);
//        }).toList();
    }

//    POST   /api/endpoints          Register a new endpoint to monitor
    @Override
    public EndpointResponseDto addNewEndpoint(EndpointRequestDto request) {
        if (endpointRepository.existsByUrl(request.url())){
            throw new DuplicateEndpointException(request.url());
//            throw new IllegalArgumentException(
//                "Endpoint with url '" + request.url() + " ' already exists"
//            );
        }
        Endpoint endpoint = endpointMapper.toEntity(request);
        endpoint = endpointRepository.save(endpoint);

        return endpointMapper.toDto(endpoint);
    }


//    PUT    /api/endpoints/{id}     Update endpoint (URL, interval, etc.)
    @Override
    public EndpointResponseDto updateEndpoint(EndpointRequestDto request, UUID id) {
        if (endpointRepository.existsById(id)){
            throw new IllegalArgumentException(
                    "Endpoint doesn't exist"
            );
        }

//        @Column(nullable = false)
//        private String name;
//
//        @Column(nullable = false, unique = true)
//        private String url;
//
//        @Column(nullable = false)
//        private String method;
//
//        @Column(nullable = false)
//        private int intervalSeconds;
//
//        @Column(nullable = false)
//        private int expectedStatus;
//
//        @Column(nullable = false)
//        private boolean isActive;
//
//        @Column(nullable = false, updatable = false)
//        private LocalDateTime createdAt;

        Endpoint endpoint = endpointMapper.toEntity(request);

        endpoint.setName(request.name());
        endpoint.setUrl(request.url());
        endpoint.setMethod(request.method());
        endpoint.setIntervalSeconds(request.intervalSeconds());
        endpoint.setExpectedStatus(request.expectedStatus());
        endpoint.setActive(request.active());


        endpoint = endpointRepository.save(endpoint);

        return endpointMapper.toDto(endpoint);

    }


//    PATCH  /api/endpoints/{id}/toggle   Turn monitoring on or off
    @Override
    public EndpointResponseDto toggleMonitoring(UUID id) {
        Endpoint endpoint = endpointRepository.findById(id)
                .orElseThrow(() -> new EndpointNotFoundException(
                        "Endpoint not found with id: " + id
                ));

        endpoint.setActive(!endpoint.isActive());

        endpointRepository.save(endpoint);

        return endpointMapper.toDto(endpoint);
    }


    //    DELETE /api/endpoints/{id}     Stop monitoring and delete
    @Override
    public void deleteEndpoint(UUID id) {
        Endpoint endpoint = endpointRepository.findById(id)
                .orElseThrow(() -> new EndpointNotFoundException(
                        "Endpoint not found with id: " + id
                ));

        // Delete all results records from database
        resultsRepository.deleteAllByEndpointId(id);

        // Delete the endpoint in the database
        endpointRepository.delete(endpoint);
    }
}
