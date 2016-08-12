package com.reimaginebanking.api.nessieandroidsdk;

import com.reimaginebanking.api.nessieandroidsdk.Constants.TransactionMedium;
import com.reimaginebanking.api.nessieandroidsdk.models.Deposit;
import com.reimaginebanking.api.nessieandroidsdk.models.PostResponse;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests all deposit endpoints against mock responses.
 */
public class DepositTest extends NessieTest {

    /* GET /accounts/{id}/deposits */
    @Test
    public void testGetDepositsByAccount() throws Exception {
        client.DEPOSIT.getDeposits("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                List<Deposit> deposits = (List<Deposit>) result;
                assertEquals(2, deposits.size());
                assertEquals("executed", deposits.get(0).getStatus());
            }
        });
    }

    /* GET /deposits/{id} */
    @Test
    public void testGetDeposit() throws Exception {
        client.DEPOSIT.getDeposit("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                Deposit deposit = (Deposit) result;
                assertEquals("executed", deposit.getStatus());
                assertEquals("DEPOSIT", deposit.getDescription());
            }
        });
    }

    /* POST /accounts/{id}/deposits */
    @Test
    public void testCreateDeposit() throws Exception {
        Deposit deposit = new Deposit.Builder()
            .amount(100)
            .description("DEPOSIT")
            .status("pending")
            .transaction_date("2016-08-09")
            .medium(TransactionMedium.BALANCE)
            .build();

        client.DEPOSIT.createDeposit("123", deposit, new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                PostResponse<Deposit> response = (PostResponse<Deposit>) result;
            }
        });
    }

    /* PUT /deposits/{id} */

    /* DELETE /deposits/{id} */

}
