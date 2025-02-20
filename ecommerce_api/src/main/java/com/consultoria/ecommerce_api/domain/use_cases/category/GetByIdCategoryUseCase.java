package com.consultoria.ecommerce_api.domain.use_cases.category;

import com.consultoria.ecommerce_api.domain.entities.Category;
import com.consultoria.ecommerce_api.domain.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class GetByIdCategoryUseCase {
    private final CategoryRepository categoryRepository;

    public Optional<Category> execute(UUID id) {
        return categoryRepository.findById(id);
    }
}
