package com.reimaginebanking.api.nessieandroidsdk;

import com.reimaginebanking.api.nessieandroidsdk.models.Customer;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Tests all customer endpoints against mock responses.
 */
public class CustomerTest extends NessieTest {

    @Test
    public void testGetCustomers() throws Exception {
        client.CUSTOMER.getCustomers(new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                List<Customer> customers = (List<Customer>) result;
                assertEquals(customers.size(), 3);
                assertEquals(customers.get(0).getFirst_name(), "Emily");
                assertEquals(customers.get(0).getLast_name(), "Kinney");
            }
        });
    }

    @Test
    public void testGetCustomer() throws Exception {
        client.CUSTOMER.getCustomer("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                Customer customer = (Customer) result;
                assertEquals(customer.getFirst_name(), "Emily");
                assertEquals(customer.getLast_name(), "Kinney");
            }
        });
    }

    @Test
    public void testGetCustomerByAccount() throws Exception {
        client.CUSTOMER.getAccountCustomer("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                Customer customer = (Customer) result;
                assertEquals(customer.getFirst_name(), "Emily");
                assertEquals(customer.getLast_name(), "Kinney");
            }
        });
    }
}
