package com.reimaginebanking.api.nessieandroidsdk;

import com.reimaginebanking.api.nessieandroidsdk.constants.TransactionMedium;
import com.reimaginebanking.api.nessieandroidsdk.constants.TransferAccountType;
import com.reimaginebanking.api.nessieandroidsdk.models.PostResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.PutDeleteResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.Transfer;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests all transfer endpoints against mock responses.
 */
public class TransferTest extends NessieTest {

    /* GET /accounts/{id}/transfers */
    @Test
    public void testGetTransfersByAccount() throws Exception {
        client.TRANSFER.getTransfers("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                List<Transfer> transfers = (List<Transfer>) result;
                assertEquals(3, transfers.size());
                assertEquals("57adeba6bc727e4b519f2658", transfers.get(0).getId());
                assertEquals("cancelled", transfers.get(2).getStatus());
            }
        });
    }

    @Test
    public void testGetTransfersByAccountWithType() throws Exception {
        client.TRANSFER.getTransfers("123", TransferAccountType.PAYER, new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                List<Transfer> transfers = (List<Transfer>) result;
                assertEquals(3, transfers.size());
                assertEquals("57adeba6bc727e4b519f2658", transfers.get(0).getId());
            }
        });
    }

    /* GET /transfers/{id} */
    @Test
    public void testGetTransfer() throws Exception {
        client.TRANSFER.getTransfer("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                Transfer transfer = (Transfer) result;
                assertEquals("57adec16bc727e4b519f265a", transfer.getId());
                assertEquals("cancelled", transfer.getStatus());
            }
        });
    }

    /* POST /accounts/{id}/transfers */
    @Test
    public void testCreateTransfer() throws Exception {
        Transfer transfer = new Transfer.Builder()
            .medium(TransactionMedium.BALANCE)
            .payeeId("56c66be6a73e492741507b32")
            .transactionDate("2016-08-12")
            .amount(100.0)
            .description("Transferring money.")
            .build();

        client.TRANSFER.createTransfer("123", transfer, new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                PostResponse<Transfer> response = (PostResponse<Transfer>) result;
                assertEquals(201, response.getCode());
                assertEquals("Created transaction and added it to the account", response.getMessage());
                assertEquals("pending", response.getObjectCreated().getStatus());
            }
        });
    }

    /* PUT /transfers/{id} */
    @Test
    public void testUpdateTransfer() throws Exception {
        Transfer transfer = new Transfer.Builder()
            .description("Updated transfer")
            .build();

        client.TRANSFER.updateTransfer("123", transfer, new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                PutDeleteResponse response = (PutDeleteResponse) result;
                assertEquals(202, response.getCode());
                assertEquals("Accepted transaction modification", response.getMessage());
            }
        });
    }

    /* DELETE /transfers/{id} */
    @Test
    public void testDeleteTransfer() throws Exception {
        client.TRANSFER.deleteTransfer("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                PutDeleteResponse response = (PutDeleteResponse) result;
                assertEquals(204, response.getCode());
                assertEquals("Transfer Deleted", response.getMessage());
            }
        });
    }
}
