package com.nemo.api_health_monitor.repository;

import com.nemo.api_health_monitor.domain.entity.MonitoredEndpoint;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface MonitoredEndpointRepository extends JpaRepository<MonitoredEndpoint, UUID> {

}
