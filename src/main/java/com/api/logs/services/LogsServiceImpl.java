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

    public static List<Logs> parseLogString(String jsonLogs) {
        List<Logs> resultList = new ArrayList<>();

        String regex = "\"type\":\"([^\"]+)\",\"timestamp\":\"([^\"]+)\",\"coordinates\":\\{\"x\":(\\d+),\"y\":(\\d+)\\},\"targetElementId\":\"([^\"]+)\"";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(jsonLogs);

        while (matcher.find()) {
            String type = matcher.group(1);
            String timestamp = matcher.group(2);
            int x = Integer.parseInt(matcher.group(3));
            int y = Integer.parseInt(matcher.group(4));
            String targetElementId = matcher.group(5);

            resultList.add(
                    new Logs(
                            type,
                            timestampConverter(timestamp),
                            x,
                            y,
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
