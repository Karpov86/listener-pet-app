package com.example.demo.dao.repository;

import com.example.demo.dao.model.TotalAmount;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TotalAmountRepository extends MongoRepository<TotalAmount, String> {

    Optional<TotalAmount> findByCustomerId(String customerId);

}
