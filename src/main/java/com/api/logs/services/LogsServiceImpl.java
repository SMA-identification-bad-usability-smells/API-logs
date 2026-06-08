package com.api.logs.services;

import com.api.logs.domain.logs.Logs;
import com.api.logs.domain.logs.LogsDTO;
import com.api.logs.repositories.LogsRepository;
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
public class LogsServiceImpl implements LogsService{
    @Autowired
    private LogsRepository logsRepository;

    @Override
    public void createLogs(LogsDTO newLogsDTO) {
        try{
            List<Logs> logs = parseLogString(newLogsDTO.getContent());
            logs.forEach(log ->
                    logsRepository.save(log));
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

    public static List<Logs> parseLogString(String jsonLogs) {
        List<Logs> resultList = new ArrayList<>();

        String regex = "\"type\":\"([^\"]+)\",\"timestamp\":\"([^\"]+)\",\"coordinates\":\\{\"x\":([\\d.]+),\"y\":([\\d.]+)\\}(?:,\"targetElementId\":\"?([^\",}]+)\"?)?(?:,\"direction\":\"?([^\",}]+)\"?)?";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(jsonLogs);

        while (matcher.find()) {
            String type = matcher.group(1);
            String timestamp = matcher.group(2);
            float x = (float) Double.parseDouble(matcher.group(3));
            float y = (float) Double.parseDouble(matcher.group(4));
            String targetElementId = matcher.group(5);
            String direction = matcher.group(6);

            resultList.add(
                    new Logs(
                            type,
                            timestampConverter(timestamp),
                            x,
                            y,
                            direction,
                            targetElementId
                    )
            );
        }

        return resultList;
    }

    public static LocalDateTime timestampConverter(String timestamp){
        Instant instant = Instant.parse(timestamp);

        return LocalDateTime.ofInstant(instant, ZoneId.of("UTC"));
    }
}
