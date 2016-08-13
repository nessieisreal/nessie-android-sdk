package com.reimaginebanking.api.nessieandroidsdk.models;

/**
 * A class representing a response from the API for a PUT/DELETE request.
 */
public class PutDeleteResponse {
    private int code;
    private String message;

    public PutDeleteResponse(int code, String message) {
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
        return "PutDeleteResponse{" +
            "code=" + code +
            ", message='" + message + '\'' +
            '}';
    }
}
