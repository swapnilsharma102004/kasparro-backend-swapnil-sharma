package com.kasparro.backend.api;

import com.kasparro.backend.entity.HealthStatus;
import com.kasparro.backend.repository.HealthStatusRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class HealthController {

    private final HealthStatusRepository repository;

    public HealthController(HealthStatusRepository repository){
        this.repository=repository;
    }
    @GetMapping("/health")
    public Map<String,String> health(){

        return Map.of(
                "status","up",
                "message","Backend is Running"
        );
    }
    @GetMapping("/health/all")
    public List<HealthStatus> getAll() {
        return repository.findAll();
    }

    @PostMapping("/health/save")
    public HealthStatus saveHealth() {
        HealthStatus status =
                new HealthStatus("UP", "Backend is running");

        return repository.save(status);
    }


}
