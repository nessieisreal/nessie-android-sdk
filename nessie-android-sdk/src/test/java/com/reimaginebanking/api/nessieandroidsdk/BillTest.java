package com.reimaginebanking.api.nessieandroidsdk;

import com.reimaginebanking.api.nessieandroidsdk.constants.BillStatus;
import com.reimaginebanking.api.nessieandroidsdk.models.Bill;
import com.reimaginebanking.api.nessieandroidsdk.models.PostResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.PutDeleteResponse;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests all bill endpoints against mock responses.
 */
public class BillTest extends NessieTest {

    /* GET /accounts/{id}/bills */
    @Test
    public void testGetBillsByAccount() throws Exception {
        client.BILL.getBillsByAccount("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                List<Bill> bills = (List<Bill>) result;
                assertEquals(1, bills.size());
                assertEquals("56c66be7a73e492741508470", bills.get(0).getId());
            }
        });
    }

    /* GET /bills/{id} */
    @Test
    public void testGetBill() throws Exception {
        client.BILL.getBill("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                Bill bill = (Bill) result;
                assertEquals("56c66be7a73e492741508473", bill.getId());
                assertEquals(BillStatus.CANCELLED, bill.getStatus());
            }
        });
    }

    /* GET /customers/{id}/bills */
    @Test
    public void testGetBillsByCustomer() throws Exception {
        client.BILL.getBillsByCustomer("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                List<Bill> bills = (List<Bill>) result;
                assertEquals(1, bills.size());
                assertEquals("56c66be7a73e492741508470", bills.get(0).getId());
            }
        });
    }

    /* POST /accounts/{id}/bills */
    @Test
    public void testCreateBill() throws Exception {
        Bill bill = new Bill.Builder()
            .status(BillStatus.PENDING)
            .payee("Verizon")
            .nickname("Cable Bill")
            .paymentDate("2016-08-09")
            .recurringDate(1)
            .paymentAmount(100)
            .build();

        client.BILL.createBill("123", bill, new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                PostResponse<Bill> response = (PostResponse<Bill>) result;
                assertEquals(201, response.getCode());
                assertEquals("Created bill and added it to the account", response.getMessage());
                assertEquals("Cable Bill", response.getObjectCreated().getNickname());
            }
        });
    }

    /* PUT /bills/{id} */
    @Test
    public void testUpdateBill() throws Exception {
        Bill bill = new Bill.Builder()
            .nickname("TEST UPDATE")
            .build();

        client.BILL.updateBill("123", bill, new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                PutDeleteResponse response = (PutDeleteResponse) result;
                assertEquals(202, response.getCode());
                assertEquals("Accepted bill modification", response.getMessage());
            }
        });
    }

    /* DELETE /bills/{id} */
    @Test
    public void testDeleteBill() throws Exception {
        client.BILL.deleteBill("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                PutDeleteResponse response = (PutDeleteResponse) result;
                assertEquals(204, response.getCode());
                assertEquals("Bill Deleted", response.getMessage());
            }
        });
    }

}
