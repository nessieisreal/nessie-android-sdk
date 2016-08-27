package com.reimaginebanking.api.nessieandroidsdk.requestclients;

import com.reimaginebanking.api.nessieandroidsdk.NessieError;
import com.reimaginebanking.api.nessieandroidsdk.NessieResultsListener;
import com.reimaginebanking.api.nessieandroidsdk.models.Account;
import com.reimaginebanking.api.nessieandroidsdk.models.Bill;
import com.reimaginebanking.api.nessieandroidsdk.models.Customer;
import com.reimaginebanking.api.nessieandroidsdk.models.Deposit;
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

    private EnterpriseService mService;

    private String mKey;

    private static EnterpriseClient INSTANCE;

    private EnterpriseClient(String key, EnterpriseService service) {
        mKey = key;
        mService = service;
    }

    public static EnterpriseClient getInstance(String key, EnterpriseService service){
        if (INSTANCE == null) {
            INSTANCE = new EnterpriseClient(key, service);
        }
        return INSTANCE;
    }

    //ENTERPRISE ACCOUNT
    public void getAccountsAsEnterprise(final NessieResultsListener listener){
        mService.getAccountsAsEnterprise(mKey, new Callback<List<Account>>() {
            public void success(List<Account> accounts, Response response) {
                listener.onSuccess(accounts);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    public void getAccountAsEnterprise(String accountID, final NessieResultsListener listener){
        mService.getAccountAsEnterprise(mKey, accountID, new Callback<Account>() {
            public void success(Account account, Response response) {
                listener.onSuccess(account);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    //ENTERPRISE BILL
    public void getBillsAsEnterprise(final NessieResultsListener listener){
        mService.getBillsAsEnterprise(mKey, new Callback<List<Bill>>() {
            public void success(List<Bill> bills, Response response) {
                listener.onSuccess(bills);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    public void getBillAsEnterprise(String billID, final NessieResultsListener listener){
        mService.getBillAsEnterprise(mKey, billID, new Callback<Bill>() {
            public void success(Bill bill, Response response) {
                listener.onSuccess(bill);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    //ENTERPRISE CUSTOMER
    public void getCustomersAsEnterprise(final NessieResultsListener listener){
        mService.getCustomersAsEnterprise(mKey, new Callback<List<Customer>>() {
            public void success(List<Customer> customers, Response response) {
                listener.onSuccess(customers);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    public void getCustomerAsEnterprise(String customerID, final NessieResultsListener listener){
        mService.getCustomerAsEnterprise(mKey, customerID, new Callback<Customer>() {
            public void success(Customer customer, Response response) {
                listener.onSuccess(customer);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    //ENTERPRISE MERCHANT
    public void getMerchantsAsEnterprise(final NessieResultsListener listener){
        mService.getMerchantsAsEnterprise(mKey, new Callback<List<Merchant>>() {
            public void success(List<Merchant> customers, Response response) {
                listener.onSuccess(customers);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    public void getMerchantAsEnterprise(String merchantID, final NessieResultsListener listener){
        mService.getMerchantAsEnterprise(mKey, merchantID, new Callback<Merchant>() {
            public void success(Merchant merchant, Response response) {
                listener.onSuccess(merchant);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    //ENTERPRISE TRANSFER
    public void getTransfersAsEnterprise(final NessieResultsListener listener){
        mService.getTransfersAsEnterprise(mKey, new Callback<List<Transfer>>() {
            public void success(List<Transfer> customers, Response response) {
                listener.onSuccess(customers);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    public void getTransferAsEnterprise(String transferID, final NessieResultsListener listener){
        mService.getTransferAsEnterprise(mKey, transferID, new Callback<Transfer>() {
            public void success(Transfer transfer, Response response) {
                listener.onSuccess(transfer);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    //ENTERPRISE WITHDRAWAL
    public void getWithdrawalsAsEnterprise(final NessieResultsListener listener){
        mService.getWithdrawalsAsEnterprise(mKey, new Callback<List<Withdrawal>>() {
            public void success(List<Withdrawal> withdrawals, Response response) {
                listener.onSuccess(withdrawals);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    public void getWithdrawalAsEnterprise(String withdrawalID, final NessieResultsListener listener){
        mService.getWithdrawalAsEnterprise(mKey, withdrawalID, new Callback<Withdrawal>() {
            public void success(Withdrawal withdrawal, Response response) {
                listener.onSuccess(withdrawal);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    //ENTERPRISE DEPOSIT
    public void getDepositsAsEnterprise(final NessieResultsListener listener){
        mService.getDepositsAsEnterprise(mKey, new Callback<List<Deposit>>() {
            public void success(List<Deposit> deposits, Response response) {
                listener.onSuccess(deposits);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    public void getDepositAsEnterprise(String depositId, final NessieResultsListener listener){
        mService.getDepositAsEnterprise(mKey, depositId, new Callback<Deposit>() {
            public void success(Deposit deposit, Response response) {
                listener.onSuccess(deposit);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

}
