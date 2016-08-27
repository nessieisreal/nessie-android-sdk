package com.reimaginebanking.api.nessieandroidsdk;

import com.reimaginebanking.api.nessieandroidsdk.constants.TransactionMedium;
import com.reimaginebanking.api.nessieandroidsdk.models.PostResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.PutDeleteResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.Withdrawal;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests all withdrawal endpoints against mock responses.
 */
public class WithdrawalTest extends NessieTest {

    /* GET /accounts/{id}/withdrawals */
    @Test
    public void testGetWithdrawalsByAccount() throws Exception {
        client.WITHDRAWAL.getWithdrawals("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                List<Withdrawal> withdrawals = (List<Withdrawal>) result;
                assertEquals(4, withdrawals.size());
                assertEquals("cancelled", withdrawals.get(0).getStatus());
                assertEquals("57aa3556bc727e4b519f25de", withdrawals.get(3).getId());
            }
        });
    }

    /* GET /withdrawals/{id} */
    @Test
    public void testGetWithdrawal() throws Exception {
        client.WITHDRAWAL.getWithdrawal("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                Withdrawal withdrawal = (Withdrawal) result;
                assertEquals("57aa33c4bc727e4b519f25db", withdrawal.getId());
                assertEquals("cancelled", withdrawal.getStatus());
            }
        });
    }

    /* POST /accounts/{id}/withdrawals */
    @Test
    public void testCreateWithdrawal() throws Exception {
        Withdrawal withdrawal = new Withdrawal.Builder()
            .medium(TransactionMedium.BALANCE)
            .transaction_date("2016-08-09")
            .amount(100.0)
            .description("TEST")
            .build();

        client.WITHDRAWAL.createWithdrawal("123", withdrawal, new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                PostResponse<Withdrawal> response = (PostResponse<Withdrawal>) result;
                assertEquals("Created withdrawal and added it to the account", response.getMessage());
                assertEquals("pending", response.getObjectCreated().getStatus());
            }
        });
    }

    /* PUT /withdrawals/{id} */
    @Test
    public void testUpdateWithdrawal() throws Exception {
        Withdrawal withdrawal = new Withdrawal.Builder()
            .amount(101.0)
            .build();

        client.WITHDRAWAL.updateWithdrawal("123", withdrawal, new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                PutDeleteResponse response = (PutDeleteResponse) result;
                assertEquals(202, response.getCode());
                assertEquals("Accepted withdrawal modification", response.getMessage());
            }
        });
    }

    /* DELETE /withdrawals/{id} */
    @Test
    public void testDeleteWithdrawal() throws Exception {
        client.WITHDRAWAL.deleteWithdrawal("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                PutDeleteResponse response = (PutDeleteResponse) result;
                assertEquals(204, response.getCode());
                assertEquals("Withdrawal Deleted", response.getMessage());
            }
        });
    }

}
