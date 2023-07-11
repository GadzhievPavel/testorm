package org.example.repository;

import org.example.entity.client.UserClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserClientRepository extends CrudRepository<UserClient,Long> {
}
