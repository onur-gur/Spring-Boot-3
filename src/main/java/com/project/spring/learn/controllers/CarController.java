package com.project.spring.learn.controllers;

import com.project.spring.learn.services.car.CarService;
import com.project.spring.learn.services.car.dto.CreateCarRequest;
import com.project.spring.learn.services.car.dto.GetAllCarsResponse;
import com.project.spring.learn.services.car.dto.GetByIdCarResponse;
import com.project.spring.learn.services.car.dto.UpdateCarRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("api/v1/cars")
@AllArgsConstructor
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/getAll")
    public List<GetAllCarsResponse> getAll() {
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdCarResponse getById(@PathVariable Long id) {
        return carService.getById(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody @Valid CreateCarRequest request) {
        carService.create(request);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateCarRequest request) {
        carService.update(request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        carService.delete(id);
    }

}
