package com.reimaginebanking.api.nessieandroidsdk;

import com.reimaginebanking.api.nessieandroidsdk.models.ATM;
import com.reimaginebanking.api.nessieandroidsdk.models.PaginatedResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.PagingObject;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests all atm endpoints against mock responses.
 */
public class AtmTest extends NessieTest {

    /* GET /atms */
    @Test
    public void testGetATMs() throws Exception {
        client.ATM.getATMs(38.9283f, -77.1753f, 1.0f, new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                PaginatedResponse<ATM> response = (PaginatedResponse<ATM>) result;

                assertEquals(6, response.getObjectList().size());
            }
        });
    }

    @Test
    public void testGetATMsPagination() throws Exception {

        PagingObject pagingObject = new PagingObject("/atms?lat=38.9283&lng=-77.1753&rad=1&key=12345&page=1", "/atms?lat=38.9283&lng=-77" +
            ".1753&rad=1&key=12345&page=2");

        client.ATM.getATMs(pagingObject.getNextPage(), new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                PaginatedResponse<ATM> response = (PaginatedResponse<ATM>) result;

                assertEquals(1, response.getObjectList().size());
            }
        });
    }

    /* GET /atms/{id} */
    @Test
    public void testGetATM() throws Exception {
        client.ATM.getATM("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                ATM atm = (ATM) result;

                assertEquals("56c66be5a73e492741506f56", atm.getId());
            }
        });
    }
}
