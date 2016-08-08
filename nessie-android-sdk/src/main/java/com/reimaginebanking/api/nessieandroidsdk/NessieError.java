package com.reimaginebanking.api.nessieandroidsdk;

import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;

/**
 * Created by hxp347 on 4/25/15.
 */
public class NessieError extends Exception {
    private String message = null;

    public NessieError(RetrofitError retrofitError){
        Response r = retrofitError.getResponse();
        if(r != null) {
            try {
                this.message = new String(((TypedByteArray) r.getBody()).getBytes());
            }catch (NullPointerException e){
                this.message = "No Body Received";
            }
            //this.status = retrofitError.getResponse().getStatus();
        }else {
            this.message = retrofitError.getMessage();
        }
    }

    @Override
    public String getMessage() {
        return message;
    }
}
