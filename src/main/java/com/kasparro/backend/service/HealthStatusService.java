package com.kasparro.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kasparro.backend.dto.HealthStatusRequest;
import com.kasparro.backend.entity.HealthStatus;
import com.kasparro.backend.repository.HealthStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthStatusService {

    private final HealthStatusRepository repository;

    public HealthStatusService(HealthStatusRepository repository) {
        this.repository = repository;
    }

    public HealthStatus save(HealthStatusRequest request) {
        HealthStatus entity = new HealthStatus(
                request.getStatus(),
                request.getMessage()
        );
        return repository.save(entity);
    }
    public Page<HealthStatus> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<HealthStatus> getAll() {
        return repository.findAll();
    }
    public HealthStatus getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Health record not found"));
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Health record not found");
        }
        repository.deleteById(id);
    }

}
