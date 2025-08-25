package com.automation.project.rest_assured_tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;


public class GetRequestTest extends BaseTest {
    Logger logger= LogManager.getLogger(GetRequestTest.class);

    @Test(dataProvider = "get endpoints")
    public void fetchProgramRelatedInformation(String resourcePath)
    {
        RestAssured.baseURI= baseUri;
        RequestSpecification multipleRequests= RestAssured.given();
        Response response=multipleRequests.request(Method.GET,resourcePath);
//        response.prettyPrint();
        logger.info("the response is :"+response.asPrettyString());
        assertThat(response.getContentType(),Matchers.equalTo(ContentType.JSON.toString()));
    }

    @DataProvider(name = "get endpoints")
    public Object[][] getEndpoints() {
        return new Object[][]{{"programs"},
                {"programs/1"},
                {"programs/search"}};
    }

    @Test
    public void nonExistentProgramDetails() {
        RestAssured.baseURI = baseUri;
        Response response = RestAssured.given().request(Method.GET, "programs/10");
        response.then().statusCode(200);
    }

    @Test
    public void verifyFetchExistingProgramDetails() {
        RestAssured.baseURI = baseUri;
        Response response = RestAssured.given()
                .when().get("programs/1");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Parameters({"programName"})
    @Test
    public void verifyProgramNameInProgramDetails(@Optional(value = "Pre-Education Program") String programName) {
        RestAssured.baseURI = baseUri;
        Response response = RestAssured.given().request(Method.GET, "programs/1");
        response.then().statusCode(200);
        response.then().body("name", Matchers.equalTo(programName));
        response.prettyPrint();
    }
}
