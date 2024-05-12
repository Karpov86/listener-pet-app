package com.example.demo.dto;

import java.time.LocalDateTime;

public record Payment(
        String id,
        String customerId,
        double amount,
        LocalDateTime createDate
) {

}
