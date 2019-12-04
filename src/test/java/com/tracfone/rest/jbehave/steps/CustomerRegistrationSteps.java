package com.tracfone.rest.jbehave.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tracfone.rest.jbehave.dto.Customer;
import com.tracfone.rest.jbehave.dto.RegistrationResponse;
import com.tracfone.rest.jbehave.util.RetrieveUtil;
import cucumber.api.java.gl.E;
import cucumber.runtime.java.StepDefAnnotation;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.io.IOException;

import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.Assert.assertTrue;

public class CustomerRegistrationSteps {
    private String api;

    @Given("demoQA api")
    public void givenDemoQAApi() {
        api = "http://dummy.restapiexample.com/api/v1/create";
    }

    @When("I pass in json request via the api to register")
    public void postJsonRequest(){
        try {
            String request = buildRequest();
            Customer response = RetrieveUtil.retrieveResourceFromResponse(this.postData(api,request), Customer.class);
            System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private String buildRequest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Customer customer = Customer.builder()
                .age(10)
                .name("RESTAPI")
                .salary(1200.00)
                .build();

        return mapper.writeValueAsString(customer);
    }
    static HttpResponse postData(String api, String requestString) throws IOException {
        HttpUriRequest request = new HttpPost(String.format(api, requestString));
        HttpPost httpPost = new HttpPost(api);
        StringEntity entity = new StringEntity(requestString);
        httpPost.setEntity(entity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        return HttpClientBuilder
                .create()
                .build()
                .execute(httpPost);
    }
    @Then("api respond: 200")
    public void thenGithubRespond200Success() {
       // assertTrue(SC_OK == responseCode);
    }
}
