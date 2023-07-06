package org.example.repository;

import org.example.entity.client.UserClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserClientRepository extends JpaRepository<UserClient,Long> {
}
