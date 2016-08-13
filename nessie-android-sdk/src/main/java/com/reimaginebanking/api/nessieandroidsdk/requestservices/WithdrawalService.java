package com.reimaginebanking.api.nessieandroidsdk.requestservices;

import com.reimaginebanking.api.nessieandroidsdk.models.PostResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.PutDeleteResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.Withdrawal;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Withdrawal endpoints
 */
public interface WithdrawalService {
    @GET("/accounts/{accountId}/withdrawals")
    void getWithdrawals(@Query("key") String key, @Path("accountId") String accountId, Callback<List<Withdrawal>> cb);

    @GET("/withdrawals/{withdrawalId}")
    void getWithdrawal(@Query("key") String key, @Path("withdrawalId") String accountId, Callback<Withdrawal> cb);

    @POST("/accounts/{accountId}/withdrawals")
    void createWithdrawal(@Query("key") String key, @Path("accountId") String accountId, @Body Withdrawal transaction,
        Callback<PostResponse<Withdrawal>> cb);

    @PUT("/withdrawals/{withdrawalId}")
    void updateWithdrawal(@Query("key") String key, @Path("withdrawalId") String accountId, @Body Withdrawal transaction,
        Callback<PutDeleteResponse> cb);

    @DELETE("/withdrawals/{withdrawalId}")
    void deleteWithdrawal(@Query("key") String key, @Path("withdrawalId") String accountId, Callback<PutDeleteResponse> cb);
}
