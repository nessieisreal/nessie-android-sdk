package com.reimaginebanking.api.nessieandroidsdk.models;

/**
 * Response after a customer is created successfully.
 */
public class CustomerCreatedResponse {

    private int code;

    private String message;

    private Customer objectCreated;

    public CustomerCreatedResponse(int code, String message, Customer objectCreated) {
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

    public Customer getObjectCreated() {
        return objectCreated;
    }

    public void setObjectCreated(Customer objectCreated) {
        this.objectCreated = objectCreated;
    }

    @Override
    public String toString() {
        return "CustomerCreatedResponse{" +
            "code=" + code +
            ", message='" + message + '\'' +
            ", objectCreated=" + objectCreated +
            '}';
    }
}
