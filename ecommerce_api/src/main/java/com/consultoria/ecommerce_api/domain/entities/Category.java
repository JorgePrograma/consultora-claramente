package com.consultoria.ecommerce_api.domain.entities;

import com.consultoria.ecommerce_api.common.constants.ValidationMessages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;

@Data
public class Category {
    private UUID id;

    @NotBlank(message = ValidationMessages.NAME_REQUIRED)
    @Size(max = 50, message = ValidationMessages.NAME_MAX_LENGTH)
    private String name;

    @Size(max = 150, message = ValidationMessages.DESCRIPTION_MAX_LENGTH)
    private String description;
}
