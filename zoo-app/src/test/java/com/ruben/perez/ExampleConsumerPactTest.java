package com.ruben.perez;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRule;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.http.HttpMethod;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by ruben.perez on 23/3/16.
 */
public class ExampleConsumerPactTest /*extends ConsumerPactTest*/ {

  private static final String URL = "http://localhost:8089";

  @Rule
  public PactProviderRule mockProvider = new PactProviderRule("Animal Service", "localhost", 8089, this);

  @Pact(provider="Animal Service", consumer="Zoo App")
  public PactFragment createFragment(PactDslWithProvider pactDslWithProvider) {
    Map<String, String> headers = new HashMap<String, String>();
    headers.put("Content-Type", "application/json;charset=UTF-8");

    return pactDslWithProvider
        .given("")
        .uponReceiving("")
          .path("/alligator")
          .method(String.valueOf(HttpMethod.GET))
          .headers(headers)
          .body("")
        .willRespondWith()
        .status(200)
          .headers(headers)
        .body("{\"name\": \"My alligator\"}").toFragment();
  }

  @Test
  @PactVerification("Animal Service")
  public void runTest() throws URISyntaxException {
    Alligator myExpectedAlligator = new Alligator("My alligator");
    assertEquals(myExpectedAlligator, new AnimalServiceClient(URL + "/alligator").getAlligator());
  }

}
