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

    private BillService mService;

    private String mKey;

    private static BillClient INSTANCE;

    private BillClient(String key, BillService service) {
        mKey = key;
        mService = service;
    }

    public static BillClient getInstance(String key, BillService service){
        if (INSTANCE == null) {
            INSTANCE = new BillClient(key, service);
        }
        return INSTANCE;
    }

    /**
     * Retrieve bills for a specific account.
     *
     * @param accountID The id of the account to retrieve bills for
     * @param listener The listener object which will implement the callback interface
     */
    public void getBillsByAccount(String accountID, final NessieResultsListener listener){
        mService.getBillsByAccount(mKey, accountID, new Callback<List<Bill>>() {
            @Override
            public void success(List<Bill> bills, Response response) {
                listener.onSuccess(bills);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    /**
     * Retrieve a single bill.
     *
     * @param billID The id of the bill to retrieve
     * @param listener The listener object which will implement the callback interface
     */
    public void getBill(String billID, final NessieResultsListener listener){
        mService.getBill(mKey, billID, new Callback<Bill>() {
            @Override
            public void success(Bill bill, Response response) {
                listener.onSuccess(bill);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    /**
     * Retrieve bills for a specific customer.
     *
     * @param customerID The id of the customer to retrieve bills for
     * @param listener The listener object which will implement the callback interface
     */
    public void getBillsByCustomer(String customerID, final NessieResultsListener listener){
        mService.getBillsByCustomer(mKey, customerID, new Callback<List<Bill>>() {
            @Override
            public void success(List<Bill> bills, Response response) {
                listener.onSuccess(bills);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    /**
     * Create a bill.
     *
     * @param accountID The id of the account which the bill is for
     * @param newBill The bill object to create
     * @param listener The listener object which will implement the callback interface
     */
    public void createBill(String accountID, Bill newBill, final NessieResultsListener listener){
        mService.createBill(mKey, accountID, newBill, new Callback<PostResponse<Bill>>() {
            public void success(PostResponse<Bill> postResponse, Response response) {
                listener.onSuccess(postResponse);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    /**
     * Update a bill.
     *
     * @param billID The id of the bill to update
     * @param updatedBill The bill object which includes the updates
     * @param listener The listener object which will implement the callback interface
     */
    public void updateBill(String billID, Bill updatedBill, final NessieResultsListener listener){
        mService.updateBill(mKey, billID, updatedBill, new Callback<PutDeleteResponse>() {
            public void success(PutDeleteResponse putResponse, Response response) {
                listener.onSuccess(putResponse);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    /**
     * Delete a bill.
     *
     * @param billId The id of the bill to delete
     * @param listener The listener object which will implement the callback interface
     */
    public void deleteBill(String billId, final NessieResultsListener listener){
        mService.deleteBill(mKey, billId, new Callback<PutDeleteResponse>() {
            public void success(PutDeleteResponse deleteResponse, Response response) {
                deleteResponse = new PutDeleteResponse(response.getStatus(), "Bill Deleted");
                listener.onSuccess(deleteResponse);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

}
