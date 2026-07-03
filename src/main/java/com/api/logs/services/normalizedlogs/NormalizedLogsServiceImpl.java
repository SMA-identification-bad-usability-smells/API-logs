package com.api.logs.services.normalizedlogs;

import com.api.logs.domain.logs.Logs;
import com.api.logs.domain.logs.LogsDTO;
import com.api.logs.domain.normalizedlogs.NormalizedLogs;
import com.api.logs.domain.normalizedlogs.NormalizedLogsDTO;
import com.api.logs.repositories.NormalizedLogsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Slf4j
public class NormalizedLogsServiceImpl implements NormalizedLogsService {
    @Autowired
    private NormalizedLogsRepository normalizedLogsRepository;

    @Override
    public void createNormalizedLog(NormalizedLogs newNormalizedLogs) {
        try{
            normalizedLogsRepository.save(newNormalizedLogs);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createAllNormalizedLogs(List<NormalizedLogsDTO> normalizedLogsDTOList) {
        try {
            System.out.println("[DADOS ARMAZENADOS]: " + normalizedLogsDTOList);
            normalizedLogsDTOList.stream()
                    .map( dto ->
                            new NormalizedLogs(
                                    dto.getId(),
                                    dto.getInteractionType(),
                                    dto.getTime(),
                                    dto.getFrequency(),
                                    dto.getGestureDirection()
                            )
                    )
                    .forEach(normalizedLogsRepository::save);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<NormalizedLogs> getAllNormalizedLogs() {
        return normalizedLogsRepository.findAll().stream().toList();
    }

}
