package com.reimaginebanking.api.nessieandroidsdk.requestclients;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.reimaginebanking.api.nessieandroidsdk.requestservices.AccountService;
import com.reimaginebanking.api.nessieandroidsdk.requestservices.AtmService;
import com.reimaginebanking.api.nessieandroidsdk.requestservices.BillService;
import com.reimaginebanking.api.nessieandroidsdk.requestservices.BranchService;
import com.reimaginebanking.api.nessieandroidsdk.requestservices.CustomerService;
import com.reimaginebanking.api.nessieandroidsdk.requestservices.DepositService;
import com.reimaginebanking.api.nessieandroidsdk.requestservices.EnterpriseService;
import com.reimaginebanking.api.nessieandroidsdk.requestservices.MerchantService;
import com.reimaginebanking.api.nessieandroidsdk.requestservices.PurchaseService;
import com.reimaginebanking.api.nessieandroidsdk.requestservices.TransferService;
import com.reimaginebanking.api.nessieandroidsdk.requestservices.WithdrawalService;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * A parent class for all of the Nessie Clients that holds shared logic
 */
public class NessieClient {

    private String key;

    /* SERVICES */

    private AccountService accountService;

    private AtmService atmService;

    private BillService billService;

    private BranchService branchService;

    private CustomerService customerService;

    private DepositService depositService;

    private EnterpriseService enterpriseService;

    private MerchantService merchantService;

    private PurchaseService purchaseService;

    private TransferService transferService;

    private WithdrawalService withdrawalService;

    /* CLIENTS */

    private static NessieClient INSTANCE;

    public final AccountClient ACCOUNT;

    public final AtmClient ATM;

    public final BillClient BILL;

    public final BranchClient BRANCH;

    public final CustomerClient CUSTOMER;

    public final DepositClient DEPOSIT;

    public final EnterpriseClient ENTERPRISE;

    public final MerchantClient MERCHANT;

    public final PurchaseClient PURCHASE;

    public final TransferClient TRANSFER;

    public final WithdrawalClient WITHDRAWAL;


    private NessieClient(String key, RestAdapter ra) {
        this.key = key;

        Gson gson = new GsonBuilder()
            .create();

        RestAdapter restAdapter;

        if (ra == null) {
            restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://api.reimaginebanking.com")
                .setConverter(new GsonConverter(gson))
                .build();
        } else {
            restAdapter = ra;
        }


        // Instantiate services
        accountService = restAdapter.create(AccountService.class);
        atmService = restAdapter.create(AtmService.class);
        billService = restAdapter.create(BillService.class);
        branchService = restAdapter.create(BranchService.class);
        customerService = restAdapter.create(CustomerService.class);
        depositService = restAdapter.create(DepositService.class);
        enterpriseService = restAdapter.create(EnterpriseService.class);
        merchantService = restAdapter.create(MerchantService.class);
        purchaseService = restAdapter.create(PurchaseService.class);
        transferService = restAdapter.create(TransferService.class);
        withdrawalService = restAdapter.create(WithdrawalService.class);

        // Instantiate other clients for access through NessieClient
        ACCOUNT = AccountClient.getInstance(this.key, accountService);
        ATM = AtmClient.getInstance(this.key, atmService);
        BILL = BillClient.getInstance(this.key, billService);
        BRANCH = BranchClient.getInstance(this.key, branchService);
        CUSTOMER = CustomerClient.getInstance(this.key, customerService);
        DEPOSIT = DepositClient.getInstance(this.key, depositService);
        ENTERPRISE = EnterpriseClient.getInstance(this.key, enterpriseService);
        MERCHANT = MerchantClient.getInstance(this.key, merchantService);
        PURCHASE = PurchaseClient.getInstance(this.key, purchaseService);
        TRANSFER = TransferClient.getInstance(this.key, transferService);
        WITHDRAWAL = WithdrawalClient.getInstance(this.key, withdrawalService);
    }

    public static NessieClient getInstance(String key){
        if (INSTANCE == null) {
            INSTANCE = new NessieClient(key, null);
        }

        return INSTANCE;
    }

    public static NessieClient getInstance(String key, RestAdapter ra) {
        if (INSTANCE == null) {
            INSTANCE = new NessieClient(key, ra);
        }

        return INSTANCE;
    }
}
