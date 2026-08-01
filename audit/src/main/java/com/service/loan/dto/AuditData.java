package com.service.loan.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AuditData{
    String name;
    LocalDate date;
    String owner;
}
