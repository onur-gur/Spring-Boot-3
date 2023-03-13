package com.project.spring.learn.services.model;

import com.project.spring.learn.common.utilities.mappers.ModelMapperService;
import com.project.spring.learn.entities.Model;
import com.project.spring.learn.repositories.ModelRepository;
import com.project.spring.learn.services.brand.rules.BrandBusinessRules;
import com.project.spring.learn.services.model.dto.CreateModelRequest;
import com.project.spring.learn.services.model.dto.GetAllModelsResponse;
import com.project.spring.learn.services.model.dto.GetByIdModelResponse;
import com.project.spring.learn.services.model.dto.UpdateModelRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelServiceImpl implements ModelService {
    @Autowired
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> modelList = modelRepository.findAll();
        List<GetAllModelsResponse> getAllModelsResponses = modelList.stream().map(model -> modelMapperService.forResponse().map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
        return getAllModelsResponses;
    }

    @Override
    public GetByIdModelResponse getById(Long id) {
        Model model = modelRepository.findById(id).orElseThrow();
        GetByIdModelResponse getByIdModelResponse = modelMapperService.forResponse().map(model, GetByIdModelResponse.class);
        return getByIdModelResponse;
    }

    @Override
    public void create(CreateModelRequest createModelRequest) {
        brandBusinessRules.checkIfBrandIdExists(createModelRequest.getBrandId());
        Model model = modelMapperService.forRequest().map(createModelRequest, Model.class);
        modelRepository.save(model);
    }

    @Override
    public void update(UpdateModelRequest updateModelRequest) {
        Model model = modelMapperService.forRequest().map(updateModelRequest, Model.class);
        modelRepository.save(model);
    }

    @Override
    public void delete(Long id) {
        modelRepository.deleteById(id);
    }
}