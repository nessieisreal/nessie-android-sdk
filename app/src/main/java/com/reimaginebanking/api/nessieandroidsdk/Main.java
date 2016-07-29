package com.reimaginebanking.api.nessieandroidsdk;

import com.reimaginebanking.api.nessieandroidsdk.models.Customer;
import com.reimaginebanking.api.nessieandroidsdk.requestclients.NessieClient;

import java.util.ArrayList;

/**
 * Created by kco942 on 4/9/15.
 */
public class Main {
    public static void main(String[] args) {
        //String key = "c3f7f751db5dc04db17a1aed58d319e9";
        String key = "68ff704991bbd54e1d11dbb82b56d663";
        NessieClient nessieClient = NessieClient.getInstance(key);

//        final OkHttpClient client = new OkHttpClient();

//        Request request = new Request.Builder()
//                .url("http://api.reimaginebanking.com/enterprise/customers?key=c8401d90ec390300090ef500d40b3ebc")
//                .build();
//
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Request request, IOException e) {
//                System.out.println(e.toString());
//            }
//
//            @Override
//            public void onResponse(Response response) throws IOException {
//                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
//                Headers responseHeaders = response.headers();
//                for (int i = 0; i < responseHeaders.size(); i++) {
//                    System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
//                }
//                String message = response.body().string();
//                System.out.println(message);
////                Gson gson = new Gson();
////                Type listType = new TypeToken<List<Customer>>(){}.getType();
////                List<Customer> customers = gson.fromJson(message, listType);
////                System.out.println(customers.size());
//
//                Gson gson = new Gson();
//                JsonParser parse = new JsonParser();
//                JsonArray jsonArray = parse.parse(message).getAsJsonArray();
//
//                ArrayList<Customer> customers = new ArrayList<Customer>();
//
//                for(JsonElement obj: jsonArray){
//                    Customer customer = gson.fromJson(obj, Customer.class);
//                    customers.add(customer);
//                }
//
//                System.out.println(customers.size());
//            }
//        });


        //WORKS
        nessieClient.CUSTOMER.getCustomers(new NessieResultsListener() {
            @Override
            public void onSuccess(Object result, NessieException e) {
                if (e == null) {
                    ArrayList<Customer> customers = (ArrayList<Customer>) result;
                    System.out.println("CUSTOMERS TEST");
                    System.out.println(customers.size());
                    //System.out.println(customers.get(0).toString());
                    for(Customer customer: customers){
                        System.out.println(customer.toString());
                    }
                } else {
                    System.out.println("CUSTOMERS TEST");
                    System.out.println(e.toString());
                }
            }
        });
////
//        nessieClient.getCustomersAsEnterprise(new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//                if (e == null) {
//                    ArrayList<Customer> customers = (ArrayList<Customer>) result;
//                    System.out.println("ENTERPRISE CUSTOMERS TEST");
//                    System.out.println(customers.size());
//                    System.out.println(customers.get(0).toString());
//                }else {
//                    System.out.println(e.toString());
//                }
//            }
//        });
//


        //WORKS
//        nessieClient.getCustomer("5516c07ba520e0066c9ac365", new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//                if (e == null) {
//                    Customer customer = (Customer) result;
//                    System.out.println("CUSTOMER TEST");
//                    System.out.println(customer.toString());
//                } else {
//                    System.out.println("CUSTOMER TEST");
//                    System.out.println(e.toString());
//                }
//            }
//        });
//

        //WORKS
//        nessieClient.getCustomerAsEnterprise("5516c07ba520e0066c9ac365", new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//                if (e == null) {
//                    Customer customer = (Customer) result;
//                    System.out.println("CUSTOMER TEST");
//                    System.out.println(customer.toString());
//                }
//            }
//        });
//

//        //WORKS
//        nessieClient.getCustomerAccounts("5516c07ba520e0066c9ac365", new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//                if (e == null) {
//                    ArrayList<Account> accounts = (ArrayList<Account>) result;
//                    System.out.println("ACCOUNTS TEST");
//                    System.out.println(accounts.size());
//                    System.out.println(accounts.get(1).toString());
//                }
//            }
//        });
//

        //WORKS
//        Bill bill = new Bill.Builder()
//                .status(BillStatus.PENDING)
//                .payee("THING")
//                .nickname("Spotify")
//                .payment_date("2015-05-20")
//                .payment_amount(10)
//                .build();
//
//        nessieClient.createBill("5516c07ba520e0066c9ac73c", bill, new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//                if (e == null) {
//                    RequestResponse response = (RequestResponse) result;
//                    System.out.println("CREATE BILL TEST");
//                    System.out.println(response.toString());
//                } else {
//                    System.out.println("CREATE BILL TEST");
//                    System.out.println(e.toString());
//                }
//            }
//        });

        //WORKS
//        nessieClient.getBills("5516c07ba520e0066c9ac366", new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//                if(e == null){
//                    ArrayList<Bill> bills = (ArrayList<Bill>) result;
//                    System.out.println("BILLS TEST");
//                    System.out.println(bills.size());
//                    for(Bill bill:bills){
//                        System.out.println(bill.toString());
//                    }
//                } else {
//                    System.out.println(e.toString());
//                }
//            }
//        });

        //WORKS
//        nessieClient.getBill("5516c07ba520e0066c9ac73c", "5516c07ba520e0066c9acabb", new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//                if(e == null){
//                    Bill bills = (Bill) result;
//                    System.out.println("BILL TEST");
//                    System.out.println(bills.toString());
//                } else {
//                    System.out.println(e.toString());
//                }
//            }
//        });
//
        //WORKS
//        nessieClient.getCustomerBills("5516c07ba520e0066c9ac365", new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//                if (e == null) {
//                    ArrayList<Bill> bills = (ArrayList<Bill>) result;
//                    System.out.println("BILLS TEST");
//                    System.out.println(bills.size());
//                    if(bills.size() != 0)
//                        System.out.println(bills.get(0).toString());
//                } else {
//                    System.out.println(e.toString());
//                }
//            }
//        });


        //WORKS
//        nessieClient.getCustomerBill("5516c07ba520e0066c9ac365", "5516c07ba520e0066c9acabf", new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//                if (e == null) {
//                    Bill bill = (Bill) result;
//                    System.out.println("BILL TEST");
//                    System.out.println(bill.toString());
//                }
//            }
//        });
//

        //WORKS BUT HAVE TO GIVE WHOLE ADDRESS - ADD VALIDATION
//        Address address = new Address.Builder()
//                .zip("20120")
//                .build();
//
//        Customer customer = new Customer(address);
//
//        nessieClient.updateCustomer("5516c07ba520e0066c9ac365", customer, new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//                if (e == null) {
//                    RequestResponse response = (RequestResponse) result;
//                    System.out.println("UPDATE CUSTOMER TEST");
//                    System.out.println(response.toString());
//                }
//            }
//        });

        //WORKS
//        Account account = new Account.Builder()
//                .type(AccountType.CHECKING)
//                .nickname("TEST ACCOUNT")
//                .rewards(100)
//                .balance(100)
//                .build();
//        nessieClient.createAccount("555bed95a520e036e52b20fe", account, new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//                if (e == null) {
//                    RequestResponse response = (RequestResponse) result;
//                    System.out.println("CREATE ACCOUNT TEST");
//                    System.out.println(response.toString());
//                } else {
//                    System.out.println(e.toString());
//                }
//            }
//        });

        //WORKS
//        nessieClient.getBranches(new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//                if (e == null) {
//                    ArrayList<Branch> branches = (ArrayList<Branch>) result;
//                    System.out.println("BRANCHES TEST");
//                    System.out.println(branches.get(0).toString());
//                }
//            }
//        });
        //WORKS
//        nessieClient.getBranch("5516c07aa520e0066c9ac24a", new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//                if (e == null) {
//                    Branch branch = (Branch) result;
//                    System.out.println("BRANCH TEST");
//                    System.out.println(branch.toString());
//                }
//            }
//        });
//
        //WORKS
//        nessieClient.getATMs(new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//                if (e == null) {
//                    ArrayList<ATM> atms = (ArrayList<ATM>) result;
//                    System.out.println("ATMS TEST");
//                    System.out.println(atms.get(0).toString());
//                }
//            }
//        });
//
        //WORKS
//        nessieClient.getATM("5528b769a520e026b80e186c", new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//                if (e == null) {
//                    ATM atm = (ATM) result;
//                    System.out.println("ATM TEST");
//                    System.out.println(atm.toString());
//                }
//            }
//        });
//

        //WORKS
//        nessieClient.getAccount("5516c07ba520e0066c9ac73c", new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//                if (e == null) {
//                    Account account = (Account) result;
//                    System.out.println("ACCOUNT TEST");
//                    System.out.println(account.toString());
//                }
//            }
//        });
//
        //WORKS
//        nessieClient.getAccountAsEnterprise("5516c07ba520e0066c9ac73c", new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//                if (e == null) {
//                    Account account = (Account) result;
//                    System.out.println("ACCOUNT TEST");
//                    System.out.println(account.toString());
//                }
//            }
//        });

        //WORKS
//        nessieClient.getAccountCustomer("5516c07ba520e0066c9ac73c", new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//                if (e == null) {
//                    Customer customer = (Customer) result;
//                    System.out.println("CUSTOMER TEST");
//                    System.out.println(customer.toString());
//                }
//            }
//        });
//


        //WORKS
//        nessieClient.deleteAccount("554be87b7e8f3fac7c287aa1", new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//                if (e == null) {
//                    RequestResponse response = (RequestResponse) result;
//                    System.out.println("DELETE ACCOUNT TEST");
//                    System.out.println(response.toString());
//                }else {
//                    System.out.println(e.toString());
//                }
//            }
//        });

//        nessieClient.createBill("ACCOUNT-ID", new Bill(), new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//                if (e == null) {
//                    RequestResponse response = (RequestResponse) result;
//                    System.out.println("CREATE BILL TEST");
//                    System.out.println(response.toString());
//                }
//            }
//        });

        //WORKS
//        Bill bill = new Bill.Builder()
//                //.nickname("TEST")
//                .build();
//
//        Gson gson = new GsonBuilder()
//                .registerTypeAdapter(Bill.class, new BillTypeAdapter())
//                .create();
//
//        System.out.println(gson.toJson(bill));
//
//        nessieClient.updateBill("5516c07ba520e0066c9ac73c", "5516c07ba520e0066c9acabb", bill, new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//                if (e == null) {
//                    RequestResponse response = (RequestResponse) result;
//                    System.out.println("CREATE BILL TEST");
//                    System.out.println(response.toString());
//                } else {
//                    System.out.println(e.toString());
//                }
//            }
//        });

//        Transfer transaction = new Transfer.Builder()
//                .medium(TransactionMedium.BALANCE)
//                .payee_id("5516c07ba520e0066c9ac6e")
//                .amount(10)
//                .description("DESCRIPTION")
//                .build();
//
//        nessieClient.createTransaction("5516c07ba520e0066c9ac73c", transaction, new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//                if (e == null) {
//                    RequestResponse response = (RequestResponse) result;
//                    System.out.println("CREATE TRANSACTION TEST");
//                    System.out.println(response.toString());
//                }else {
//                    System.out.println(e.toString());
//                }
//            }
//        });
        //WORKS
//        nessieClient.getTransactions("5516c07ba520e0066c9ac73c", new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//                if (e == null) {
//                    ArrayList<Transfer> transactions = (ArrayList<Transfer>) result;
//                    System.out.println("TRANSACTIONS TEST");
//                    System.out.println(transactions.size());
//                    if(transactions.size() > 0) {
//                        System.out.println(transactions.get(0).toString());
//                    }
//                } else {
//                    System.out.println(e.toString());
//                }
//            }
//        });
//

//
//        nessieClient.getTransaction("ACCOUNT-ID", "TRANSACTION-ID", new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//                if (e == null) {
//                    Transfer transaction = (Transfer) result;
//                    System.out.println("TRANSACTION TEST");
//                    System.out.println(transaction.toString());
//                }
//            }
//        });
//

        //WORKS
//        nessieClient.getAccountsAsEnterprise(new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//                if(e == null){
//                    ArrayList<Account> accounts = (ArrayList<Account>) result;
//                    System.out.println(accounts.size());
//                    System.out.println(accounts.get(0).toString());
//                }
//            }
//        });

        //WORKS
//        nessieClient.getBillsAsEnterprise(new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//                if (e == null) {
//                    ArrayList<Bill> bills = (ArrayList<Bill>) result;
//                    System.out.println(bills.size());
//                    System.out.println(bills.get(0).toString());
//                }
//            }
//        });

        //WORKS
//        nessieClient.getTransactionsAsEnterprise(new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//                if (e == null) {
//                    ArrayList<Transfer> transactions = (ArrayList<Transfer>) result;
//                    System.out.println(transactions.size());
//                    System.out.println(transactions.get(0).toString());
//                }
//            }
//        });

        //WORKS
//        nessieClient.getTransactionAsEnterprise("552978a2d2053f602e731d60", new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//                if (e == null) {
//                    Transfer transaction = (Transfer) result;
//                    System.out.println(transaction.toString());
//                } else {
//                    System.out.println(e.toString());
//                }
//            }
//        });

        //WORKS
//        nessieClient.getBillAsEnterprise("5516c07ba520e0066c9ace1c", new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//                if (e == null) {
//                    Bill bill = (Bill) result;
//                    System.out.println(bill.toString());
//                } else {
//                    System.out.println(e.toString());
//                }
//            }
//        });

        //////////////////////////////////////////

        //works
//        Transfer deposit = new Transfer.Builder()
//                .medium(TransactionMedium.BALANCE)
//                .amount(10.10)
//                .description("PAYCHECK")
//                .build();
//
//        nessieClient.createDeposit("5516c07ba520e0066c9ac73c", deposit, new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//                if(e == null){
//                    RequestResponse requestResponse = (RequestResponse) result;
//                    System.out.println(requestResponse.toString());
//                } else {
//                    System.out.println(e.toString());
//                }
//            }
//        });

//        Transfer withdraw = new Transfer.Builder()
//                .medium(TransactionMedium.BALANCE)
//                .amount(10.10)
//                .description("PAYCHECK")
//                .build();
//
//        nessieClient.createWithdrawal("5516c07ba520e0066c9ac73c", withdraw, new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//                if(e == null){
//                    RequestResponse requestResponse = (RequestResponse) result;
//                    System.out.println(requestResponse.toString());
//                } else {
//                    System.out.println(e.toString());
//                }
//            }
//        });

//        nessieClient.getDeposits("5516c07ba520e0066c9ac73c", new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object result, NessieException e) {
//                List<Transfer> deposits = (List<Transfer>) result;
//                System.out.println(deposits.size());
//                for(Transfer deposit : deposits){
//                    System.out.println(deposit.toString());
//                }
//            }
//        });

        //WORKS
        //testing createPurchase()
//        System.out.println("purchase test");
//            Purchase.Builder pb = new Purchase.Builder();
//            Purchase p = pb.amount(1.00)
//                    .description("test purchase please ignore")
//                    .medium("balance")
//                    .purchase_date("2016-02-27")
//                    .status("pending")
//                    .merchant("56c66be6a73e492741507624")
//                    .build();
//        System.out.println(p);
//            nessieClient.createPurchase("56c66be6a73e492741507f1d", p, new NessieResultsListener() {
//                @Override
//                public void onSuccess(Object result, NessieException e) {
//                    System.out.println("success creating purchase!");
//                }
//            });

        System.out.println("HELLO");
        
    }

}
