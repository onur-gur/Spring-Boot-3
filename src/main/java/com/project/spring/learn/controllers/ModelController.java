package com.project.spring.learn.controllers;

import com.project.spring.learn.services.model.ModelService;
import com.project.spring.learn.services.model.dto.CreateModelRequest;
import com.project.spring.learn.services.model.dto.GetAllModelsResponse;
import com.project.spring.learn.services.model.dto.GetByIdModelResponse;
import com.project.spring.learn.services.model.dto.UpdateModelRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("api/v1/models")
@AllArgsConstructor
public class ModelController {
    @Autowired
    private ModelService modelService;

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllModelsResponse> getAll() {
        return modelService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)

    public GetByIdModelResponse getById(@PathVariable Long id) {
        return modelService.getById(id);
    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid CreateModelRequest request) {
        modelService.create(request);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody @Valid UpdateModelRequest request) {
        modelService.update(request);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        modelService.delete(id);
    }
}
