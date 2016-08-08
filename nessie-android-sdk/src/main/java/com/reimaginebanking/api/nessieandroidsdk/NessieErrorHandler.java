package com.reimaginebanking.api.nessieandroidsdk;

import retrofit.ErrorHandler;
import retrofit.RetrofitError;

/**
 * Created by hxp347 on 4/25/15.
 */
public class NessieErrorHandler implements ErrorHandler {
    public Throwable handleError(RetrofitError cause) {
        return new NessieException(cause);
    }
}
