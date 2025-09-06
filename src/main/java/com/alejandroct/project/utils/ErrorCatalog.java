package com.alejandroct.project.utils;

public enum ErrorCatalog {
    PRODUCT_NOT_FOUND("PROD_001", "product not found"),
    INVALID_REQUEST("REQ_001","Invalid request"),
    GENERIC_ERROR("GEN_001","Unexpected error");


    private final String code;
    private final String message;

    ErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
