package com.project.spring.learn.controllers;

import com.project.spring.learn.services.brand.BrandService;
import com.project.spring.learn.services.brand.dto.CreateBrandRequest;
import com.project.spring.learn.services.brand.dto.GetAllBrandsResponse;
import com.project.spring.learn.services.brand.dto.GetByIdBrandsResponse;
import com.project.spring.learn.services.brand.dto.UpdateBrandRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/brands")
@AllArgsConstructor
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllBrandsResponse> getAll() {
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetByIdBrandsResponse getById(@PathVariable Long id) {
        return brandService.getById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid CreateBrandRequest createBrandRequest){
        brandService.create(createBrandRequest);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody @Valid UpdateBrandRequest updateBrandRequest){
        brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        brandService.delete(id);
    }
}
