package com.api.logs.repositories;

import com.api.logs.domain.logs.Logs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogsRepository extends JpaRepository<Logs, Long> {}
