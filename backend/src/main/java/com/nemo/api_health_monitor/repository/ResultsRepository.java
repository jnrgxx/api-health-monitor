package com.nemo.api_health_monitor.repository;

import com.nemo.api_health_monitor.domain.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ResultsRepository extends JpaRepository<Result, UUID> {

    void deleteAllByEndpointId(UUID endpointId);
}
