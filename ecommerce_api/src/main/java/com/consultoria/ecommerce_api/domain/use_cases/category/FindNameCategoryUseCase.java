package com.consultoria.ecommerce_api.domain.use_cases.category;

import com.consultoria.ecommerce_api.domain.entities.Category;
import com.consultoria.ecommerce_api.domain.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class FindNameCategoryUseCase {
    private final CategoryRepository categoryRepository;

    public Optional<Category> execute(String name) {
        return categoryRepository.findByName(name);
    }
}
