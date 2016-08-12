package com.reimaginebanking.api.nessieandroidsdk;

import com.reimaginebanking.api.nessieandroidsdk.models.Address;
import com.reimaginebanking.api.nessieandroidsdk.models.Customer;
import com.reimaginebanking.api.nessieandroidsdk.models.PostResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.RequestResponse;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Tests all customer endpoints against mock responses.
 */
public class CustomerTest extends NessieTest {

    /* GET /customers */
    @Test
    public void testGetCustomers() throws Exception {
        client.CUSTOMER.getCustomers(new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                List<Customer> customers = (List<Customer>) result;
                assertEquals(customers.size(), 3);
                assertEquals("Emily", customers.get(0).getFirstName());
                assertEquals("Kinney", customers.get(0).getLastName());
            }
        });
    }

    /* GET /customers/{id} */
    @Test
    public void testGetCustomer() throws Exception {
        client.CUSTOMER.getCustomer("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                Customer customer = (Customer) result;
                assertEquals("Emily", customer.getFirstName());
                assertEquals("Kinney", customer.getLastName());
            }
        });
    }

    /* GET /accounts/{id}/customer */
    @Test
    public void testGetCustomerByAccount() throws Exception {
        client.CUSTOMER.getAccountCustomer("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                Customer customer = (Customer) result;
                assertEquals("Emily", customer.getFirstName());
                assertEquals("Kinney", customer.getLastName());
            }
        });
    }

    /* POST /customers */
    @Test
    public void testCreateCustomer() throws Exception {
        Address address = new Address("PA", "Test", "1111", "Pittsburgh", "00000");

        Customer customer = new Customer.Builder()
            .firstName("New")
            .lastName("Customer")
            .address(address)
            .build();


        client.CUSTOMER.createCustomer(customer, new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                PostResponse<Customer> response = (PostResponse<Customer>) result;
                Customer newCustomer = response.getObjectCreated();
                assertEquals("New", newCustomer.getFirstName());
                assertEquals("Customer", newCustomer.getLastName());
            }
        });
    }

    @Test
    public void testCreateCustomerFailure() throws Exception {
        Customer invalidCustomer = new Customer.Builder()
            .firstName("")
            .lastName("")
            .build();

        client.CUSTOMER.createCustomer(invalidCustomer, new NessieTestResultsListener() {
            @Override
            public void onFailure(NessieError error) {
                // TODO: need to update this once the NessieError object param contains the 'culprit'
                assertTrue(true);
            }
        });
    }

    /* POST /customers */
    @Test
    public void testUpdateCustomer() throws Exception {
        Customer customer = new Customer.Builder()
            .address(new Address(null, null, "0000", null, null))
            .build();

        client.CUSTOMER.updateCustomer("123", customer, new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                RequestResponse response = (RequestResponse) result;
                assertEquals("Accepted customer update", response.getMessage());
            }
        });
    }
}
