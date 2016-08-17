package com.reimaginebanking.api.nessieandroidsdk;

import com.reimaginebanking.api.nessieandroidsdk.constants.AccountType;
import com.reimaginebanking.api.nessieandroidsdk.models.Account;
import com.reimaginebanking.api.nessieandroidsdk.models.PostResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.PutDeleteResponse;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests all account endpoints against mock responses.
 */
public class AccountTest extends NessieTest {

    /* GET /accounts */
    @Test
    public void testGetAccounts() throws Exception {
        client.ACCOUNT.getAccounts(new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                List<Account> accounts = (List<Account>) result;
                assertEquals(accounts.size(), 5);
                assertEquals(AccountType.CHECKING, accounts.get(0).getType());
                assertEquals(38998, accounts.get(0).getBalance(), 0);
            }
        });
    }

    @Test
    public void testGetAccountsByType() throws Exception {
        client.ACCOUNT.getAccounts(AccountType.CHECKING, new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                List<Account> accounts = (List<Account>) result;
                assertEquals(accounts.size(), 5);
                assertEquals(AccountType.CHECKING, accounts.get(0).getType());
                assertEquals(38998, accounts.get(0).getBalance(), 0);
            }
        });
    }

    /* GET /account/{id} */
    @Test
    public void testGetAccount() throws Exception {
        client.ACCOUNT.getAccount("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                Account account = (Account) result;
                assertEquals(32698, account.getRewards(), 0);
                assertEquals(AccountType.CHECKING, account.getType());
            }
        });
    }

    /* GET /customer/{id}/accounts */
    @Test
    public void testGetAccountsByCustomer() throws Exception {

        client.ACCOUNT.getCustomerAccounts("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                List<Account> accounts = (List<Account>) result;
                assertEquals(1, accounts.size(), 0);
                assertEquals(AccountType.CHECKING, accounts.get(0).getType());
            }
        });



    }

    /* POST /customer/{id}/accounts */
    @Test
    public void testCreateAccount() throws Exception {
        Account account = new Account.Builder()
            .balance(10)
            .nickname("TEST")
            .type(AccountType.CREDITCARD)
            .rewards(10)
            .accountNumber("1234567890123456")
            .build();

        client.ACCOUNT.createAccount("123", account, new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                PostResponse<Account> response = (PostResponse<Account>) result;
                Account newAccount = response.getObjectCreated();
                assertEquals(AccountType.CREDITCARD, newAccount.getType());
                assertEquals(10, newAccount.getRewards(), 0);
            }
        });
    }

    /* PUT /accounts/{id} */
    @Test
    public void testUpdateAccount() throws Exception {
        Account account = new Account.Builder()
            .nickname("TEST")
            .build();

        client.ACCOUNT.updateAccount("123", account, new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                PutDeleteResponse response = (PutDeleteResponse) result;
                assertEquals(202, response.getCode());
                assertEquals("Accepted account update", response.getMessage());
            }
        });
    }


    /* DELETE /accounts/{id} */
    @Test
    public void testDeleteAccountSuccess() throws Exception {
        client.ACCOUNT.deleteAccount("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                PutDeleteResponse response = (PutDeleteResponse) result;
                assertEquals(204, response.getCode());
            }
        });
    }

    @Test
    public void testDeleteAccountFailure() throws Exception {
        client.ACCOUNT.deleteAccount("54321", new NessieTestResultsListener() {
            @Override
            public void onFailure(NessieError error) {
                // TODO: need to update this once the NessieError object is updated
                assertTrue(true);
            }
        });
    }

}
