package com.reimaginebanking.api.nessieandroidsdk.requestservices;


import com.reimaginebanking.api.nessieandroidsdk.models.ATM;
import com.reimaginebanking.api.nessieandroidsdk.models.Account;
import com.reimaginebanking.api.nessieandroidsdk.models.Bill;
import com.reimaginebanking.api.nessieandroidsdk.models.Branch;
import com.reimaginebanking.api.nessieandroidsdk.models.Customer;
import com.reimaginebanking.api.nessieandroidsdk.models.Deposit;
import com.reimaginebanking.api.nessieandroidsdk.models.Merchant;
import com.reimaginebanking.api.nessieandroidsdk.models.Purchase;
import com.reimaginebanking.api.nessieandroidsdk.models.RequestResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.Transfer;
import com.reimaginebanking.api.nessieandroidsdk.models.Withdrawal;

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
 * Created by kco942 on 4/9/15.
 */
public interface NessieService {
    /**
     * CUSTOMER ENDPOINTS
     * **/
    //ACCOUNT

    @GET("/accounts")
    void getAccounts(@Query("key") String key, Callback<List<Account>> cb);

    @GET("/accounts/{id}")
    void getAccount(@Query("key") String key, @Path("id") String id, Callback<Account> cb);

    @GET("/customers/{id}/accounts")
    void getCustomerAccounts(@Query("key") String key, @Path("id") String id, Callback<List<Account>> cb);

    @Headers("Content-Type: application/json")
    @POST("/customers/{id}/accounts")
    void createAccount(@Query("key") String key, @Path("id") String id, @Body Account account, Callback<RequestResponse> cb);

    @Headers("Content-Type: application/json")
    @PUT("/accounts/{id}")
    void updateAccount(@Query("key") String key, @Path("id") String id, @Body Account account, Callback<RequestResponse> cb);

    @DELETE("/accounts/{id}")
    void deleteAccount(@Query("key") String key, @Path("id") String id, Callback<RequestResponse> cb);

    //ATM

    @GET("/atms")
    void getATMs(@Query("key") String key, Callback<List<ATM>> cb);

    @GET("/atms/{id}")
    void getATM(@Query("key") String key, @Path("id") String id, Callback<ATM> cb);

    //BILL
    @GET("/accounts/{account_id}/bills")
    void getBills(@Query("key") String key, @Path("account_id") String id, Callback<List<Bill>> cb);

    @GET("/bills/{bill_id}")
    void getBill(@Query("key") String key, @Path("bill_id") String bill_id, Callback<Bill> cb);

    @GET("/customers/{id}/bills")
    void getCustomerBills(@Query("key") String key, @Path("id") String id, Callback<List<Bill>> cb);

    @Headers("Content-Type: application/json")
    @POST("/accounts/{id}/bills")
    void createBill(@Query("key") String key, @Path("id") String id, @Body Bill bill, Callback<RequestResponse> cb);

    @Headers("Content-Type: application/json")
    @PUT("/bills/{bill_id}")
    void updateBill(@Query("key") String key, @Path("bill_id") String bill_id, @Body Bill bill, Callback<RequestResponse> cb);

    @DELETE("/bills/{bill_id}")
    void deleteBill(@Query("key") String key, @Path("bill_id") String bill_id, Callback<RequestResponse> cb);

    //BRANCH

    @GET("/branches")
    void getBranches(@Query("key") String key, Callback<List<Branch>> cb);

    @GET("/branches/{id}")
    void getBranch(@Query("key") String key, @Path("id") String id, Callback<Branch> cb);

    //CUSTOMER

    @GET("/accounts/{id}/customer")
    void getAccountCustomer(@Query("key") String key, @Path("id") String id, Callback<Customer> cb);

    @GET("/customers")
    void getCustomers(@Query("key") String key, Callback<List<Customer>> cb);

    @GET("/customers/{id}")
    void getCustomer(@Query("key") String key, @Path("id") String id, Callback<Customer> cb);

    @Headers("Content-Type: application/json")
    @POST("/customers")
    void createCustomer(@Query("key") String key, @Body Customer customer, Callback<RequestResponse> cb);

    @Headers("Content-Type: application/json")
    @PUT("/customers/{id}")
    void updateCustomer(@Query("key") String key, @Path("id") String id, @Body Customer customer, Callback<RequestResponse> cb);

    //DEPOSIT
    @GET("/accounts/{accountId}/deposits")
    void getDeposits(@Query("key") String key, @Path("accountId") String accountId, Callback<List<Deposit>> cb);

    @GET("/deposits/{depositId}")
    void getDeposit(@Query("key") String key, @Path("depositId") String depositId, Callback<Deposit> cb);

    //working
    @POST("/accounts/{accountId}/deposits")
    void createDeposit(@Query("key") String key, @Path("accountId") String accountId, @Body Deposit deposit, Callback<RequestResponse> cb);

    @PUT("/deposits/{depositId}")
    void updateDeposit(@Query("key") String key, @Path("depositId") String depositId, @Body Deposit deposit, Callback<RequestResponse> cb);

    @DELETE("/deposits/{depositId}")
    void deleteDeposit(@Query("key") String key, @Path("depositId") String depositId, Callback<RequestResponse> cb);

    //MERCHANT

    @GET("/merchants")
    void getMerchants(@Query("key") String key, Callback<List<Merchant>> cb);

    @GET("/merchants/{id}")
    void getMerchant(@Query("key") String key, @Path("id") String merchantId, Callback<Merchant> cb);

    @POST("/merchants")
    void createMerchant(@Query("key") String key, @Body Merchant merchant, Callback<RequestResponse> cb);

    @PUT("/merchants/{id}")
    void updateMerchant(@Query("key") String key, @Path("id") String merchantId, @Body Merchant merchant, Callback<RequestResponse> cb);

    //PURCHASE

    @GET("/accounts/{accountId}/purchases")
    void getPurchases(@Query("key") String key, @Path("accountId") String accountId, Callback<List<Purchase>> cb);

    @GET("/purchases/{purchaseId}")
    void getPurchase(@Query("key") String key, @Path("purchaseId") String purchaseId, Callback<Purchase> cb);

    @POST("/accounts/{accountId}/purchases")
    void createPurchase(@Query("key") String key, @Path("accountId") String accountId, @Body Purchase purchase,
        Callback<RequestResponse> cb);

    @PUT("/purchases/{purchaseId}")
    void updatePurchase(@Query("key") String key, @Path("purchaseId") String purchaseId, @Body Purchase purchase,
        Callback<RequestResponse> cb);

    @DELETE("/purchases/{purchaseId}")
    void deletePurchase(@Query("key") String key, @Path("purchaseId") String purchaseId, Callback<RequestResponse> cb);

    //TRANSFER

    @GET("/accounts/{accountId}/transfers")
    void getTransfers(@Query("key") String key, @Path("accountId") String accountId, Callback<List<Transfer>> cb);

    @GET("/transfers/{transferId}")
    void getTransfer(@Query("key") String key, @Path("transferId") String transferId, Callback<Transfer> cb);

    @POST("/accounts/{accountId}/transfers")
    void createTransfer(@Query("key") String key, @Path("accountId") String accountId, @Body Transfer transfer,
        Callback<RequestResponse> cb);

    @PUT("/transfers/{transferId}")
    void updateTransfer(@Query("key") String key, @Path("transferId") String transferId, @Body Transfer transfer,
        Callback<RequestResponse> cb);

    @DELETE("/transfers/{transferId}")
    void deleteTransfer(@Query("key") String key, @Path("transferId") String transferId, Callback<RequestResponse> cb);

    //WITHDRAWAL

    @GET("/accounts/{accountId}/withdrawals")
    void getWithdrawals(@Query("key") String key, @Path("accountId") String accountId, Callback<List<Withdrawal>> cb);

    @GET("withdrawals/{withdrawalId}")
    void getWithdrawal(@Query("key") String key, @Path("accountId") String accountId, Callback<Withdrawal> cb);

    @POST("/accounts/{accountId}/withdrawals")
    void createWithdrawal(@Query("key") String key, @Path("accountId") String accountId, @Body Withdrawal transaction,
        Callback<RequestResponse> cb);

    @PUT("/withdrawals/{withdrawalId}")
    void updateWithdrawal(@Query("key") String key, @Path("accountId") String accountId, @Body Withdrawal transaction,
        Callback<RequestResponse> cb);

    @DELETE("/withdrawals/{withdrawalId}")
    void deleteWithdrawal(@Query("key") String key, @Path("accountId") String accountId, Callback<RequestResponse> cb);

    /**
     * ENTERPRISE ENDPOINTS
     * **/

    //ENTERPRISE ACCOUNT
    @GET("/enterprise/accounts")
    void getAccountsAsEnterprise(@Query("key") String key, Callback<List<Account>> cb);

    @GET("/enterprise/accounts/{id}")
    void getAccountAsEnterprise(@Query("key") String key, @Path("id") String id, Callback<Account> cb);

    //ENTERPRISE BILL
    @GET("/enterprise/bills")
    void getBillsAsEnterprise(@Query("key") String key, Callback<List<Bill>> cb);

    @GET("/enterprise/bills/{id}")
    void getBillAsEnterprise(@Query("key") String key, @Path("id") String id, Callback<Bill> cb);

    //ENTERPRISE CUSTOMER
    @GET("/enterprise/customers")
    void getCustomersAsEnterprise(@Query("key") String key, Callback<List<Customer>> cb);

    @GET("/enterprise/customers/{id}")
    void getCustomerAsEnterprise(@Query("key") String key, @Path("id") String id, Callback<Customer> cb);

    //ENTERPRISE MERCHANT
    @GET("/enterprise/merchants")
    void getMerchantsAsEnterprise(@Query("key") String key, Callback<List<Merchant>> cb);

    @GET("/enterprise/merchants/{id}")
    void getMerchantAsEnterprise(@Query("key") String key, @Path("id") String id, Callback<Merchant> cb);

    //ENTERPRISE TRANSFER
    @GET("/enterprise/transfers")
    void getTransfersAsEnterprise(@Query("key") String key, Callback<List<Transfer>> cb);

    @GET("/enterprise/transfers/{id}")
    void getTransferAsEnterprise(@Query("key") String key, @Path("id") String id, Callback<Transfer> cb);

    //ENTERPRISE WITHDRAWAL
    @GET("/enterprise/withdrawals")
    void getWithdrawalsAsEnterprise(@Query("key") String key, Callback<List<Withdrawal>> cb);

    @GET("/enterprise/withdrawals/{id}")
    void getWithdrawalAsEnterprise(@Query("key") String key, @Path("id") String id, Callback<Withdrawal> cb);

}
