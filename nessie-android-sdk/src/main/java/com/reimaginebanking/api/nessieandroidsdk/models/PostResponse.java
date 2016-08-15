package com.reimaginebanking.api.nessieandroidsdk.models;

/**
 * A class representing a response after an object is created successfully with a POST request
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

    public String getMessage() {
        return message;
    }

    public T getObjectCreated() {
        return objectCreated;
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
