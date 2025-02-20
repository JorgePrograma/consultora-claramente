package com.consultoria.ecommerce_api.domain.use_cases.category;

import com.consultoria.ecommerce_api.domain.entities.Category;
import com.consultoria.ecommerce_api.domain.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllCategoriesUseCase {

    private final CategoryRepository categoryRepository;

    public List<Category> execute() {
        return categoryRepository.findAll();
    }
}
