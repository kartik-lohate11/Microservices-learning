package com.service.loan.dto;

import java.time.LocalDate;

public record OrderEventDto(
        Long id,
        String orderName,
        String orderType,
        LocalDate assignDate
) {
}
