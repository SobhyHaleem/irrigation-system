package com.sobhy.system.irrigationsystem.common;


import lombok.Getter;
import lombok.Setter;

/**
 * status class
 */
public class Status {
    /**
     * code property
     */
    @Getter
    @Setter
    private int code;
    /**
     * error msg property
     */
    @Getter
    @Setter
    private String errorMsg;
    /**
     * error property
     */
    @Getter
    @Setter
    private String error;

    /**
     * status constructor
     */

    public Status() {
        this.code = 200;
    }

    public Status(int code) {
        this.code = code;
    }

    /**
     * status constructor with properties
     */

    public Status(final int code, final String errorMsg, final String error) {
        this.code = code;
        this.errorMsg = errorMsg;
        this.error = error;
    }


    @Override
    public String toString() {
        return "Status{" +
                "code=" + code +
                ", errorMsg='" + errorMsg + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
