package com.project.spring.learn.services.car;

import com.project.spring.learn.services.car.dto.CreateCarRequest;
import com.project.spring.learn.services.car.dto.GetAllCarsResponse;
import com.project.spring.learn.services.car.dto.GetByIdCarResponse;
import com.project.spring.learn.services.car.dto.UpdateCarRequest;

import java.util.List;

public interface CarService {
    List<GetAllCarsResponse> getAll();
    GetByIdCarResponse getById(Long id);
    void create(CreateCarRequest createBrandRequest);
    void update(UpdateCarRequest updateBrandRequest);
    void delete(Long id);
}
