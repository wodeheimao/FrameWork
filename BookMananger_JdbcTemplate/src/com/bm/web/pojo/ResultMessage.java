package com.bm.web.pojo;

public class ResultMessage {
    private Boolean success;
    private String message;

    public ResultMessage() {
    }

    public ResultMessage(Boolean success, String message) {
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
        return "ResultMessage{" +
                "success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}
