package com.reimaginebanking.api.nessieandroidsdk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.reimaginebanking.api.nessieandroidsdk.requestclients.NessieClient;

import org.junit.Before;
import org.junit.Rule;

import java.util.concurrent.Executor;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Superclass of endpoint tests which contains shared logic
 */
public class NessieTest {

    protected NessieClient client;

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089); // No-args constructor defaults to port 8080

    @Before
    public void setup() {
        Gson gson = new GsonBuilder()
            .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint("http://localhost:8089")
            .setConverter(new GsonConverter(gson))
            .setExecutors(new Executor() {
                @Override
                public void execute(Runnable command) {
                    command.run();
                }
            }, null)
            .build();

        client = NessieClient.getInstance("12345", restAdapter);
    }

}
