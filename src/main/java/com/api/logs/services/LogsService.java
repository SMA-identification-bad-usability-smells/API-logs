package com.api.logs.services;

import com.api.logs.domain.logs.Logs;
import com.api.logs.domain.logs.LogsDTO;

import java.util.List;

public interface LogsService {
    void createLogs(LogsDTO newLogs);

    List<Logs> getAllLogs();
}
