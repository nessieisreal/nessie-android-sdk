package com.reimaginebanking.api.nessieandroidsdk.requestclients;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.reimaginebanking.api.nessieandroidsdk.NessieException;
import com.reimaginebanking.api.nessieandroidsdk.NessieResultsListener;
import com.reimaginebanking.api.nessieandroidsdk.models.Bill;
import com.reimaginebanking.api.nessieandroidsdk.models.RequestResponse;
import com.reimaginebanking.api.nessieandroidsdk.requestservices.NessieService;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.io.IOException;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A Client singleton object that provides methods for all Bill endpoints.
 */
public class BillClient {

    private NessieService service;

    private String key;

    private static BillClient INSTANCE;

    private BillClient(String key, NessieService service) {
        this.key = key;
        this.service = service;
    }

    public static BillClient getInstance(String key, NessieService service){
        if (INSTANCE == null) {
            INSTANCE = new BillClient(key, service);
        }
        return INSTANCE;
    }

    public void getBills(String accountID, final NessieResultsListener mlistener){
        final OkHttpClient client = new OkHttpClient();
        final String url = "http://api.reimaginebanking.com/accounts/" + accountID + "/bills?key=" + key;
        Request request = new Request.Builder()
            .url(url)
            .addHeader("Content-Type", "application/json")
            .addHeader("Accept", "application/json")
            .build();

        client.newCall(request).enqueue(new com.squareup.okhttp.Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                mlistener.onSuccess(null, new NessieException(RetrofitError.networkError(url, e)));
            }

            @Override
            public void onResponse(com.squareup.okhttp.Response response) throws IOException {
                String body = response.body().string();
                Gson gson = new Gson();
                List<Bill> bills = gson.fromJson(body, new TypeToken<List<Bill>>(){}.getType());
                mlistener.onSuccess(bills, null);
            }
        });
//        service.getBills(this.key, accountID, new Callback<List<Bill>>() {
//            @Override
//            public void success(List<Bill> bills, Response response) {
//                mlistener.onSuccess(bills, null);
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//                mlistener.onSuccess(null, new NessieException(error));
//            }
//        });
    }

    public void getBill(String billID, final NessieResultsListener mlistener){
        service.getBill(this.key, billID, new Callback<Bill>() {
            @Override
            public void success(Bill bill, Response response) {
                mlistener.onSuccess(bill, null);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getCustomerBills(String customerID, final NessieResultsListener mlistener){
        final OkHttpClient client = new OkHttpClient();
        final String url = "http://api.reimaginebanking.com/customers/" + customerID + "/bills?key=" + key;
        Request request = new Request.Builder()
            .url(url)
            .addHeader("Content-Type", "application/json")
            .addHeader("Accept", "application/json")
            .build();

        client.newCall(request).enqueue(new com.squareup.okhttp.Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                mlistener.onSuccess(null, new NessieException(RetrofitError.networkError(url, e)));
            }

            @Override
            public void onResponse(com.squareup.okhttp.Response response) throws IOException {
                String body = response.body().string();
                Gson gson = new Gson();
                List<Bill> bills = gson.fromJson(body, new TypeToken<List<Bill>>() {
                }.getType());
                mlistener.onSuccess(bills, null);
            }
        });
    }

    public void createBill(String accountID, Bill newBill, final NessieResultsListener mlistener){
        service.createBill(this.key, accountID, newBill, new Callback<RequestResponse>() {
            public void success(RequestResponse requestResponse, Response response) {
                mlistener.onSuccess(requestResponse, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void updateBill(String billID, Bill updatedBill, final NessieResultsListener mlistener){
        service.updateBill(this.key, billID, updatedBill, new Callback<RequestResponse>() {
            public void success(RequestResponse requestResponse, Response response) {
                mlistener.onSuccess(requestResponse, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void deleteBill(String billId, final NessieResultsListener mlistener){
        service.deleteBill(this.key, billId, new Callback<RequestResponse>() {
            public void success(RequestResponse requestResponse, Response response) {
                requestResponse = new RequestResponse(response.getStatus(), "Bill Deleted");
                mlistener.onSuccess(requestResponse, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

}
