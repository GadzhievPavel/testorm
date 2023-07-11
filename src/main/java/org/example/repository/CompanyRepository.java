package org.example.repository;

import org.example.entity.client.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

public interface CompanyRepository extends CrudRepository<Company,Long> {
    public List<Company> getCompaniesByName(String name);

    public List<Company> getCompaniesByNameContaining(String name);
}
