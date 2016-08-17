package com.reimaginebanking.api.nessieandroidsdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * A class representing the paging data included in a paginated response from the API.
 */
public class PagingObject {

    @SerializedName("previous")
    private String mPreviousPage;

    @SerializedName("next")
    private String mNextPage;

    public PagingObject(String previousPage, String nextPage) {
        mPreviousPage = previousPage;
        mNextPage = nextPage;
    }

    public String getPreviousPage() {
        return mPreviousPage;
    }

    public String getNextPage() {
        return mNextPage;
    }

}
