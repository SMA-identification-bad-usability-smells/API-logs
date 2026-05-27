package com.api.logs.services;

import com.api.logs.domain.logs.Logs;
import com.api.logs.domain.logs.LogsDTO;

public interface LogsService {
    Logs createLogs(LogsDTO newLogs);
}
