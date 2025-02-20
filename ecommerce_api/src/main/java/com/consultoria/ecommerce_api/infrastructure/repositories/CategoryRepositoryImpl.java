package com.consultoria.ecommerce_api.infrastructure.repositories;

import com.consultoria.ecommerce_api.domain.entities.Category;
import com.consultoria.ecommerce_api.domain.repositories.CategoryRepository;
import com.consultoria.ecommerce_api.infrastructure.datasources.CategoryDatasource;
import com.consultoria.ecommerce_api.infrastructure.mappers.CategoryMapper;
import com.consultoria.ecommerce_api.infrastructure.models.category.CategoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    @Autowired
    private CategoryDatasource categoryDatasource;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Category save(Category category) {
        CategoryModel model = categoryMapper.toModel(category);
        CategoryModel result = categoryDatasource.save(model);
        return categoryMapper.toEntity(result);
    }

    @Override
    public void deleteById(UUID id) {
        categoryDatasource.deleteById(id);
    }

    @Override
    public Category update(Category category) {
        return categoryMapper.toEntity(categoryDatasource.save(categoryMapper.toModel(category)));
    }

    @Override
    public List<Category> findAll() {
        return categoryMapper.toEntityList(categoryDatasource.findAll());
    }

    @Override
    public Optional<Category> findByName(String name) {
        System.out.println("categoria a busca" + name);
        return categoryDatasource.findByNameIgnoreCase(name).map(categoryMapper::toEntity);
    }

    @Override
    public Optional<Category> findById(UUID id) {
        return categoryDatasource.findById(id).map(categoryMapper::toEntity);
    }
}
