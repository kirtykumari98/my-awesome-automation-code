package com.automation.project.rest_assured_tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class GetRequestTestExample {

    @Test
    public void verifySpeakerDetails()
    {
        RestAssured.baseURI="http://epinhydw0087:9090/";
        RequestSpecification speakerRequest = given();

        Response response= speakerRequest.when().get("programs/speaker/7");

        response.then().statusCode(200);
        response.prettyPrint();
        response.then().statusLine(Matchers.containsString("200"));
       assertEquals(response.getBody().jsonPath().get("speakerProfile"),"Trainer");
    }
}
