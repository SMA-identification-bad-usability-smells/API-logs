package com.api.logs.services.normalizedlogs;

import com.api.logs.domain.normalizedlogs.NormalizedLogs;
import com.api.logs.domain.normalizedlogs.NormalizedLogsDTO;

import java.util.List;

public interface NormalizedLogsService {
    void createNormalizedLog(NormalizedLogs newNormalizedLogs);

    void createAllNormalizedLogs(List<NormalizedLogsDTO> normalizedLogsDTOList);

    List<NormalizedLogs> getAllNormalizedLogs();

}
