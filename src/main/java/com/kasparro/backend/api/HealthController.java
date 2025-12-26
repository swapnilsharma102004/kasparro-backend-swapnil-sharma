package com.kasparro.backend.api;

import com.kasparro.backend.dto.HealthStatusRequest;
import com.kasparro.backend.entity.HealthStatus;
import com.kasparro.backend.repository.HealthStatusRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

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
    public HealthStatus save(@Valid @RequestBody HealthStatusRequest request) {

        HealthStatus entity = new HealthStatus(
                request.getStatus(),
                request.getMessage()
        );

        return repository.save(entity);
    }

    @GetMapping("/health/{id}")
    public HealthStatus getById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Health record not found"));
    }
    @DeleteMapping("/health/{id}")
    public String deleteById(@PathVariable Long id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException("Health record not found");
        }

        repository.deleteById(id);
        return "Deleted successfully";
    }



}
