package com.project.spring.learn.services.brand;

import com.project.spring.learn.services.brand.dto.CreateBrandRequest;
import com.project.spring.learn.services.brand.dto.UpdateBrandRequest;
import com.project.spring.learn.services.brand.dto.GetAllBrandsResponse;
import com.project.spring.learn.services.brand.dto.GetByIdBrandsResponse;

import java.util.List;

public interface BrandService{
    List<GetAllBrandsResponse> getAll();
    GetByIdBrandsResponse getById(Long id);
    void create(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(Long id);
}
