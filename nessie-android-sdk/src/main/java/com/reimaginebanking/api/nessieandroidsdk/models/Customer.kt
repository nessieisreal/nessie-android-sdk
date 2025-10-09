package com.reimaginebanking.api.nessieandroidsdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * A data class representing a Customer object.
 *
 * @property firstName The customer's first name.
 * @property lastName The customer's last name.
 * @property address The customer's address.
 * @property id The unique ID of the customer.
 */

data class Customer(
    @SerializedName("first_name")
    val firstName: String?,
    @SerializedName("last_name")
    val lastName: String?,
    @SerializedName("address")
    val address: Address?,
    @SerializedName("_id")
    val id: String? = null
)
