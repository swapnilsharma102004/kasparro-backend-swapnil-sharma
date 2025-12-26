package com.kasparro.backend.api;

import com.kasparro.backend.dto.HealthStatusRequest;
import com.kasparro.backend.entity.HealthStatus;
import com.kasparro.backend.service.HealthStatusService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class HealthController {

    private final HealthStatusService service;

    public HealthController(HealthStatusService service) {
        this.service = service;
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of(
                "status", "up",
                "message", "Backend is Running"
        );
    }

    @GetMapping("/health/all")
    public Page<HealthStatus> getAll(
            @org.springframework.data.web.PageableDefault(
                    page = 0,
                    size = 5,
                    sort = "id",
                    direction = org.springframework.data.domain.Sort.Direction.DESC
            ) Pageable pageable
    ) {
        return service.getAll(pageable);
    }


    @PostMapping("/health/save")
    public ResponseEntity<HealthStatus> save(
            @Valid @RequestBody HealthStatusRequest request) {

        HealthStatus saved = service.save(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(saved);
    }


    @GetMapping("/health/{id}")
    public HealthStatus getById(@PathVariable Long id) {
        return service.getById(id);
    }


    @DeleteMapping("/health/{id}")
    public String deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return "Deleted successfully";
    }
}
