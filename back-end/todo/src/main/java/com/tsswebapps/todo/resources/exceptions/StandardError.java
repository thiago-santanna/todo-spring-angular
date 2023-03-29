package com.tsswebapps.todo.resources.exceptions;

import javax.sql.rowset.serial.SerialArray;
import java.io.Serializable;

public class StandardError implements Serializable {
    private static final long serialVersionUID = -8457802912722478236L;
    private Long timeStamp;
    private Integer status;
    private String message;

    public StandardError(Long timeStamp, Integer status, String message) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.message = message;
    }

    public StandardError() {}

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
