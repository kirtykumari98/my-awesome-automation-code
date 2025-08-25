package com.automation.project.rest_assured_tests.authentication;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AuthenticationTest {

    @Test
    public void verifyAuthenticated() {
        Response response = given()
                .baseUri("https://api.twitter.com/2/tweets/search")
                .auth()
                .oauth2("AAAAAAAAAAAAAAAAAAAAAPNzbgEAAAAAzlc93HiUfNThc1VhfIO2deyzOO8%3DG8Z6jAUJTPKp17zGsFUz1af0VCpbKaqaCGE4GMouZSXMrS0Mkd")
                .when()
                .get("recent?query=climatechange");

        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void verifyAuthenticationBasic() {
        Response response = given()
                .baseUri("https://postman-echo.com/basic-auth")
                .auth()
                .basic("postman","password")
                .when()
                .get();
        response.prettyPrint();
        response.then().statusCode(200);

    }
    @Test
    public void verifyAuthenticationDigest() {
        Response response = given()
                .baseUri("https://postman-echo.com/basic-auth")
                .auth()
                .digest("postman","password")
                .when()
                .get();
        response.prettyPrint();
        response.then().statusCode(200);

    }

    @Test
    public void verifyBasicAuthenticationPreemptive() {
        Response response = given()
                .baseUri("https://postman-echo.com/basic-auth")
                .auth()
                .preemptive()
                .basic("postman", "password")
                .get();
        response.prettyPrint();
        response.then().body("authenticated", equalTo(true));
        response.then().statusCode(200);

    }

}


