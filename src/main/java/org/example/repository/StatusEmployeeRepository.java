package org.example.repository;

import org.example.entity.StatusEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusEmployeeRepository extends JpaRepository<StatusEmployee,Long> {
}
