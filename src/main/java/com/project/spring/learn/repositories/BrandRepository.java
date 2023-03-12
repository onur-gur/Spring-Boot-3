package com.project.spring.learn.repositories;

import com.project.spring.learn.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    Boolean existsByName(String name);
}
