package com.reimaginebanking.api.nessieandroidsdk.requestclients;


import com.reimaginebanking.api.nessieandroidsdk.NessieException;
import com.reimaginebanking.api.nessieandroidsdk.NessieResultsListener;
import com.reimaginebanking.api.nessieandroidsdk.models.Customer;
import com.reimaginebanking.api.nessieandroidsdk.models.RequestResponse;
import com.reimaginebanking.api.nessieandroidsdk.requestservices.CustomerService;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A Client singleton object that provides methods for all Customer endpoints.
 */
public class CustomerClient {

    private CustomerService service;

    private String key;

    private static CustomerClient INSTANCE;

    private CustomerClient(String key, CustomerService service) {
        this.key = key;
        this.service = service;
    }

    public static CustomerClient getInstance(String key, CustomerService service){
        if (INSTANCE == null) {
            INSTANCE = new CustomerClient(key, service);
        }
        return INSTANCE;
    }

    public void getAccountCustomer(String accountID, final NessieResultsListener mlistener){
        service.getAccountCustomer(this.key, accountID, new Callback<Customer>() {
            public void success(Customer customer, Response response) {
                mlistener.onSuccess(customer, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getCustomers(final Callback<List<Customer>> cb){
        service.getCustomers(this.key, cb);
    }

    public void getCustomer(String customerID, final NessieResultsListener mlistener){
        service.getCustomer(this.key, customerID, new Callback<Customer>() {
            public void success(Customer customer, Response response) {
                mlistener.onSuccess(customer, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void createCustomer(Customer newCustomer, final NessieResultsListener mlistener){
        service.createCustomer(this.key, newCustomer, new Callback<RequestResponse>() {
            public void success(RequestResponse requestResponse, Response response) {
                mlistener.onSuccess(requestResponse, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void updateCustomer(String customerID, Customer updatedCustomer, final NessieResultsListener mlistener){
        service.updateCustomer(this.key, customerID, updatedCustomer, new Callback<RequestResponse>() {
            public void success(RequestResponse requestResponse, Response response) {
                mlistener.onSuccess(requestResponse, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }
}
