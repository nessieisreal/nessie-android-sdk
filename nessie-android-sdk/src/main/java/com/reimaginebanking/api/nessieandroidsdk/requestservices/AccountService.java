package com.reimaginebanking.api.nessieandroidsdk.requestservices;

import com.reimaginebanking.api.nessieandroidsdk.constants.AccountType;
import com.reimaginebanking.api.nessieandroidsdk.models.Account;
import com.reimaginebanking.api.nessieandroidsdk.models.PostResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.PutDeleteResponse;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Account endpoints
 */
public interface AccountService {
    @GET("/accounts")
    void getAccounts(@Query("key") String key, @Query("type") AccountType type, Callback<List<Account>> cb);

    @GET("/accounts/{id}")
    void getAccount(@Query("key") String key, @Path("id") String id, Callback<Account> cb);

    @GET("/customers/{id}/accounts")
    void getCustomerAccounts(@Query("key") String key, @Path("id") String id, Callback<List<Account>> cb);

    @POST("/customers/{id}/accounts")
    void createAccount(@Query("key") String key, @Path("id") String id, @Body Account account, Callback<PostResponse<Account>> cb);

    @Headers("Content-Type: application/json")
    @PUT("/accounts/{id}")
    void updateAccount(@Query("key") String key, @Path("id") String id, @Body Account account, Callback<PutDeleteResponse> cb);

    @DELETE("/accounts/{id}")
    void deleteAccount(@Query("key") String key, @Path("id") String id, Callback<PutDeleteResponse> cb);
}
