package com.site.aspect_oriented_programming.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class Payment {

    private String id;
    private BigDecimal amount;
    private String currency;
    private String status;
}