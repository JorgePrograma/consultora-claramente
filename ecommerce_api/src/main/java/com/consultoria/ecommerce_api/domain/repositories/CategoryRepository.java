package com.consultoria.ecommerce_api.domain.repositories;

import com.consultoria.ecommerce_api.domain.entities.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository {
    Category save(Category category);

    void deleteById(UUID id);

    Category update(Category category);

    List<Category> findAll();

    Optional<Category> findByName(String name);

    Optional<Category> findById(UUID id);
}
