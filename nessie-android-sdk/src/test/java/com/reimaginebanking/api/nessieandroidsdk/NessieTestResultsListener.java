package com.reimaginebanking.api.nessieandroidsdk;

import static org.junit.Assert.fail;

/**
 * A proxy class which allows for only implementing success of failure methods as necessary in the test.
 */
public class NessieTestResultsListener implements NessieResultsListener {

    @Override
    public void onSuccess(Object result) {
        fail("Should not have succeeded.");
    }

    @Override
    public void onFailure(NessieError error) {
        fail("Should not have failed.");
    }
}
