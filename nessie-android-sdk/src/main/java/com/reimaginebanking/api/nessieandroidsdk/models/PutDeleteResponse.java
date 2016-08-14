package com.reimaginebanking.api.nessieandroidsdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * A class representing a response from the API for a PUT/DELETE request.
 */
public class PutDeleteResponse {

    @SerializedName("code")
    private int mCode;

    @SerializedName("message")
    private String mMessage;

    public PutDeleteResponse(int code, String message) {
        mCode = code;
        mMessage = message;
    }

    public int getCode() {
        return mCode;
    }

    public void setCode(int code) {
        mCode = code;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    @Override
    public String toString() {
        return "PutDeleteResponse{" +
            "mCode=" + mCode +
            ", mMessage='" + mMessage + '\'' +
            '}';
    }
}
