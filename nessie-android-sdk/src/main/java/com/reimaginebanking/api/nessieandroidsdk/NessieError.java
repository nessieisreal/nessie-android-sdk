package com.reimaginebanking.api.nessieandroidsdk;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A custom error class for Nessie specific error messages
 */
public class NessieError {
    @SerializedName("code")
    private int mCode;

    @SerializedName("message")
    private String mMessage;

    @SerializedName("culprit")
    private List<String> mCulprit;

    public NessieError(RetrofitError retrofitError){
        Response r = retrofitError.getResponse();

        // prevent the culprit list from being null
        mCulprit = new ArrayList<>();

        if(r != null) {
            try {
                mCode = ((NessieError) retrofitError.getBodyAs(NessieError.class)).getCode();
                mMessage = ((NessieError) retrofitError.getBodyAs(NessieError.class)).getMessage();
                mCulprit = ((NessieError) retrofitError.getBodyAs(NessieError.class)).getCulprit();
            } catch (RuntimeException e) {
                mCode = retrofitError.getResponse().getStatus();
                mMessage = retrofitError.getResponse().getReason();
            }
        }else {
            mMessage = retrofitError.getMessage();
        }
    }

    public int getCode() {
        return mCode;
    }

    public String getMessage() {
        return mMessage;
    }

    public List<String> getCulprit() {
        return mCulprit;
    }

}
