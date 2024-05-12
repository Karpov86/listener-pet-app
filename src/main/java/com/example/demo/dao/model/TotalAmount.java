package com.example.demo.dao.model;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Accessors(chain = true)
public class TotalAmount {

    @Id
    private String id;

    private String customerId;
    private Double total;
    private Long count;

    @CreatedDate
    private LocalDateTime lastUpdateTime;
}
