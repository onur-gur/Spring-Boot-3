package com.project.spring.learn.services.brand.rules;

import com.project.spring.learn.common.utilities.exception.BusinessException;
import com.project.spring.learn.repositories.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandBusinessRules {
    //not necessary @Autowired
    private BrandRepository brandRepository;
    public void checkIfBrandNameExists(String name){
        if(brandRepository.existsByName(name)){
            throw new BusinessException("Brand name already exists");
        }
    }
}
