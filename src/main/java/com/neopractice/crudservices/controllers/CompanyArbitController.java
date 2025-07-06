package com.neopractice.crudservices.controllers;

import com.neopractice.crudservices.models.CompanyArbit;
import com.neopractice.crudservices.services.CompanyArbitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company-arbits")
public class CompanyArbitController {
    private final CompanyArbitService service;

    public CompanyArbitController(CompanyArbitService service) {
        this.service = service;
    }

    @PostMapping
    public CompanyArbit create(@RequestBody CompanyArbit companyArbit) {
        return service.create(companyArbit);
    }

    @GetMapping
    public List<CompanyArbit> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyArbit> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public CompanyArbit update(@PathVariable Long id, @RequestBody CompanyArbit companyArbit) {
        return service.update(id, companyArbit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
