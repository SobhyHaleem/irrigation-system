package com.sobhy.system.irrigationsystem.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Generic response class
 */

public class GenericResponse<T> {
    /**
     * response field
     */

    private final ResponseEntity<Response<T>> response;

    /**
     * construcroe
     */

    public GenericResponse(final Response<T> genericResponse, final HttpStatus statusCode) {
        this.response = new ResponseEntity<>(genericResponse, statusCode);
    }

    /**
     * get response method
     */

    public ResponseEntity<Response<T>> getResponse() {
        return response;
    }

    @Override
    public String toString() {
        return "EntityGenericResponseModel{" +
                "genericResponse=" + response +
                '}';
    }
}
