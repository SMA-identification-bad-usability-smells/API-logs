package com.api.logs.controllers;

import com.api.logs.domain.logs.Logs;
import com.api.logs.domain.normalizedlogs.NormalizedLogsDTO;
import com.api.logs.services.normalizedlogs.NormalizedLogsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/normalizedlogs")
@CrossOrigin(origins = "*")
public class NormalizedLogsController {
    @Autowired
    private final NormalizedLogsService normalizedLogsService;

    public NormalizedLogsController(NormalizedLogsService normalizedLogsService) {
        this.normalizedLogsService = normalizedLogsService;
    }

    @PostMapping("/all")
    public ResponseEntity<EntityModel<Logs>> createAllNormalizedLogs(@RequestBody @Valid List<NormalizedLogsDTO> normalizedLogsDTOList){
        normalizedLogsService.createAllNormalizedLogs(normalizedLogsDTOList);
        return ResponseEntity.ok().build();
    }
}
