package com.service.loan.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderData {
    String orderName;
    String orderType;
    LocalDate date;


}
