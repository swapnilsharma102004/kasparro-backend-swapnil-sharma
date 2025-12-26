package com.kasparro.backend.api;

import com.kasparro.backend.etl.HealthStatusETLService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ETLController {

    private final HealthStatusETLService etlService;

    public ETLController(HealthStatusETLService etlService) {
        this.etlService = etlService;
    }

    @GetMapping("/etl/run")
    public String runETL() throws Exception {
        etlService.runETL();
        return "ETL executed successfully";
    }
}
