package com.project.spring.learn.services.model.rules;

import com.project.spring.learn.common.utilities.exception.BusinessException;
import com.project.spring.learn.repositories.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelBusinessRules {
    private ModelRepository modelRepository;

    public void checkIfModelIdExists(Long modelId) {
        if (modelRepository.existsById(modelId)) {
            throw new BusinessException("Model name already exists");
        }
    }
}
