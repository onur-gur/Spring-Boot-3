package com.project.spring.learn.services.brand;

import com.project.spring.learn.common.utilities.mappers.ModelMapperService;
import com.project.spring.learn.entities.Brand;
import com.project.spring.learn.repositories.BrandRepository;
import com.project.spring.learn.services.brand.dto.CreateBrandRequest;
import com.project.spring.learn.services.brand.dto.UpdateBrandRequest;
import com.project.spring.learn.services.brand.dto.GetAllBrandsResponse;
import com.project.spring.learn.services.brand.dto.GetByIdBrandsResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ModelMapperService moduleMapperService;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brandList = brandRepository.findAll();

        return brandList
                .stream()
                .map(brand -> moduleMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
    }

    @Override
    public GetByIdBrandsResponse getById(Long id) {
        Brand brand = brandRepository.findById(id).orElseThrow();

        GetByIdBrandsResponse getByIdBrandsResponse = moduleMapperService.forResponse().map(brand, GetByIdBrandsResponse.class);

        return getByIdBrandsResponse;
    }

    @Override
    public void create(CreateBrandRequest createBrandRequest) {
        Brand brand = moduleMapperService.forRequest().map(createBrandRequest, Brand.class);

        brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = moduleMapperService.forRequest().map(updateBrandRequest, Brand.class);
        brandRepository.save(brand);
    }

    @Override
    public void delete(Long id) {
        brandRepository.deleteById(id);
    }
}
