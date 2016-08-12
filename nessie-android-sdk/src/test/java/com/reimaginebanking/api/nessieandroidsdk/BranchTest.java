package com.reimaginebanking.api.nessieandroidsdk;

import com.reimaginebanking.api.nessieandroidsdk.models.Branch;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests all branch endpoints against mock responses.
 */
public class BranchTest extends NessieTest {

    /* GET /branches */
    @Test
    public void testGetBranches() throws Exception {
        client.BRANCH.getBranches(new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                List<Branch> branches = (List<Branch>) result;
                assertEquals(3, branches.size());
                assertEquals("ARLINGTON", branches.get(0).getName());
            }
        });
    }

    /* GET /branches/{id} */
    @Test
    public void testGetBranch() throws Exception {
        client.BRANCH.getBranch("123", new NessieTestResultsListener() {
            @Override
            public void onSuccess(Object result) {
                Branch branch = (Branch) result;
                assertEquals("ARLINGTON", branch.getName());
            }
        });
    }
}
