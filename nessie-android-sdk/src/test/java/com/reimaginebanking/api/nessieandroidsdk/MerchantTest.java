package com.reimaginebanking.api.nessieandroidsdk;

import com.reimaginebanking.api.nessieandroidsdk.models.Address;
import com.reimaginebanking.api.nessieandroidsdk.models.Geocode;
import com.reimaginebanking.api.nessieandroidsdk.models.Merchant;
import com.reimaginebanking.api.nessieandroidsdk.models.PaginatedResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.PostResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.PutDeleteResponse;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests all merchant endpoints against mock responses.
 */
public class MerchantTest extends NessieTest {

    /* GET /merchants */

    // check that pagination exists and is working
    @Test
    public void testGetMerchantsByLocation() throws Exception {
        client.MERCHANT.getMerchants(-75.1652f, 39.9526f, 1.0f, new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                PaginatedResponse<Merchant> paginatedResponse = (PaginatedResponse<Merchant>) result;
                assertEquals(20, paginatedResponse.getObjectList().size());
                assertEquals("57cf75cea73e494d8675ec49", paginatedResponse.getObjectList().get(0).getId());
                assertEquals("Taughannock Farms Inn", paginatedResponse.getObjectList().get(3).getName());
                assertEquals("/merchants?key=12345&page=2", paginatedResponse.getPagingObject().getNextPage());
            }
        });
    }

    // check that pagination url can be used to get merchants
    @Test
    public void testGetMerchantsPagination() throws Exception {
        client.MERCHANT.getMerchants("/merchants?key=12345&page=2", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                PaginatedResponse<Merchant> paginatedResponse = (PaginatedResponse<Merchant>) result;
                assertEquals(20, paginatedResponse.getObjectList().size());
                assertEquals("57cf75cea73e494d8675ec49", paginatedResponse.getObjectList().get(0).getId());
                assertEquals("Taughannock Farms Inn", paginatedResponse.getObjectList().get(3).getName());
                assertEquals("/merchants?key=12345&page=2", paginatedResponse.getPagingObject().getNextPage());
            }
        });
    }

    // check that a specific page of merchants can be found
    @Test
    public void testGetMerchantsPaginationSpecifyPage() throws Exception {
        client.MERCHANT.getMerchants(null, null, null, 3, new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                PaginatedResponse<Merchant> paginatedResponse = (PaginatedResponse<Merchant>) result;
                assertEquals(20, paginatedResponse.getObjectList().size());
                assertEquals("57cf75cea73e494d8675ec49", paginatedResponse.getObjectList().get(0).getId());
                assertEquals("Taughannock Farms Inn", paginatedResponse.getObjectList().get(3).getName());
                assertEquals("/merchants?key=12345&page=2", paginatedResponse.getPagingObject().getNextPage());
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

        List<String> categories = new ArrayList<>();
        categories.add("Food");

        Merchant merchant = new Merchant.Builder()
            .name("Grocery Store")
            .categories(categories)
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
