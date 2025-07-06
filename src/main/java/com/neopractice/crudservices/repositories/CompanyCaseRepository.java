package com.neopractice.crudservices.repositories;

import com.neopractice.crudservices.models.CompanyCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyCaseRepository extends JpaRepository<CompanyCase, Long> {
}

