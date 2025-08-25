package com.automation.project.rest_assured_tests;

import com.github.javafaker.Faker;
import com.automation.project.rest_assured.Speaker;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;


public class SerializationExample extends BaseTest {
    Faker faker = new Faker();

    @Test
    public void verifyPostUsingSerialization() {
        Speaker speaker = new Speaker();
        speaker.setSpeakerId(faker.number().randomDigit());
        speaker.setSpeakerEmail(faker.internet().emailAddress());
        speaker.setSpeakerName(faker.name().firstName());
        speaker.setSpeakerPicPath(faker.file().fileName());
        speaker.setSpeakerProfile("Trainer");
        speaker.setDisabledStatus(false);

        Response response = given()
                .baseUri(baseUri)
                .contentType(ContentType.JSON)
                .body(speaker)
                .when()
                .post("programs/speaker");

        response.prettyPrint();
        response.then().body("speakerEmail", Matchers.equalTo(speaker.getSpeakerEmail()));

        //deserialization
        Speaker speakerResponse= response.as(Speaker.class);

       assertThat(speakerResponse.getSpeakerEmail(),equalTo(speaker.getSpeakerEmail()));

        //Put response
        speaker.setSpeakerName(faker.name().firstName());
        Response putResponse = given().baseUri(baseUri)
                .body(speaker)
                .contentType(ContentType.JSON.toString())
                .when()
                .put("programs/speaker/"+speakerResponse.getSpeakerId());
        putResponse.prettyPrint();
    }


}
