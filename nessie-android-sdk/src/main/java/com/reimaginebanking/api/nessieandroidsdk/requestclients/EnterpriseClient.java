package com.reimaginebanking.api.nessieandroidsdk.requestclients;

import com.reimaginebanking.api.nessieandroidsdk.NessieError;
import com.reimaginebanking.api.nessieandroidsdk.NessieResultsListener;
import com.reimaginebanking.api.nessieandroidsdk.models.Account;
import com.reimaginebanking.api.nessieandroidsdk.models.Bill;
import com.reimaginebanking.api.nessieandroidsdk.models.Customer;
import com.reimaginebanking.api.nessieandroidsdk.models.Merchant;
import com.reimaginebanking.api.nessieandroidsdk.models.Transfer;
import com.reimaginebanking.api.nessieandroidsdk.models.Withdrawal;
import com.reimaginebanking.api.nessieandroidsdk.requestservices.EnterpriseService;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A Client singleton object that provides methods for all Enterprise endpoints.
 */
public class EnterpriseClient {

    private EnterpriseService service;

    private String key;

    private static EnterpriseClient INSTANCE;

    private EnterpriseClient(String key, EnterpriseService service) {
        this.key = key;
        this.service = service;
    }

    public static EnterpriseClient getInstance(String key, EnterpriseService service){
        if (INSTANCE == null) {
            INSTANCE = new EnterpriseClient(key, service);
        }
        return INSTANCE;
    }

    //ENTERPRISE ACCOUNT
    public void getAccountsAsEnterprise(final NessieResultsListener mlistener){
        service.getAccountsAsEnterprise(this.key, new Callback<List<Account>>() {
            public void success(List<Account> accounts, Response response) {
                mlistener.onSuccess(accounts);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void getAccountAsEnterprise(String accountID, final NessieResultsListener mlistener){
        service.getAccountAsEnterprise(this.key, accountID, new Callback<Account>() {
            public void success(Account account, Response response) {
                mlistener.onSuccess(account);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    //ENTERPRISE BILL
    public void getBillsAsEnterprise(final NessieResultsListener mlistener){
        service.getBillsAsEnterprise(this.key, new Callback<List<Bill>>() {
            public void success(List<Bill> bills, Response response) {
                mlistener.onSuccess(bills);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void getBillAsEnterprise(String billID, final NessieResultsListener mlistener){
        service.getBillAsEnterprise(this.key, billID, new Callback<Bill>() {
            public void success(Bill bill, Response response) {
                mlistener.onSuccess(bill);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    //ENTERPRISE CUSTOMER
    public void getCustomersAsEnterprise(final NessieResultsListener mlistener){
        service.getCustomersAsEnterprise(this.key, new Callback<List<Customer>>() {
            public void success(List<Customer> customers, Response response) {
                mlistener.onSuccess(customers);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void getCustomerAsEnterprise(String customerID, final NessieResultsListener mlistener){
        service.getCustomerAsEnterprise(this.key, customerID, new Callback<Customer>() {
            public void success(Customer customer, Response response) {
                mlistener.onSuccess(customer);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    //ENTERPRISE MERCHANT
    public void getMerchantsAsEnterprise(final NessieResultsListener mlistener){
        service.getMerchantsAsEnterprise(this.key, new Callback<List<Merchant>>() {
            public void success(List<Merchant> customers, Response response) {
                mlistener.onSuccess(customers);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void getMerchantAsEnterprise(String merchantID, final NessieResultsListener mlistener){
        service.getMerchantAsEnterprise(this.key, merchantID, new Callback<Merchant>() {
            public void success(Merchant merchant, Response response) {
                mlistener.onSuccess(merchant);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    //ENTERPRISE TRANSFER
    public void getTransfersAsEnterprise(final NessieResultsListener mlistener){
        service.getTransfersAsEnterprise(this.key, new Callback<List<Transfer>>() {
            public void success(List<Transfer> customers, Response response) {
                mlistener.onSuccess(customers);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void getTransferAsEnterprise(String transferID, final NessieResultsListener mlistener){
        service.getTransferAsEnterprise(this.key, transferID, new Callback<Transfer>() {
            public void success(Transfer transfer, Response response) {
                mlistener.onSuccess(transfer);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    //ENTERPRISE WITHDRAWAL
    public void getWithdrawalsAsEnterprise(final NessieResultsListener mlistener){
        service.getWithdrawalsAsEnterprise(this.key, new Callback<List<Withdrawal>>() {
            public void success(List<Withdrawal> withdrawals, Response response) {
                mlistener.onSuccess(withdrawals);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void getWithdrawalAsEnterprise(String withdrawalID, final NessieResultsListener mlistener){
        service.getWithdrawalAsEnterprise(this.key, withdrawalID, new Callback<Withdrawal>() {
            public void success(Withdrawal withdrawal, Response response) {
                mlistener.onSuccess(withdrawal);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

}
