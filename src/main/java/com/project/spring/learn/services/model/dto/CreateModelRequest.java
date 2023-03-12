package com.project.spring.learn.services.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateModelRequest {
    @NotNull
    @NotEmpty
    @Size(min = 3,max = 20)
    private String name;
    @NotNull
    @NotEmpty
    private Long brandId;
}
