package com.api.logs.controllers;

import com.api.logs.assemblers.LogsModelAssembler;
import com.api.logs.domain.logs.Logs;
import com.api.logs.domain.logs.LogsDTO;
import com.api.logs.domain.logs.LogsIdsDTO;
import com.api.logs.services.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/logs")
@CrossOrigin(origins = "*")
public class LogsController {
    @Autowired
    private final LogsModelAssembler assembler;
    @Autowired
    private final LogsService logsService;

    public LogsController(LogsModelAssembler assembler, LogsService logsService) {
        this.assembler = assembler;
        this.logsService = logsService;
    }

    @PostMapping("")
    public ResponseEntity<EntityModel<Logs>> createLog(@RequestBody @Valid LogsDTO newLogsDTO){
        logsService.createLogs(newLogsDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public CollectionModel<EntityModel<Logs>> getAllLogs(){
        List<EntityModel<Logs>> logsEntityModel = logsService.getAllLogs().stream()
                .map(assembler::toModel)
                .toList();
        return CollectionModel.of(logsEntityModel);
    }

    @PutMapping("/ids/all")
    public void markLogsAsReceived(@RequestBody LogsIdsDTO logsIdsDTO){
        try {
            List<Long> idsList = Arrays.stream(logsIdsDTO.getListLogsIds().split(","))
                    .map(Long::parseLong)
                    .toList();

            logsService.markLogsAsReceived(idsList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
