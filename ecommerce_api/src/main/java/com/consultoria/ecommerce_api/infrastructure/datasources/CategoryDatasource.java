package com.consultoria.ecommerce_api.infrastructure.datasources;

import com.consultoria.ecommerce_api.infrastructure.models.category.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CategoryDatasource extends JpaRepository<CategoryModel, UUID> {
    Optional<CategoryModel> findByNameIgnoreCase(String name);
}