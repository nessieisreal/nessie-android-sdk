package com.reimaginebanking.api.nessieandroidsdk.requestservices;

import com.reimaginebanking.api.nessieandroidsdk.models.Account;
import com.reimaginebanking.api.nessieandroidsdk.models.Bill;
import com.reimaginebanking.api.nessieandroidsdk.models.Customer;
import com.reimaginebanking.api.nessieandroidsdk.models.Deposit;
import com.reimaginebanking.api.nessieandroidsdk.models.Merchant;
import com.reimaginebanking.api.nessieandroidsdk.models.Transfer;
import com.reimaginebanking.api.nessieandroidsdk.models.Withdrawal;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Enterprise endpoints
 */
public interface EnterpriseService {
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

    //ENTERPRISE DEPOSIT
    @GET("/enterprise/deposits")
    void getDepositsAsEnterprise(@Query("key") String key, Callback<List<Deposit>> cb);

    @GET("/enterprise/deposits/{id}")
    void getDepositAsEnterprise(@Query("key") String key, @Path("id") String id, Callback<Deposit> cb);
}
