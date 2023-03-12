package com.project.spring.learn.services.model;

import com.project.spring.learn.services.model.dto.CreateModelRequest;
import com.project.spring.learn.services.model.dto.GetAllModelsResponse;
import com.project.spring.learn.services.model.dto.GetByIdModelResponse;
import com.project.spring.learn.services.model.dto.UpdateModelRequest;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    GetByIdModelResponse getById(Long id);
    void create(CreateModelRequest createBrandRequest);
    void update(UpdateModelRequest updateBrandRequest);
    void delete(Long id);
}
