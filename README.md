# nessie-android-sdk

An Android SDK for the [Nessie API](http://api.reimaginebanking.com).  This SDK provides support for every Nessie API endpoint.  

The SDK is hosted in the JCenter maven repository.  You can access the SDK page on Bintray [here](https://bintray.com/mferraco/maven/NessieAndroidSDK).

You can view Javadocs [here](https://nessieisreal.github.io/nessie-android-sdk/).

## Installation  

In your module-specific build.gradle file add the following dependency.  

```java
dependencies {
	...
    compile 'com.reimaginebanking.api:nessie-android-sdk:1.0.4'
    ...
}
```

## Usage  

To query an API endpoint, get the NessieClient singleton and pass it your API key.

```java
NessieClient client = NessieClient.getInstance("api_key");
```

Then use that client to access all of the API methods.

```java
client.CUSTOMER.getCustomers(new NessieResultsListener() {
	@Override
	public void onSuccess(Object result) {
		List<Customer> customers = (List<Customer>) result;
		// do something with the list of customers here
	}

	@Override
	public void onFailure(NessieError error) {
		// handle error
	}
});

```

### Creating an Object  

Build an object using its builder methods, and then pass it as a parameter to the appropriate method.

```java
Deposit deposit = new Deposit.Builder()
            .amount(100)
            .description("DEPOSIT")
            .status("pending")
            .transactionDate("2016-08-09")
            .medium(TransactionMedium.BALANCE)
            .build();

client.DEPOSIT.createDeposit("deposit_id", deposit, new NessieResultsListener() {
    @Override
    public void onSuccess(Object result) {
        PostResponse<Deposit> response = (PostResponse<Deposit>) result;
        Deposit deposit = response.getObjectCreated();
        // do something with the newly created deposit
    }
    ...
});
```

### Updating an Object

Build an object with ONLY the attributes that you want to update.  Then pass it as a parameter to the appropriate method.

```
Deposit deposit = new Deposit.Builder()
			.description("UPDATED DEPOSIT")
			.build();

client.DEPOSIT.updateDeposit("deposit_id", deposit, new NessieTestResultsListener() {
    @Override
    public void onSuccess(Object result) {
        PutDeleteResponse response = (PutDeleteResponse) result;
        ...
    }
    ...
});
```

### Paginated Response

The response from the `ATM.getATMs` method is paginated due to the lengthly list of ATMs that could be returned.

```java
client.ATM.getATMs(lat, lng, rad, new NessieResultsListener() {
	@Override
	public void onSuccess(Object result) {
		PaginatedResponse<ATM> response = (PaginatedResponse<ATM>) result;
		// get the next set of ATMs

		client.ATM.getATMs(response.getPagingObject().getNextPage(), new NessieResultsListener() {
			// implement callback interface here
		})
	}

	@Override
	public void onFailure(NessieError error) {
		// handle error
	}
});
```

### Enterprise Endpoint  

A request to an enterprise endpoint can be made in the same way as the other GET requests above.  

```java
client.ENTERPRISE.getCustomersAsEnterprise(new NessieResultsListener() {
@Override
	public void onSuccess(Object result) {
		List<Customer> customers = (List<Customer>) result;
		// do something with the list of customers here
	}

	@Override
	public void onFailure(NessieError error) {
		// handle error
	}
});
```
