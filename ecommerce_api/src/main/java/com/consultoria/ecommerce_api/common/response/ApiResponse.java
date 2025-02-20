package com.consultoria.ecommerce_api.common.response;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;

    public ApiResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponse<T> success( String message, T data) {
        return new ApiResponse<>(true, message != null ? message : "Operación exitosa", data);
    }

    public static <T> ApiResponse<T> success(String message) {
        return new ApiResponse<>(true, message != null ? message : "Operación exitosa", null);
    }

    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(false, message != null ? message : "Ocurrió un error", null);
    }

    public static <T> ApiResponse<T> error(String message, T data) {
        return new ApiResponse<>(false, message != null ? message : "Ocurrió un error", data);
    }
}
