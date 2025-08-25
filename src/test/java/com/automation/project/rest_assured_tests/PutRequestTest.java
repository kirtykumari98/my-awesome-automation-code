package com.automation.project.rest_assured_tests;

import com.github.javafaker.Faker;
import com.automation.project.rest_assured.Speaker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PutRequestTest extends BaseTest{

    Speaker speaker= new Speaker();
    Faker faker = new Faker();
    @Test
    public void verifyUpdateSpeaker()
    {
        speaker.setSpeakerName(faker.name().fullName());
        Response response=given().baseUri(baseUri)
                .contentType(ContentType.JSON.toString())
                .body(speaker)
                .when()
                .put("programs/speaker/7");
        response.prettyPrint();
    }
}
