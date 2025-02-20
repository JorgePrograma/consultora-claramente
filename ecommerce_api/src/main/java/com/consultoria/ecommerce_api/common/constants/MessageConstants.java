package com.consultoria.ecommerce_api.common.constants;

public class MessageConstants {
    // Placeholders para el nombre del recurso
    public static final String RESOURCE_PLACEHOLDER = "{resource}";

    // Mensajes con placeholders
    public static final String MESSAGE_CREATE = RESOURCE_PLACEHOLDER + " creado(a) con éxito";
    public static final String MESSAGE_UPDATE = RESOURCE_PLACEHOLDER + " actualizado(a) con éxito";
    public static final String MESSAGE_DELETE = RESOURCE_PLACEHOLDER + " eliminado(a) con éxito";
    public static final String MESSAGE_FOUND = RESOURCE_PLACEHOLDER + " encontrado(a)";
    public static final String MESSAGE_NOT_FOUND = RESOURCE_PLACEHOLDER + " no encontrado(a)";
    public static final String MESSAGE_ERROR = "Error al procesar " + RESOURCE_PLACEHOLDER;
    public static final String MESSAGE_VALIDATE = "Error de validación en " + RESOURCE_PLACEHOLDER;
    public static final String MESSAGE_NAME_EXISTS = RESOURCE_PLACEHOLDER +" ya existe";
}