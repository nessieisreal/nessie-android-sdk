package com.reimaginebanking.api.nessieandroidsdk.requestclients;

import com.reimaginebanking.api.nessieandroidsdk.NessieError;
import com.reimaginebanking.api.nessieandroidsdk.NessieResultsListener;
import com.reimaginebanking.api.nessieandroidsdk.constants.TransferAccountType;
import com.reimaginebanking.api.nessieandroidsdk.models.PostResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.PutDeleteResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.Transfer;
import com.reimaginebanking.api.nessieandroidsdk.requestservices.TransferService;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A Client singleton object that provides methods for all Transfer endpoints.
 */
public class TransferClient {

    private TransferService mService;

    private String mKey;

    private static TransferClient INSTANCE;

    private TransferClient(String key, TransferService service) {
        mKey = key;
        mService = service;
    }

    public static TransferClient getInstance(String key, TransferService service){
        if (INSTANCE == null) {
            INSTANCE = new TransferClient(key, service);
        }
        return INSTANCE;
    }

    /**
     * Retrieve transfers where the specified account is the payer OR the payee
     *
     * @param accountId The id of the account to retrieve transfers for
     * @param listener The listener object which will implement the callback interface
     */
    public void getTransfers(String accountId, final NessieResultsListener listener){
        getTransfers(accountId, null, listener);
    }

    /**
     * Retrieves transfers where the specified account is the specified TransferAccountType
     *
     * @param accountId The is of the account to retrieve transfers for
     * @param type The account type to retrieve transfers for (payer, payee, etc.)
     * @param listener The listener object which will implement the callback interface
     */
    public void getTransfers(String accountId, TransferAccountType type, final NessieResultsListener listener) {
        mService.getTransfers(mKey, accountId, type, new Callback<List<Transfer>>() {
            @Override
            public void success(List<Transfer> transfers, Response response) {
                listener.onSuccess(transfers);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    /**
     * Retrieve a single transfer.
     *
     * @param transferId The id of the transfer to retrieve
     * @param listener The listener object which will implement the callback interface
     */
    public void getTransfer(String transferId, final NessieResultsListener listener){
        mService.getTransfer(mKey, transferId, new Callback<Transfer>() {
            @Override
            public void success(Transfer transaction, Response response) {
                listener.onSuccess(transaction);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    /**
     * Create a transfer.
     *
     * @param accountId The id of the account the transfer initiates from
     * @param transfer The transfer object to create
     * @param listener The listener object which will implement the callback interface
     */
    public void createTransfer(String accountId, Transfer transfer, final NessieResultsListener listener){
        mService.createTransfer(mKey, accountId, transfer, new Callback<PostResponse<Transfer>>() {

            @Override
            public void success(PostResponse<Transfer> postResponse, Response response) {
                listener.onSuccess(postResponse);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    /**
     * Update a transfer. A transfer can only be updated before it is executed.
     *
     * @param transferId The id of the transfer to update
     * @param transfer The transfer object which includes the updates
     * @param listener The listener object which will implement the callback interface
     */
    public void updateTransfer(String transferId, Transfer transfer, final NessieResultsListener listener){
        mService.updateTransfer(mKey, transferId, transfer, new Callback<PutDeleteResponse>() {
            @Override
            public void success(PutDeleteResponse putResponse, Response response) {
                listener.onSuccess(putResponse);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    /**
     * Delete a transfer. A transfer can only be deleted before it is executed.
     *
     * @param transferId The id of the transfer to delete
     * @param listener The listener object which will implement the callback interface
     */
    public void deleteTransfer(String transferId, final NessieResultsListener listener){
        mService.deleteTransfer(mKey, transferId, new Callback<PutDeleteResponse>() {
            @Override
            public void success(PutDeleteResponse deleteResponse, Response response) {
                deleteResponse = new PutDeleteResponse(response.getStatus(), "Transfer Deleted");
                listener.onSuccess(deleteResponse);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }
}
