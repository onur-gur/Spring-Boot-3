package com.project.spring.learn.services.car.dto;

import com.project.spring.learn.entities.State;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
    @NotNull
    @NotEmpty
    private String plate;
    @NotNull
    @NotEmpty
    @Min(value = 0)
    private BigDecimal dailyPrice;
    @NotNull
    @NotEmpty
    @Min(value = 2010)
    private Integer modelYear;
    @NotNull
    @NotEmpty
    private State state;
    @NotNull
    @NotEmpty
    private Long modelId;
}
