package com.api.logs.services;

import com.api.logs.domain.logs.Logs;
import com.api.logs.domain.logs.LogsDTO;
import com.api.logs.repositories.LogsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LogsServiceImpl implements LogsService{
    @Autowired
    private LogsRepository logsRepository;

    @Override
    public Logs createLogs(LogsDTO newLogsDTO) {
        try{
            Logs newLogs = new Logs(
                    newLogsDTO.getContent()
            );
            return logsRepository.save(newLogs);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
