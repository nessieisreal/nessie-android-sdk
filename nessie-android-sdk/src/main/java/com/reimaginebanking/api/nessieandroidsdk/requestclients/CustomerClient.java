package com.reimaginebanking.api.nessieandroidsdk.requestclients;


import com.reimaginebanking.api.nessieandroidsdk.NessieError;
import com.reimaginebanking.api.nessieandroidsdk.NessieResultsListener;
import com.reimaginebanking.api.nessieandroidsdk.models.Customer;
import com.reimaginebanking.api.nessieandroidsdk.models.PostResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.PutDeleteResponse;
import com.reimaginebanking.api.nessieandroidsdk.requestservices.CustomerService;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A Client singleton object that provides methods for all Customer endpoints.
 */
public class CustomerClient {

    private CustomerService mService;

    private String mKey;

    private static CustomerClient INSTANCE;

    private CustomerClient(String key, CustomerService service) {
        mKey = key;
        mService = service;
    }

    public static CustomerClient getInstance(String key, CustomerService service){
        if (INSTANCE == null) {
            INSTANCE = new CustomerClient(key, service);
        }
        return INSTANCE;
    }

    public void getAccountCustomer(String accountID, final NessieResultsListener listener){
        mService.getAccountCustomer(mKey, accountID, new Callback<Customer>() {
            public void success(Customer customer, Response response) {
                listener.onSuccess(customer);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    public void getCustomers(final NessieResultsListener listener){
        mService.getCustomers(mKey, new Callback<List<Customer>>() {
            public void success(List<Customer> customers, Response response) {
                listener.onSuccess(customers);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    public void getCustomer(String customerID, final NessieResultsListener listener){
        mService.getCustomer(mKey, customerID, new Callback<Customer>() {
            public void success(Customer customer, Response response) {
                listener.onSuccess(customer);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    public void createCustomer(Customer newCustomer, final NessieResultsListener listener){
        mService.createCustomer(mKey, newCustomer, new Callback<PostResponse<Customer>>() {
            public void success(PostResponse<Customer> requestResponse, Response response) {
                listener.onSuccess(requestResponse);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    public void updateCustomer(String customerID, Customer updatedCustomer, final NessieResultsListener listener){
        mService.updateCustomer(mKey, customerID, updatedCustomer, new Callback<PutDeleteResponse>() {
            public void success(PutDeleteResponse putResponse, Response response) {
                listener.onSuccess(putResponse);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }
}
