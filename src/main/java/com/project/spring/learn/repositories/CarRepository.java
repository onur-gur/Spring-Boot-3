package com.project.spring.learn.repositories;

import com.project.spring.learn.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
