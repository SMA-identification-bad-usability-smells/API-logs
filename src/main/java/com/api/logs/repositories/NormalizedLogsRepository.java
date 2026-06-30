package com.api.logs.repositories;

import com.api.logs.domain.logs.Logs;
import com.api.logs.domain.normalizedlogs.NormalizedLogs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NormalizedLogsRepository extends JpaRepository<NormalizedLogs, Long> {}
