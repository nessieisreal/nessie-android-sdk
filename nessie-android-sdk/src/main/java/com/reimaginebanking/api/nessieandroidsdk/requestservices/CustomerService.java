package com.reimaginebanking.api.nessieandroidsdk.requestservices;

import com.reimaginebanking.api.nessieandroidsdk.models.Customer;
import com.reimaginebanking.api.nessieandroidsdk.models.PostResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.PutDeleteResponse;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Customer endpoints
 */
public interface CustomerService {
    @GET("/accounts/{id}/customer")
    void getAccountCustomer(@Query("key") String key, @Path("id") String id, Callback<Customer> cb);

    @GET("/customers")
    void getCustomers(@Query("key") String key, Callback<List<Customer>> cb);

    @GET("/customers/{id}")
    void getCustomer(@Query("key") String key, @Path("id") String id, Callback<Customer> cb);

    @Headers("Content-Type: application/json")
    @POST("/customers")
    void createCustomer(@Query("key") String key, @Body Customer customer, Callback<PostResponse<Customer>> cb);

    @Headers("Content-Type: application/json")
    @PUT("/customers/{id}")
    void updateCustomer(@Query("key") String key, @Path("id") String id, @Body Customer customer, Callback<PutDeleteResponse> cb);
}
