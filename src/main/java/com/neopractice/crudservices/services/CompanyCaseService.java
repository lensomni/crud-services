package com.neopractice.crudservices.services;

import com.neopractice.crudservices.models.CompanyCase;
import com.neopractice.crudservices.repositories.CompanyCaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyCaseService {
    private final CompanyCaseRepository repository;

    public CompanyCaseService(CompanyCaseRepository repository) {
        this.repository = repository;
    }

    public CompanyCase create(CompanyCase companyCase) {
        return repository.save(companyCase);
    }

    public List<CompanyCase> findAll() {
        return repository.findAll();
    }

    public Optional<CompanyCase> findById(Long id) {
        return repository.findById(id);
    }

    public CompanyCase update(Long id, CompanyCase companyCase) {
        CompanyCase existing = repository.findById(id).orElseThrow();
        existing.setStatusRecord(companyCase.getStatusRecord());
        existing.setIdType(companyCase.getIdType());
        existing.setRowId(companyCase.getRowId());
        existing.setDate(companyCase.getDate());
        existing.setCountLine(companyCase.getCountLine());
        existing.setCaseId(companyCase.getCaseId());
        existing.setAttemptId(companyCase.getAttemptId());
        existing.setSystemDttm(companyCase.getSystemDttm());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
