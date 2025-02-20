package com.consultoria.ecommerce_api.domain.use_cases.category;

import com.consultoria.ecommerce_api.domain.entities.Category;
import com.consultoria.ecommerce_api.domain.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateCategoryUseCase {
    private final CategoryRepository categoryRepository;

    public Category execute(Category category) {
        return categoryRepository.update(category);
    }

}
