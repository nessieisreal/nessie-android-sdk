package com.reimaginebanking.api.nessieandroidsdk;

import com.reimaginebanking.api.nessieandroidsdk.models.PostResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.Purchase;
import com.reimaginebanking.api.nessieandroidsdk.models.PutDeleteResponse;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests all purchase endpoints against mock responses.
 */
public class PurchaseTest extends NessieTest {

    /* GET /accounts/{id}/purchases */
    @Test
    public void testGetPurchasesByAccount() throws Exception {
        client.PURCHASE.getPurchasesByAccount("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                List<Purchase> purchases = (List<Purchase>) result;
                assertEquals(4, purchases.size());
                assertEquals("57ade695bc727e4b519f2653", purchases.get(0).getId());
            }
        });
    }

    /* GET /merchants/{id}/accounts/{id}/purchases */
    @Test
    public void testGetPurchasesByMerchantAndAccount() throws Exception {
        client.PURCHASE.getPurchasesByMerchantAndAccount("123", "456", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                List<Purchase> purchases = (List<Purchase>) result;
                assertEquals(4, purchases.size());
                assertEquals("57ade695bc727e4b519f2653", purchases.get(0).getId());
            }
        });
    }

    /* GET /merchants/{id}/purchases */
    @Test
    public void testGetPurchasesByMerchant() throws Exception {
        client.PURCHASE.getPurchasesByMerchant("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                List<Purchase> purchases = (List<Purchase>) result;
                assertEquals(4, purchases.size());
                assertEquals("57ade695bc727e4b519f2653", purchases.get(0).getId());
            }
        });
    }

    /* GET /purchases/{id} */
    @Test
    public void testGetPurchase() throws Exception {
        client.PURCHASE.getPurchase("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                Purchase purchase = (Purchase) result;
                assertEquals("57ade695bc727e4b519f2653", purchase.getId());
            }
        });
    }

    /* POST /accounts/{id}/purchases */
    @Test
    public void testCreatePurchase() throws Exception {
        Purchase purchase = new Purchase.Builder()
            .merchant("123")
            .medium("balance")
            .purchaseDate("2016-08-12")
            .amount(100.0)
            .description("Grocery purchase.")
            .build();

        client.PURCHASE.createPurchase("123", purchase, new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                PostResponse<Purchase> response = (PostResponse<Purchase>) result;
            }
        });
    }

    /* PUT /purchases/{id} */
    @Test
    public void testUpdatePurchase() throws Exception {
        Purchase purchase = new Purchase.Builder()
            .amount(101.0)
            .description("Grocery purchase updated.")
            .build();

        client.PURCHASE.updatePurchase("123", purchase, new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                PutDeleteResponse response = (PutDeleteResponse) result;
                assertEquals(202, response.getCode());
                assertEquals("Accepted purchase modification", response.getMessage());
            }
        });

    }

    /* DELETE /purchases/{id} */
    @Test
    public void testDeletePurchase() throws Exception {
        client.PURCHASE.deletePurchase("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                PutDeleteResponse response = (PutDeleteResponse) result;
                assertEquals(204, response.getCode());
                assertEquals("Purchase Deleted", response.getMessage());
            }
        });
    }

}
