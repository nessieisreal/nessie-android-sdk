package com.reimaginebanking.api.nessieandroidsdk;

import com.reimaginebanking.api.nessieandroidsdk.constants.TransactionMedium;
import com.reimaginebanking.api.nessieandroidsdk.models.Deposit;
import com.reimaginebanking.api.nessieandroidsdk.models.PostResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.PutDeleteResponse;

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
            .transactionDate("2016-08-09")
            .medium(TransactionMedium.BALANCE)
            .build();

        client.DEPOSIT.createDeposit("123", deposit, new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                PostResponse<Deposit> response = (PostResponse<Deposit>) result;
                assertEquals("Created deposit and added it to the account", response.getMessage());
                assertEquals("DEPOSIT", response.getObjectCreated().getDescription());
            }
        });
    }

    /* PUT /deposits/{id} */
    @Test
    public void testUpdateDeposit() throws Exception {
        Deposit deposit = new Deposit.Builder()
            .amount(101)
            .build();

        client.DEPOSIT.updateDeposit("123", deposit, new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                PutDeleteResponse response = (PutDeleteResponse) result;
                assertEquals(202, response.getCode());
                assertEquals("Accepted deposit modification", response.getMessage());
            }
        });
    }

    /* DELETE /deposits/{id} */
    @Test
    public void testDeleteDeposit() throws Exception {
        client.DEPOSIT.deleteDeposit("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                PutDeleteResponse response = (PutDeleteResponse) result;
                assertEquals(204, response.getCode());
            }
        });
    }

}
