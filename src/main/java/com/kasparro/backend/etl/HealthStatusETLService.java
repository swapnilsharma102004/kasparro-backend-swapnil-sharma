package com.kasparro.backend.etl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kasparro.backend.entity.HealthStatus;
import com.kasparro.backend.repository.HealthStatusRepository;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class HealthStatusETLService {

    private final HealthStatusRepository repository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public HealthStatusETLService(HealthStatusRepository repository) {
        this.repository = repository;
    }

    public void runETL() throws Exception {

        // EXTRACT
        InputStream inputStream =
                getClass().getResourceAsStream("/data/health_data.json");

        List<HealthStatusETLRequest> records =
                objectMapper.readValue(
                        inputStream,
                        new TypeReference<>() {}
                );

        // TRANSFORM + LOAD
        for (HealthStatusETLRequest r : records) {
            HealthStatus entity =
                    new HealthStatus(r.getStatus(), r.getMessage());
            repository.save(entity);
        }
    }
}

