package com.project.spring.learn.services.car.dto;

import com.project.spring.learn.entities.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdCarResponse {
    private Long id;
    private String plate;
    private BigDecimal dailyPrice;
    private Integer modelYear;
    private State state;
    private String modelName;
}
