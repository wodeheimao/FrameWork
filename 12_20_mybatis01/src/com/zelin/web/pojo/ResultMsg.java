package com.zelin.web.pojo;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class ResultMsg {
    private Boolean success;
    private String message;

    public ResultMsg() {
    }

    public ResultMsg(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResultMsg{" +
                "success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}
