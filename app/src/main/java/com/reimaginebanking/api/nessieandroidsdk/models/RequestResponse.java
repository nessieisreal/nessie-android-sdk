package com.reimaginebanking.api.nessieandroidsdk.models;

/**
 * Created by kco942 on 4/9/15.
 */
public class RequestResponse {
    private int code;
    private String message;

    public RequestResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "RequestResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
