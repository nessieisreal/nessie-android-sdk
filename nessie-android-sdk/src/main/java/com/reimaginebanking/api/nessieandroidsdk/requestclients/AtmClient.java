package com.reimaginebanking.api.nessieandroidsdk.requestclients;


import com.reimaginebanking.api.nessieandroidsdk.NessieError;
import com.reimaginebanking.api.nessieandroidsdk.NessieResultsListener;
import com.reimaginebanking.api.nessieandroidsdk.models.ATM;
import com.reimaginebanking.api.nessieandroidsdk.models.PaginatedResponse;
import com.reimaginebanking.api.nessieandroidsdk.requestservices.AtmService;
import com.reimaginebanking.api.nessieandroidsdk.models.PagingObject;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A Client singleton object that provides methods for all ATM endpoints.
 */
public class AtmClient {

    private static final String TAG = AtmClient.class.getSimpleName();

    private AtmService mService;

    private String mKey;

    private static AtmClient INSTANCE;

    private AtmClient(String key, AtmService service) {
        mKey = key;
        mService = service;
    }

    public static AtmClient getInstance(String key, AtmService service){
        if (INSTANCE == null) {
            INSTANCE = new AtmClient(key, service);
        }
        return INSTANCE;
    }

    /**
     * Retrieve ATMs using a {@link PagingObject} previous or next URL.
     *
     * @param paginationUrl The URL which specifies which ATMs to retrive
     * @param listener The listener object which will implement the callback interface
     */
    public void getATMs(String paginationUrl, final NessieResultsListener listener) {
        if (paginationUrl.length() > 0) {
            paginationUrl = paginationUrl.substring(1);
        }
        mService.getATMsFromPaginationUrl(paginationUrl, new Callback<PaginatedResponse<ATM>>() {
            @Override
            public void success(PaginatedResponse<ATM> atmPaginatedResponse, Response response) {
                listener.onSuccess(atmPaginatedResponse);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    /**
     * Retrieve all ATMs within a specific area.
     *
     * Note: Response will be paginated.
     *
     * @param latitude The latitude line for the ATM search
     * @param longitude The longitude line for ATM search
     * @param radius The radius from the lat/lng point to search within
     * @param listener The listener object which will implement the callback interface
     */
    public void getATMs(Float latitude, Float longitude, Float radius, final NessieResultsListener listener) {
        getATMs(latitude, longitude, radius, 1, listener);
    }

    /**
     * Retrieve all ATMs within a specific area, but specify the page that you want to retrieve in the paginated response.
     *
     * Note: Response will be paginated
     *
     * @param latitude The latitude line for the ATM search
     * @param longitude The longitude line for ATM search
     * @param radius The radius from the lat/lng point to search within
     * @param page The page number of results to retrive
     * @param listener The listener object which will implement the callback interface
     */
    public void getATMs(Float latitude, Float longitude, Float radius, Integer page, final NessieResultsListener listener){
        mService.getATMs(mKey, latitude, longitude, radius, page, new Callback<PaginatedResponse<ATM>>() {
            public void success(PaginatedResponse<ATM> atms, Response response) {
                listener.onSuccess(atms);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    /**
     * Retrieve a single ATM.
     *
     * @param atmID The id of the ATM to retrieve
     * @param listener The listener object which will implement the callback interface
     */
    public void getATM(String atmID, final NessieResultsListener listener){
        mService.getATM(mKey, atmID, new Callback<ATM>() {
            public void success(ATM atm, Response response) {
                listener.onSuccess(atm);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }
}
