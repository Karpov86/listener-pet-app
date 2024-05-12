package com.example.demo.controller;

import com.example.demo.dao.model.TotalAmount;
import com.example.demo.dao.repository.TotalAmountRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/total-amounts")
@RequiredArgsConstructor
@Slf4j
public class TotalPaymentController {

    private final TotalAmountRepository totalAmountRepository;

    @GetMapping
    public List<TotalAmount> getAllTotalAmount() {
        return totalAmountRepository.findAll();
    }

}
