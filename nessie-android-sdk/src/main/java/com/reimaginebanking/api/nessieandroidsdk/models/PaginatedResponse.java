package com.reimaginebanking.api.nessieandroidsdk.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * A class representing a response from the API that is paginated.
 */
public class PaginatedResponse<T> {

    @SerializedName("data")
    private List<T> mObjectList;

    @SerializedName("paging")
    private PagingObject mPagingObject;

    public PaginatedResponse(List<T> objectList, PagingObject pagingObject) {
        mObjectList = objectList;
        mPagingObject = pagingObject;
    }

    public List<T> getObjectList() {
        return mObjectList;
    }

    public PagingObject getPagingObject() {
        return mPagingObject;
    }

}
