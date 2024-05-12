package com.example.demo.service;

import com.example.demo.dao.model.TotalAmount;
import com.example.demo.dao.repository.TotalAmountRepository;
import com.example.demo.dto.Payment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final TotalAmountRepository totalAmountRepository;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "payment-topic", groupId = "message-group")
    public void consume(String jsonPayment) {
        try {
            var payment = objectMapper.readValue(jsonPayment, Payment.class);

            var totalAmount = totalAmountRepository.findByCustomerId(payment.customerId())
                    .orElse(new TotalAmount()
                            .setCustomerId(payment.customerId())
                            .setTotal(0D)
                            .setCount(0L));

            totalAmount.setTotal(totalAmount.getTotal() + payment.amount());
            totalAmount.setCount(totalAmount.getCount() + 1L);
            totalAmount.setLastUpdateTime(LocalDateTime.now());

            totalAmountRepository.save(totalAmount);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
    }
}
