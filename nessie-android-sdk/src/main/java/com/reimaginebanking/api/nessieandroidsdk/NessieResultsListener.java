package com.reimaginebanking.api.nessieandroidsdk;

/**
 * Custom results listener which defines callback methods for success and error on API response.
 */
public interface NessieResultsListener {
    public void onSuccess(Object result);
    public void onFailure(NessieError error);
}
