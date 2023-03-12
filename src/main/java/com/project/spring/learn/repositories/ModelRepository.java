package com.project.spring.learn.repositories;

import com.project.spring.learn.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
