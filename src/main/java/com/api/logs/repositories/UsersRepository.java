package com.api.logs.repositories;

import com.api.logs.domain.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersRepository extends JpaRepository<Users, Long> {
}
