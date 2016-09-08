package com.reimaginebanking.api.nessieandroidsdk;

import com.reimaginebanking.api.nessieandroidsdk.models.Address;
import com.reimaginebanking.api.nessieandroidsdk.models.Geocode;
import com.reimaginebanking.api.nessieandroidsdk.models.Merchant;
import com.reimaginebanking.api.nessieandroidsdk.models.PostResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.PutDeleteResponse;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests all merchant endpoints against mock responses.
 */
public class MerchantTest extends NessieTest {

    /* GET /merchants */

    // this test needs updated to support pagination for merchants
    @Test
    public void testGetMerchantsByLocation() throws Exception {
        client.MERCHANT.getMerchants(-75.1652f, 39.9526f, 1.0f, new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                List<Merchant> merchants = (List<Merchant>) result;
                assertEquals(4, merchants.size());
                assertEquals("56c66be6a73e492741507624", merchants.get(0).getId());
                assertEquals("Jetro", merchants.get(3).getName());
            }
        });
    }

    // this test should test that pagination is working
    @Test
    public void testGetMerchantsPagination() throws Exception {
        client.MERCHANT.getMerchants(null, null, null, new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                List<Merchant> merchants = (List<Merchant>) result;
                assertEquals(4, merchants.size());
                assertEquals("56c66be6a73e492741507624", merchants.get(0).getId());
                assertEquals("Jetro", merchants.get(3).getName());
            }
        });
    }

    // this test should test that we can ask for a specific page
    @Test
    public void testGetMerchantsPaginationSpecifyPage() throws Exception {
        client.MERCHANT.getMerchants(null, null, null, 3, new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                List<Merchant> merchants = (List<Merchant>) result;
                assertEquals(4, merchants.size());
                assertEquals("56c66be6a73e492741507624", merchants.get(0).getId());
                assertEquals("Jetro", merchants.get(3).getName());
            }
        });
    }


    /* GET /merchants/{id} */
    @Test
    public void testGetMerchant() throws Exception {
        client.MERCHANT.getMerchant("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                Merchant merchant = (Merchant) result;
                assertEquals("Wells Fargo Center", merchant.getName());
            }
        });
    }

    /* POST /merchants */
    @Test
    public void testCreateMerchant() throws Exception {
        Address address = new Address.Builder()
            .streetNumber("1111")
            .streetName("Pittsburgh St")
            .city("Pittsburgh")
            .state("PA")
            .zip("12345")
            .build();

        Geocode geocode = new Geocode(100, 100);

        Merchant merchant = new Merchant.Builder()
            .name("Grocery Store")
            .category("Food")
            .address(address)
            .geocode(geocode)
            .build();

        client.MERCHANT.createMerchant(merchant, new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                PostResponse<Merchant> response = (PostResponse<Merchant>) result;
                assertEquals(201, response.getCode());
                assertEquals("Created merchant", response.getMessage());
                assertEquals("Grocery Store", response.getObjectCreated().getName());
            }
        });
    }

    /* PUT /merchants/{id} */
    @Test
    public void testUpdateMerchant() throws Exception {
        Merchant merchant = new Merchant.Builder()
            .name("Groceries")
            .build();

        client.MERCHANT.updateMerchant("123", merchant, new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                PutDeleteResponse response = (PutDeleteResponse) result;
                assertEquals(202, response.getCode());
                assertEquals("Accepted merchant modification", response.getMessage());
            }
        });
    }

}
