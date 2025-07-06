package com.neopractice.crudservices.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record CompanyCaseDto(
        Integer statusrecord,
        String idtype,
        @JsonProperty("row_id") String rowId,
        LocalDate date,
        @JsonProperty("count_line") String countLine,
        String caseid,
        @JsonProperty("attempt_id") Integer attemptId,
        @JsonProperty("system_dttm") String systemDttm,
        @JsonProperty("operdate") LocalDate operdate
) {
}