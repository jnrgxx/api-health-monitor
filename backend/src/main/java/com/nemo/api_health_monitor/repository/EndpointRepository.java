package com.nemo.api_health_monitor.repository;

import com.nemo.api_health_monitor.domain.entity.Endpoint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EndpointRepository extends JpaRepository<Endpoint, UUID> {
    Optional<Endpoint> findByName(String name); // Spring Data JPA automatically implements this based on the method name — it generates `SELECT * FROM buckets WHERE name = ?`

    boolean existsByUrl(String url); // Same pattern, returns true/false


}
