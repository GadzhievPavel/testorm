package org.example.repository;

import org.example.entity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriorityRepository extends CrudRepository<Priority,Long> {
}
