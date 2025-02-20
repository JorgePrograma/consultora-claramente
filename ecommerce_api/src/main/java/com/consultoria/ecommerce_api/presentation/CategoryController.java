package com.consultoria.ecommerce_api.presentation;

import com.consultoria.ecommerce_api.common.Exceptions.ResourceNotFoundException;
import com.consultoria.ecommerce_api.common.constants.MessageConstants;
import com.consultoria.ecommerce_api.common.constants.RouteApisConstants;
import com.consultoria.ecommerce_api.common.response.ApiResponse;
import com.consultoria.ecommerce_api.common.utils.MessageUtils;
import com.consultoria.ecommerce_api.domain.entities.Category;
import com.consultoria.ecommerce_api.domain.use_cases.category.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(RouteApisConstants.CATEGORY)
@RequiredArgsConstructor
public class CategoryController {

    private final SaveCategoryUseCase saveCategoryUseCase;
    private final GetAllCategoriesUseCase getAllCategoriesUseCase;
    private final GetByIdCategoryUseCase getByIdCategoryUseCase;
    private final FindNameCategoryUseCase findNameCategoryUseCase;
    private final UpdateCategoryUseCase updateCategoryUseCase;
    private final DeleteCategoryUseCase deleteCategoryUseCase;

    @PostMapping
    public ResponseEntity<ApiResponse<Category>> create(@Valid @RequestBody Category category) {
        return isCategoryNameExists(category.getName()).map(existingCategory -> handleDuplicateNameError()).orElseGet(() -> {
            Category savedCategory = saveCategoryUseCase.execute(category);
            String message = MessageUtils.getMessage(MessageConstants.MESSAGE_CREATE, "Categoría");
            return ResponseEntity.ok(ApiResponse.success(message, savedCategory));
        });
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Category>>> getAll() {
        List<Category> categories = getAllCategoriesUseCase.execute();
        String message = MessageUtils.getMessage(MessageConstants.MESSAGE_FOUND, "categorías");
        return ResponseEntity.ok(ApiResponse.success(message, categories));
    }

    @GetMapping(RouteApisConstants.ID_IN_PATH)
    public ResponseEntity<ApiResponse<Category>> getById(@PathVariable UUID id) {
        Category category = findCategoryByIdOrThrow(id);
        String message = MessageUtils.getMessage(MessageConstants.MESSAGE_FOUND, "Categoría");
        return ResponseEntity.ok(ApiResponse.success(message, category));
    }

    @PutMapping(RouteApisConstants.ID_IN_PATH)
    public ResponseEntity<ApiResponse<Category>> update(@PathVariable UUID id, @Valid @RequestBody Category category) {
        findCategoryByIdOrThrow(id);

        return isCategoryNameExists(category.getName()).map(existingCategory -> handleDuplicateNameError()).orElseGet(() -> {
            category.setId(id);
            Category updatedCategory = updateCategoryUseCase.execute(category);
            String message = MessageUtils.getMessage(MessageConstants.MESSAGE_UPDATE, "Categoría");
            return ResponseEntity.ok(ApiResponse.success(message, updatedCategory));
        });
    }

    @DeleteMapping(RouteApisConstants.ID_IN_PATH)
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable UUID id) {
        findCategoryByIdOrThrow(id);
        deleteCategoryUseCase.execute(id);
        String message = MessageUtils.getMessage(MessageConstants.MESSAGE_DELETE, "Categoría");
        return ResponseEntity.ok(ApiResponse.success(message));
    }

    private Category findCategoryByIdOrThrow(UUID id) {
        String messageNotFound = MessageUtils.getMessage(MessageConstants.MESSAGE_NOT_FOUND, "Categoría");
        return getByIdCategoryUseCase.execute(id).orElseThrow(() -> new ResourceNotFoundException(messageNotFound, id));
    }

    private Optional<Category> isCategoryNameExists(String name) {
        return findNameCategoryUseCase.execute(name);
    }

    private ResponseEntity<ApiResponse<Category>> handleDuplicateNameError() {
        String message = MessageUtils.getMessage(MessageConstants.MESSAGE_NAME_EXISTS, "Categoría");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ApiResponse.error(message));
    }
}
