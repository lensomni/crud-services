package com.neopractice.crudservices.services;

import com.neopractice.crudservices.dto.CompanyArbitDto;
import com.neopractice.crudservices.dto.CompanyCaseDto;
import com.neopractice.crudservices.models.CompanyArbit;
import com.neopractice.crudservices.models.CompanyCase;
import com.neopractice.crudservices.repositories.CompanyArbitRepository;
import com.neopractice.crudservices.repositories.CompanyCaseRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    private final CompanyCaseRepository caseRepository;
    private final CompanyArbitRepository arbitRepository;

    public KafkaConsumerService(CompanyCaseRepository caseRepository, CompanyArbitRepository arbitRepository) {
        this.caseRepository = caseRepository;
        this.arbitRepository = arbitRepository;
    }

    @KafkaListener(topics = "topic1", groupId = "kafka-crud-group")
    public void listenTopic1(CompanyCaseDto dto) {
        CompanyCase companyCase = new CompanyCase();
        companyCase.setStatusRecord(dto.statusrecord());
        companyCase.setIdType(dto.idtype());
        companyCase.setRowId(dto.rowId());
        companyCase.setDate(dto.date());
        companyCase.setCountLine(dto.countLine());
        companyCase.setCaseId(dto.caseid());
        companyCase.setAttemptId(dto.attemptId());
        companyCase.setSystemDttm(dto.systemDttm());
        // companyCase.setOperdate(dto.operdate());
        caseRepository.save(companyCase);
    }

    @KafkaListener(topics = "topic2", groupId = "kafka-crud-group")
    public void listenTopic2(CompanyArbitDto dto) {
        CompanyArbit companyArbit = new CompanyArbit();
        companyArbit.setStatusRecord(dto.statusrecord());
        companyArbit.setIdType(dto.idtype());
        companyArbit.setRowId(dto.rowId());
        companyArbit.setDate(dto.date());
        companyArbit.setCountLine(dto.countLine());
        companyArbit.setCaseId(dto.caseid());
        companyArbit.setAttemptId(dto.attemptId());
        companyArbit.setSystemDttm(dto.systemDttm());
        companyArbit.setNumber(dto.number());
        // companyArbit.setOperdate(dto.operdate());
        // companyArbit.setCompletedate(dto.completedate());
        arbitRepository.save(companyArbit);
    }
}