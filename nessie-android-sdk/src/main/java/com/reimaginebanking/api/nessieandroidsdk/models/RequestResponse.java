package com.reimaginebanking.api.nessieandroidsdk.models;

import java.util.List;

/**
 * Created by kco942 on 4/9/15.
 */
public class RequestResponse {
    private int code;
    private String message;
    private List<String> culprit;
    private Object objectCreated;

    public RequestResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public RequestResponse(int code, String message, List<String> culprit) {
        this.code = code;
        this.message = message;
        this.culprit = culprit;
    }

    public RequestResponse(int code, String message, Object objectCreated) {
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

    public List<String> getCulprit() {
        return culprit;
    }

    public void setCulprit(List<String> culprit) {
        this.culprit = culprit;
    }

    public Object getObjectCreated() {
        return objectCreated;
    }

    public void setObjectCreated(Object objectCreated) {
        this.objectCreated = objectCreated;
    }

    @Override
    public String toString() {
        return "RequestResponse{" +
            "code=" + code +
            ", message='" + message + '\'' +
            ", culprit=" + culprit +
            ", objectCreated=" + objectCreated +
            '}';
    }
}
