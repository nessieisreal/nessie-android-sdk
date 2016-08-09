package com.reimaginebanking.api.nessieandroidsdk;

import com.reimaginebanking.api.nessieandroidsdk.models.Address;
import com.reimaginebanking.api.nessieandroidsdk.models.Customer;
import com.reimaginebanking.api.nessieandroidsdk.models.CustomerCreatedResponse;

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
                assertEquals("Emily", customers.get(0).getFirst_name());
                assertEquals("Kinney", customers.get(0).getLast_name());
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
                assertEquals("Emily", customer.getFirst_name());
                assertEquals("Kinney", customer.getLast_name());
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
                assertEquals("Emily", customer.getFirst_name());
                assertEquals("Kinney", customer.getLast_name());
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
                CustomerCreatedResponse response = (CustomerCreatedResponse) result;
                Customer newCustomer = (Customer) response.getObjectCreated();
                assertEquals("New", newCustomer.getFirst_name());
                assertEquals("Customer", newCustomer.getLast_name());
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
                // need to update this once the NessieError object param contains the 'culprit'
                assertTrue(true);
            }
        });
    }
}
