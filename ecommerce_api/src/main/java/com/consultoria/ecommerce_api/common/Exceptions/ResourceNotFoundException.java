package com.consultoria.ecommerce_api.common.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

public class ResourceNotFoundException extends ResponseStatusException {

    public ResourceNotFoundException(String entity, UUID id) {
        super(HttpStatus.NOT_FOUND, String.format("%s not found with id:%s", entity, id));
    }
}
