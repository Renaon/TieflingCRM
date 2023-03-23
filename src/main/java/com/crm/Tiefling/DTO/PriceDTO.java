package com.crm.Tiefling.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PriceDTO {
    private final Long id;
    private final String time;
    private final BigDecimal price;
}
