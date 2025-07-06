package com.neopractice.crudservices.services;

import com.neopractice.crudservices.models.CompanyArbit;
import com.neopractice.crudservices.repositories.CompanyArbitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyArbitService {
    private final CompanyArbitRepository repository;

    public CompanyArbitService(CompanyArbitRepository repository) {
        this.repository = repository;
    }

    // Создание новой записи
    public CompanyArbit create(CompanyArbit companyArbit) {
        return repository.save(companyArbit);
    }

    // Получение всех записей
    public List<CompanyArbit> findAll() {
        return repository.findAll();
    }

    // Получение записи по ID
    public Optional<CompanyArbit> findById(Long id) {
        return repository.findById(id);
    }

    // Обновление записи
    public CompanyArbit update(Long id, CompanyArbit companyArbit) {
        CompanyArbit existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("CompanyArbit with id " + id + " not found"));
        existing.setStatusRecord(companyArbit.getStatusRecord());
        existing.setIdType(companyArbit.getIdType());
        existing.setRowId(companyArbit.getRowId());
        existing.setDate(companyArbit.getDate());
        existing.setCountLine(companyArbit.getCountLine());
        existing.setCaseId(companyArbit.getCaseId());
        existing.setAttemptId(companyArbit.getAttemptId());
        existing.setSystemDttm(companyArbit.getSystemDttm());
        existing.setNumber(companyArbit.getNumber());
        return repository.save(existing);
    }

    // Удаление записи
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
