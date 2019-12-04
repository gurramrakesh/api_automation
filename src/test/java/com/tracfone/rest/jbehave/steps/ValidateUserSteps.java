package com.tracfone.rest.jbehave.steps;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.io.IOException;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.Assert.assertTrue;

public class ValidateUserSteps {

    private String api;
    private String nonExistentUser;
    private int githubResponseCode;

    @Given("github user profile api")
    public void givenGithubUserProfileApi() {
        api = "https://api.github.com/users/%s";
    }

    @When("I look for $user via the api")
    public void whenILookForSomeNonExistentUserViaTheApi(String user) throws IOException {
        githubResponseCode = getGithubUserProfile(api, user)
          .getStatusLine()
          .getStatusCode();
    }

    static HttpResponse getGithubUserProfile(String api, String username) throws IOException {
        HttpUriRequest request = new HttpGet(String.format(api, username));
        return HttpClientBuilder
          .create()
          .build()
          .execute(request);
    }

    @Then("github respond: 404 not found")
    public void thenGithubRespond404NotFound() {
        assertTrue(SC_NOT_FOUND == githubResponseCode);
    }
    @Then("github respond: 200")
    public void thenGithubRespond200Success() {
        assertTrue(SC_OK == githubResponseCode);
    }
}
