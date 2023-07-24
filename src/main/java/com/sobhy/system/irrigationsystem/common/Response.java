package com.sobhy.system.irrigationsystem.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

/**
 * response class
 */

public class Response<TData> {
    /**
     * status property
     */
    @Getter
    @Setter
    private Status status = null;
    /**
     * result property
     */
    @Getter
    @Setter
    private TData result = null;
    /**
     * pagination property
     */
    @Getter
    @Setter
    private Pagination paginationInfo = null;

    /**
     * response constructor
     */

    public Response() {

    }

    /**
     * response constructor with properties
     */

    public Response(final Status status, final TData result, final Pagination paginationInfo) {
        this.status = status;
        this.result = result;
        this.paginationInfo = paginationInfo;
    }

    public void validate() {
        validate(null);
    }
    public void validate(String apiName) {
        if (this.result == null || this.status == null) {
            String msg = apiName == null || apiName.isEmpty() ? "Invalid Response"
                    : "Invalid Response for API: " + apiName;
            throw new RuntimeException(msg);
        }
    }

    @Override
    public String toString(){
        ObjectMapper objectMapper = new ObjectMapper();
        String responseStr = "";
        try {
            responseStr = objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return super.toString();
        }
        return responseStr;
    }

}
