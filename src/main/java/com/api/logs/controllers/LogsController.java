package com.api.logs.controllers;

import com.api.logs.assemblers.LogsModelAssembler;
import com.api.logs.domain.logs.Logs;
import com.api.logs.domain.logs.LogsDTO;
import com.api.logs.repositories.LogsRepository;
import com.api.logs.services.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/logs")
public class LogsController {
    @Autowired
    private final LogsModelAssembler assembler;
    @Autowired
    private final LogsService logsService;

    public LogsController(LogsModelAssembler assembler, LogsService logsService) {
        this.assembler = assembler;
        this.logsService = logsService;
    }

    @PostMapping("/")
    public ResponseEntity<EntityModel<Logs>> createLog(@RequestBody @Valid LogsDTO newLogsDTO){
        Logs newLogs = logsService.createLogs(newLogsDTO);
        return ResponseEntity.ok(assembler.toModel(newLogs));
    }
}
