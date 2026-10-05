package com.nemo.api_health_monitor.service.impl;

import com.nemo.api_health_monitor.domain.dto.EndpointResponseDto;
import com.nemo.api_health_monitor.domain.entity.Endpoint;
import com.nemo.api_health_monitor.repository.EndpointRepository;
import com.nemo.api_health_monitor.service.EndpointService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class EndpointServiceImpl implements EndpointService {
    private final EndpointRepository endpointRepository;

    public EndpointServiceImpl(EndpointRepository endpointRepository) {
        this.endpointRepository = endpointRepository;
    }

    @Override
    public List<EndpointResponseDto> listAllEndpoints() {
        List<Endpoint> endpoints = endpointRepository.findAll();
        return endpoints.stream().map(endpoint -> {
//            return
        });
    }

    @Override
    public EndpointResponseDto getEndpoint(UUID id) {
        Endpoint endpoint = endpointRepository.findById(id)
                .orElseThrow(new )
    }
}
