package com.automation.project.rest_assured_tests;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

public class PostRequestTest extends BaseTest {
    Faker faker= new Faker();
    @Test
    public void createNewSpeaker()
    {
        String requestBody= "{\n" +
                "  \"disabledStatus\": true,\n" +
                "  \"speakerEmail\": \"shur.do@epam.com\",\n" +
                "  \"speakerId\": 11,\n" +
                "  \"speakerName\": \"Sheela\",\n" +
                "  \"speakerPicPath\": \"NA\",\n" +
                "  \"speakerProfile\": \"Trainer\"\n" +
                "}";

        given()
                .baseUri(baseUri)
                .contentType(ContentType.JSON)
                .body(requestBody)
                        .when()
                                .post("programs/speaker")
                .prettyPrint();


      /*  given().baseUri(baseUri)
                .header("Content-Type","application/json")
                .body(requestBody)
                .request(Method.POST,"programs/speaker")
                .prettyPrint();*/
    }

    @Test(dataProvider = "add multiple speakers")
    public void addMultipleSpeakers(String speakerEmail, String speakerName, String speakerProfile) {
        String requestBody = "{\n" +
                "  \"disabledStatus\": true,\n" +
                "  \"speakerEmail\":\""  + speakerEmail + "\",\n" +
                "  \"speakerId\": 12,\n" +
                "  \"speakerName\": \"" + speakerName + "\",\n" +
                "  \"speakerPicPath\": \"NA\",\n" +
                "  \"speakerProfile\": \"" + speakerProfile + "\"\n" +
                "}";

        Header header= new Header("Content-Type",ContentType.JSON.toString());
        given().baseUri(baseUri)
                .body(requestBody)
                .header(header)
//                .accept(ContentType.XML)
                .request(Method.POST,"programs/speaker").then().statusCode(201);
//        response.prettyPrint();



    }

    @Test(dataProvider = "add multiple speakers using random data")
    public void addMultipleSpeakersRandom(String speakerEmail, String speakerName, String speakerProfile) {
        String requestBody = "{\n" +
                "  \"disabledStatus\": true,\n" +
                "  \"speakerEmail\":\"" + speakerEmail + "\",\n" +
                "  \"speakerId\": 12,\n" +
                "  \"speakerName\": \"" + speakerName + "\",\n" +
                "  \"speakerPicPath\": \"NA\",\n" +
                "  \"speakerProfile\": \"" + speakerProfile + "\"\n" +
                "}";

        Header header = new Header("Content-Type", ContentType.JSON.toString());
        Response response = given().baseUri(baseUri)
                .body(requestBody)
                .header(header)
                .request(Method.POST, "programs/speaker");
        response.prettyPrint();
        response.then().body("speakerEmail", Matchers.equalTo(speakerEmail));

    }

    @DataProvider(name = "add multiple speakers")
    public Object[][] getSpeakerDetails() {
        return new Object[][]
                {{"shardul.s@epam.com", "Shardul", "Trainer"},
                        {"Suresh.yarava@epam.com", "Suresh", "Trainee"},
                        {"Ishan.arora@epam.com", "Ishan", "Trainee"}
                };
    }
    @DataProvider(name = "add multiple speakers using random data")
    public Object[][] getSpeakerDetailsRandom() {
        return new Object[][]
                {{faker.internet().emailAddress(), faker.name().fullName(), "Trainer"},
                        {faker.internet().emailAddress(), faker.name().firstName().concat(" ").concat(faker.name().lastName()), "Trainee"},
                        {faker.internet().emailAddress(), faker.name().firstName().concat(" ").concat(faker.name().lastName()), "Trainee"}
                };
    }
}
