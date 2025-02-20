package com.consultoria.ecommerce_api.domain.use_cases.category;

import com.consultoria.ecommerce_api.domain.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteCategoryUseCase {
    private final CategoryRepository categoryRepository;

    public void execute(UUID id) {
        categoryRepository.deleteById(id);
    }
}
