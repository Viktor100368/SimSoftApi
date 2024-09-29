package org.helpers;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class Spec {
    static Properties properties = new Properties();
    static final String urlAdderss = HelpProperties.getProperty(properties, "url");

    public static RequestSpecification reqSpec() {
        return given()
                .contentType(ContentType.JSON)
                .baseUri(urlAdderss);
    }
}
