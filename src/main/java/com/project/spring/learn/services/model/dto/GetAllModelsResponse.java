package com.project.spring.learn.services.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllModelsResponse {
    private Long id;
    private String name;
    private String brandName;
}
