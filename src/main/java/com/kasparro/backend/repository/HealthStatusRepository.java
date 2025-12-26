package com.kasparro.backend.repository;

import com.kasparro.backend.entity.HealthStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthStatusRepository extends JpaRepository<HealthStatus,Long> {


}
