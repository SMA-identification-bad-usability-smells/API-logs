package com.api.logs.repositories;

import com.api.logs.domain.logs.Logs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogsRepository extends JpaRepository<Logs, Long> {
    public List<Logs> findByNormalized(boolean normalized);

    public List<Logs> findByUser(Long user);
}
