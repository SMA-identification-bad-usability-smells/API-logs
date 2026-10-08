package com.api.logs.services.logs;

import com.api.logs.domain.logs.Logs;
import com.api.logs.domain.logs.LogsEntryDTO;

import java.util.List;

public interface LogsService {
    void createLogs(List<LogsEntryDTO> newLogs);

    List<Logs> getAllLogs();

    List<Logs> getAllLogsByUser(Long user);

    List<Logs> getAllUncheckedLogs(boolean normalized);

    List<Logs> getAllUncheckedLogsByUser(Long user, boolean normalized);

    void markLogsAsReceived(List<Long> idsList);
}
