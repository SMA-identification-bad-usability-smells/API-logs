package com.api.logs.services.logs;

import com.api.logs.domain.logs.Logs;
import com.api.logs.domain.logs.LogsEntryDTO;
import com.api.logs.repositories.LogsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class LogsServiceImpl implements LogsService{
    @Autowired
    private LogsRepository logsRepository;

    @Override
    public void createLogs(List<LogsEntryDTO> newLogsDTO) {
        try{
            List<Logs> logs = newLogsDTO.stream().map(
                    log ->
                         new Logs(
                                log.getUser(),
                                log.getType(),
                                log.getTimestamp(),
                                log.getCoordinatesX(),
                                log.getCoordinatesY(),
                                log.getDirection(),
                                log.getTargetElementId()
                        )
                    ).toList();
            logs.forEach(logsRepository::save);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Logs> getAllLogs() {
        try{
            return logsRepository.findAll();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Logs> getAllLogsByUser(Long user) {
        try {
            return logsRepository.findByUser(user);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Logs> getAllUncheckedLogs(boolean normalized) {
        try {
            return logsRepository.findByNormalized(normalized);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Logs> getAllUncheckedLogsByUser(Long user, boolean normalized) {
        try {
            return logsRepository.findByUser(user).stream()
                    .filter( log -> log.getNormalized() == normalized)
                    .toList();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void markLogsAsReceived(List<Long> idsList) {
        try {
            idsList.forEach( id -> {
                var log = logsRepository.findById(id).orElse(null);

                if(log != null){
                    log.setNormalized(true);
                    logsRepository.save(log);
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
