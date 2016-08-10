package com.reimaginebanking.api.nessieandroidsdk.models;

/**
 * Response after a customer is created successfully.
 */
public class PostResponse<T> {

    private int code;

    private String message;

    private T objectCreated;

    public PostResponse(int code, String message, T objectCreated) {
        this.code = code;
        this.message = message;
        this.objectCreated = objectCreated;
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

    public T getObjectCreated() {
        return objectCreated;
    }

    public void setObjectCreated(T objectCreated) {
        this.objectCreated = objectCreated;
    }

    @Override
    public String toString() {
        return "PostResponse{" +
            "code=" + code +
            ", message='" + message + '\'' +
            ", objectCreated=" + objectCreated +
            '}';
    }
}
