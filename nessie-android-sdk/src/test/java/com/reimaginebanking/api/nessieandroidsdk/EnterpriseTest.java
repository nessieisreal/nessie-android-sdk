package com.reimaginebanking.api.nessieandroidsdk;

import com.reimaginebanking.api.nessieandroidsdk.constants.AccountType;
import com.reimaginebanking.api.nessieandroidsdk.constants.BillStatus;
import com.reimaginebanking.api.nessieandroidsdk.models.Account;
import com.reimaginebanking.api.nessieandroidsdk.models.Bill;
import com.reimaginebanking.api.nessieandroidsdk.models.Customer;
import com.reimaginebanking.api.nessieandroidsdk.models.Deposit;
import com.reimaginebanking.api.nessieandroidsdk.models.Merchant;
import com.reimaginebanking.api.nessieandroidsdk.models.Transfer;
import com.reimaginebanking.api.nessieandroidsdk.models.Withdrawal;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests all enterprise endpoints against mock responses.
 */
public class EnterpriseTest extends NessieTest {

    /* GET /enterprise/customers/:id */
    @Test
    public void testGetEnterpriseCustomer() throws Exception {
        client.ENTERPRISE.getCustomerAsEnterprise("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                Customer customer = (Customer) result;
                assertEquals("Emily", customer.getFirstName());
                assertEquals("Kinney", customer.getLastName());
            }
        });
    }

    /* GET /enterprise/customers */
    @Test
    public void testGetEnterpriseCustomers() throws Exception {
        client.ENTERPRISE.getCustomersAsEnterprise(new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                List<Customer> customers = (List<Customer>) result;
                assertEquals(customers.size(), 3);
                assertEquals("Emily", customers.get(0).getFirstName());
                assertEquals("Kinney", customers.get(0).getLastName());
            }
        });
    }

    /* GET /enterprise/accounts/:id */
    @Test
    public void testGetEnterpriseAccount() throws Exception {
        client.ENTERPRISE.getAccountAsEnterprise("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                Account account = (Account) result;
                assertEquals(32698, account.getRewards(), 0);
                assertEquals(AccountType.CHECKING, account.getType());
            }
        });
    }

    /* GET /enterprise/accounts */
    @Test
    public void testGetEnterpriseAccounts() throws Exception {
        client.ENTERPRISE.getAccountsAsEnterprise(new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                List<Account> accounts = (List<Account>) result;
                assertEquals(accounts.size(), 5);
                assertEquals(AccountType.CHECKING, accounts.get(0).getType());
                assertEquals(38998, accounts.get(0).getBalance(), 0);
            }
        });
    }

    /* GET /enterprise/bils/:id */
    @Test
    public void testGetEnterpriseBill() throws Exception {
        client.ENTERPRISE.getBillAsEnterprise("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                Bill bill = (Bill) result;
                assertEquals("56c66be7a73e492741508473", bill.getId());
                assertEquals(BillStatus.CANCELLED, bill.getStatus());
            }
        });
    }

    /* GET /enterprise/bills */
    @Test
    public void testGetEnterpriseBills() throws Exception {
        client.ENTERPRISE.getBillsAsEnterprise(new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                List<Bill> bills = (List<Bill>) result;
                assertEquals(1, bills.size());
                assertEquals("56c66be7a73e492741508470", bills.get(0).getId());
            }
        });
    }

    /* GET /enterprise/merchants/:id */
    @Test
    public void testGetEnterpriseMerchant() throws Exception {
        client.ENTERPRISE.getMerchantAsEnterprise("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                Merchant merchant = (Merchant) result;
                assertEquals("Wells Fargo Center", merchant.getName());
            }
        });
    }

    /* GET /enterprise/merchants */
    @Test
    public void testGetEnterpriseMerchants() throws Exception {
        client.ENTERPRISE.getMerchantsAsEnterprise(new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                List<Merchant> merchants = (List<Merchant>) result;
                assertEquals(4, merchants.size());
                assertEquals("56c66be6a73e492741507624", merchants.get(0).getId());
                assertEquals("Jetro", merchants.get(3).getName());
            }
        });
    }

    /* GET /enterprise/transfers/:id */
    @Test
    public void testGetEnterpriseTransfer() throws Exception {
        client.ENTERPRISE.getTransferAsEnterprise("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                Transfer transfer = (Transfer) result;
                assertEquals("57adec16bc727e4b519f265a", transfer.getId());
                assertEquals("cancelled", transfer.getStatus());
            }
        });
    }

    /* GET /enterprise/transfers */
    @Test
    public void testGetEnterpriseTransfers() throws Exception {
        client.ENTERPRISE.getTransfersAsEnterprise(new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                List<Transfer> transfers = (List<Transfer>) result;
                assertEquals(3, transfers.size());
                assertEquals("57adeba6bc727e4b519f2658", transfers.get(0).getId());
                assertEquals("cancelled", transfers.get(2).getStatus());
            }
        });
    }

    /* GET /enterprise/withdrawals/:id */
    @Test
    public void testGetEnterpriseWithdrawal() throws Exception {
        client.ENTERPRISE.getWithdrawalAsEnterprise("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                Withdrawal withdrawal = (Withdrawal) result;
                assertEquals("57aa33c4bc727e4b519f25db", withdrawal.getId());
                assertEquals("cancelled", withdrawal.getStatus());
            }
        });
    }

    /* GET /enterprise/withdrawals */
    @Test
    public void testGetEnterpriseWithdrawals() throws Exception {
        client.ENTERPRISE.getWithdrawalsAsEnterprise(new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                List<Withdrawal> withdrawals = (List<Withdrawal>) result;
                assertEquals(4, withdrawals.size());
                assertEquals("cancelled", withdrawals.get(0).getStatus());
                assertEquals("57aa3556bc727e4b519f25de", withdrawals.get(3).getId());
            }
        });
    }

    /* GET /enterprise/deposits/:id */
    @Test
    public void testGetEnterpriseDeposit() throws Exception {
        client.ENTERPRISE.getDepositAsEnterprise("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                Deposit deposit = (Deposit) result;
                assertEquals("executed", deposit.getStatus());
                assertEquals("DEPOSIT", deposit.getDescription());
            }
        });
    }

    /* GET /enterprise/deposits */
    @Test
    public void testGetEnterpriseDeposits() throws Exception {
        client.ENTERPRISE.getDepositsAsEnterprise(new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                List<Deposit> deposits = (List<Deposit>) result;
                assertEquals(2, deposits.size());
                assertEquals("executed", deposits.get(0).getStatus());
            }
        });
    }

}
