package com.project.spring.learn.services.car;

import com.project.spring.learn.common.utilities.mappers.ModelMapperService;
import com.project.spring.learn.entities.Car;
import com.project.spring.learn.repositories.CarRepository;
import com.project.spring.learn.services.car.dto.CreateCarRequest;
import com.project.spring.learn.services.car.dto.GetAllCarsResponse;
import com.project.spring.learn.services.car.dto.GetByIdCarResponse;
import com.project.spring.learn.services.car.dto.UpdateCarRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ModelMapperService moduleMapperService;

    @Override
    public List<GetAllCarsResponse> getAll() {
        List<Car> carList = carRepository.findAll();

        List<GetAllCarsResponse> getAllCarsResponses = carList.stream().map(car -> moduleMapperService.forResponse().map(car, GetAllCarsResponse.class)).collect(Collectors.toList());

        return getAllCarsResponses;
    }

    @Override
    public GetByIdCarResponse getById(Long id) {
        Car car = carRepository.findById(id).orElseThrow();

        GetByIdCarResponse getByIdCarResponse = moduleMapperService.forResponse().map(car, GetByIdCarResponse.class);

        return getByIdCarResponse;
    }

    @Override
    public void create(CreateCarRequest createBrandRequest) {
        Car car = moduleMapperService.forRequest().map(createBrandRequest, Car.class);
        carRepository.save(car);
    }

    @Override
    public void update(UpdateCarRequest updateBrandRequest) {
        Car car = moduleMapperService.forRequest().map(updateBrandRequest, Car.class);
        carRepository.save(car);
    }

    @Override
    public void delete(Long id) {
        carRepository.deleteById(id);
    }
}
