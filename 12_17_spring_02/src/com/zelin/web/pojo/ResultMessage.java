package com.zelin.web.pojo;

public class ResultMessage {
    private Boolean result;
    private String message;

    public ResultMessage() {
    }

    public ResultMessage(Boolean result, String message) {
        this.result = result;
        this.message = message;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
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
                "result=" + result +
                ", message='" + message + '\'' +
                '}';
    }
}
