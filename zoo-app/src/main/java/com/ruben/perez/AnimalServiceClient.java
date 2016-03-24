package com.ruben.perez;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by ruben.perez on 23/3/16.
 */
public class AnimalServiceClient {

  private final String url;
  private final RestTemplate client;

  public AnimalServiceClient(String url) {
    this.url = url;
    this.client = new RestTemplate();
  }

  public Alligator getAlligator() throws URISyntaxException {

    MultiValueMap<String, String> headers = new HttpHeaders();
    headers.add("Content-Type", "application/json;charset=UTF-8");

    RequestEntity<Void> requestEntity = new RequestEntity<Void>(headers, HttpMethod.GET, new URI(url));

    return client.exchange(url, HttpMethod.GET, requestEntity, Alligator.class).getBody();
  }

}
