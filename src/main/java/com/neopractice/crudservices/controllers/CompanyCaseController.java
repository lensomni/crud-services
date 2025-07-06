package com.neopractice.crudservices.controllers;

import com.neopractice.crudservices.models.CompanyCase;
import com.neopractice.crudservices.services.CompanyCaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company-cases")
public class CompanyCaseController {
    private final CompanyCaseService service;

    public CompanyCaseController(CompanyCaseService service) {
        this.service = service;
    }

    @PostMapping
    public CompanyCase create(@RequestBody CompanyCase companyCase) {
        return service.create(companyCase);
    }

    @GetMapping
    public List<CompanyCase> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyCase> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public CompanyCase update(@PathVariable Long id, @RequestBody CompanyCase companyCase) {
        return service.update(id, companyCase);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
