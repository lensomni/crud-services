package com.neopractice.crudservices.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "companycases")
@Data
public class CompanyCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") private Long id;

    @Column(name = "statusrecord") private Integer statusRecord;
    @Column(name = "idtype") private String idType;
    @Column(name = "row_id") private String rowId;
    @Column(name = "date") private LocalDate date;
    @Column(name = "count_line") private String countLine;
    @Column(name = "caseid") private String caseId;
    @Column(name = "attempt_id") private Integer attemptId;
    @Column(name = "system_dttm") private String systemDttm;
}