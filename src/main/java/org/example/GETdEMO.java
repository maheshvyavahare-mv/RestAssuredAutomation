package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GETdEMO {

    @BeforeSuite
    void setUp() {
        RestAssured.baseURI = "http://localhost:5000/sys/Inventory/gets";
    }

    @Test
    void testResponseTime() {
        Response response = given()
                .when()
                .get();

        long responseTime = response.time();
        System.out.println("Response Time: " + responseTime + " ms");

        assertTrue(responseTime < 200, "Response time is within an acceptable range");
    }

    @Test
    void testStatusCode() {
        Response response = given()
                .when()
                .get();

        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);

        assertEquals(statusCode, 200 , "Status code is as expected");
    }

    @Test
    void testContentType() {
        Response response = given()
                .when()
                .get();

        String contentType = response.getContentType();
        System.out.println("Content Type: " + contentType);

        assertTrue(contentType.contains("application/json"), "Content type is JSON");
    }


    @AfterSuite
    void tearDown() {
        System.out.println("TearDown");
    }
}
