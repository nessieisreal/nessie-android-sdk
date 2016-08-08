package com.reimaginebanking.api.nessieandroidsdk;

/**
 * Created by hxp347 on 4/23/15.
 */
public interface NessieResultsListener {
    public void onSuccess(Object result);
    public void onFailure(NessieError error);
}
