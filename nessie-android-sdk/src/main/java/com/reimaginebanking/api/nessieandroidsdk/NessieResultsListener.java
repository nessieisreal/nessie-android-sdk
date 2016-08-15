package com.reimaginebanking.api.nessieandroidsdk;

/**
 * Custom results listener which defines callback methods for success and error on API response.
 */
public interface NessieResultsListener {
    void onSuccess(Object result);
    void onFailure(NessieError error);
}
