package com.reimaginebanking.api.nessieandroidsdk.requestclients;

import com.reimaginebanking.api.nessieandroidsdk.NessieError;
import com.reimaginebanking.api.nessieandroidsdk.NessieResultsListener;
import com.reimaginebanking.api.nessieandroidsdk.models.Bill;
import com.reimaginebanking.api.nessieandroidsdk.models.PostResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.PutDeleteResponse;
import com.reimaginebanking.api.nessieandroidsdk.requestservices.BillService;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A Client singleton object that provides methods for all Bill endpoints.
 */
public class BillClient {

    private BillService service;

    private String key;

    private static BillClient INSTANCE;

    private BillClient(String key, BillService service) {
        this.key = key;
        this.service = service;
    }

    public static BillClient getInstance(String key, BillService service){
        if (INSTANCE == null) {
            INSTANCE = new BillClient(key, service);
        }
        return INSTANCE;
    }

    public void getBillsByAccount(String accountID, final NessieResultsListener mlistener){
        service.getBillsByAccount(this.key, accountID, new Callback<List<Bill>>() {
            @Override
            public void success(List<Bill> bills, Response response) {
                mlistener.onSuccess(bills);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void getBill(String billID, final NessieResultsListener mlistener){
        service.getBill(this.key, billID, new Callback<Bill>() {
            @Override
            public void success(Bill bill, Response response) {
                mlistener.onSuccess(bill);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void getBillsByCustomer(String customerID, final NessieResultsListener mlistener){
        service.getBillsByCustomer(this.key, customerID, new Callback<List<Bill>>() {
            @Override
            public void success(List<Bill> bills, Response response) {
                mlistener.onSuccess(bills);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void createBill(String accountID, Bill newBill, final NessieResultsListener mlistener){
        service.createBill(this.key, accountID, newBill, new Callback<PostResponse<Bill>>() {
            public void success(PostResponse<Bill> postResponse, Response response) {
                mlistener.onSuccess(postResponse);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void updateBill(String billID, Bill updatedBill, final NessieResultsListener mlistener){
        service.updateBill(this.key, billID, updatedBill, new Callback<PutDeleteResponse>() {
            public void success(PutDeleteResponse putResponse, Response response) {
                mlistener.onSuccess(putResponse);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void deleteBill(String billId, final NessieResultsListener mlistener){
        service.deleteBill(this.key, billId, new Callback<PutDeleteResponse>() {
            public void success(PutDeleteResponse deleteResponse, Response response) {
                deleteResponse = new PutDeleteResponse(response.getStatus(), "Bill Deleted");
                mlistener.onSuccess(deleteResponse);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

}
