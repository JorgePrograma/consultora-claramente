package com.consultoria.ecommerce_api.infrastructure.mappers;

import com.consultoria.ecommerce_api.domain.entities.Category;
import com.consultoria.ecommerce_api.infrastructure.models.category.CategoryModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toEntity(CategoryModel categoryModel);

    CategoryModel toModel(Category category);

    List<Category> toEntityList(List<CategoryModel> categoryModel);
}
