package com.service.message.dto;

import java.time.LocalDate;

public record OrderEventDto(
        Long id,
        String orderName,
        String orderType,
        LocalDate assignDate
) {
}
