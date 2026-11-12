package com.site.aspect_oriented_programming.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class PaymentRequest {

    private BigDecimal amount;
    private String currency;
}