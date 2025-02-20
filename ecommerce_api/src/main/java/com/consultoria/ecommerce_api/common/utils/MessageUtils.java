package com.consultoria.ecommerce_api.common.utils;

import com.consultoria.ecommerce_api.common.constants.MessageConstants;

public class MessageUtils {

    public static String getMessage(String messageTemplate, String resourceName) {
        return messageTemplate.replace(MessageConstants.RESOURCE_PLACEHOLDER, resourceName);
    }

    public static String getMaxLengthMessage(String fieldName, int maxLength) {
        return fieldName + " no puede tener más de " + maxLength + " caracteres";
    }
}