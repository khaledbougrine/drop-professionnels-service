package com.dropCar.dropprofessionnelsservice.api;

import com.dropCar.dropprofessionnelsservice.api.dto.CategoryDto;
import com.dropCar.dropprofessionnelsservice.application.create.CreateCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")

public class CategoryController {
    @Autowired
    CreateCategory createCategory;
    @PostMapping("/add")
    public CategoryDto addCategory(@RequestBody CategoryDto categoryDto){

        return createCategory.create(categoryDto);
    }

}
