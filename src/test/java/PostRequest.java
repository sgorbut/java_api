import models.TokenResponse;
import org.aeonbits.owner.ConfigFactory;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;

public class PostRequest {

    public String token(){

        TestConfig config = ConfigFactory.create(TestConfig.class, System.getProperties());

        // Headers todo move to properties
        Map<String, String> headersData = new HashMap<>();
        headersData.put("Content-Type", "application/json");
        headersData.put("X-Data-Platform", "Android");
        headersData.put("X-Data-Model", "Android");
        headersData.put("X-Data-Version", "2.5.0");
        headersData.put("X-DATA-INSTALLATION-ID", "00000000-8888-6666-7777-000000000002");
        headersData.put("X-DATA-VENDOR", "Android");
        headersData.put("X-DATA-IDENTIFIER", "cf963131-a767-4113-b0a2-3d8f4df13f92");
        headersData.put("X-DATA-APPSFLYERID", "1593526559553-6753872941436942690");
        headersData.put("x-data-platform-version", "11");
        headersData.put("authorization", null);

        // Body via HashMap
        Map<String, String> bodyData = new HashMap<>();
        bodyData.put("grant_type", "client_credentials_luuid");
        bodyData.put("client_id", "8");
        bodyData.put("scope", "");
        bodyData.put("client_secret", "" + config.client_secret() + "");


        TokenResponse response =
                given()
                        .log().uri()
                        .contentType(JSON)
                        .headers(headersData)
                        .body(bodyData)
                        .when()
                        .post(config.baseUrl()+config.oauth_token())
                        .then()
                        .statusCode(200)
                        .extract().as(TokenResponse.class);

        return response.getAccess_token();

    }

    public void requestToken(String token){

        TestConfig config = ConfigFactory.create(TestConfig.class, System.getProperties());

        // Headers todo move to properties
        Map<String, String> headersData = new HashMap<>();
        headersData.put("Content-Type", "application/json");
        headersData.put("X-Data-Platform", "Android");
        headersData.put("X-Data-Model", "Android");
        headersData.put("X-Data-Version", "2.5.0");
        headersData.put("X-DATA-INSTALLATION-ID", "00000000-8888-6666-7777-000000000002");
        headersData.put("X-DATA-VENDOR", "Android");
        headersData.put("X-DATA-IDENTIFIER", "cf963131-a767-4113-b0a2-3d8f4df13f92");
        headersData.put("X-DATA-APPSFLYERID", "1593526559553-6753872941436942690");
        headersData.put("x-data-platform-version", "11");
        headersData.put("authorization", "Bearer " + token);

        // Body via HashMap
        Map<String, String> bodyData = new HashMap<>();
        bodyData.put("client_id", "8");
        bodyData.put("phone_number", "" + config.phone_number() + "");
        bodyData.put("response_type", "phone_code");
        bodyData.put("client_secret", "" + config.client_secret() + "");

        String response =
                given()
                        .log().uri()
                        .contentType(JSON)
                        .headers(headersData)
                        .body(bodyData)
                        .when()
                        .post(config.baseUrl()+config.request_token())
                        .then()
                        .statusCode(201)
                        .extract().as(String.class);

        assertThat(response.equals(""));

    }

    public String authorization(String token){

        TestConfig config = ConfigFactory.create(TestConfig.class, System.getProperties());

        // Headers todo move to properties
        Map<String, String> headersData = new HashMap<>();
        headersData.put("Content-Type", "application/json");
        headersData.put("X-Data-Platform", "Android");
        headersData.put("X-Data-Model", "Android");
        headersData.put("X-Data-Version", "2.5.0");
        headersData.put("X-DATA-INSTALLATION-ID", "00000000-8888-6666-7777-000000000002");
        headersData.put("X-DATA-VENDOR", "Android");
        headersData.put("X-DATA-IDENTIFIER", "cf963131-a767-4113-b0a2-3d8f4df13f92");
        headersData.put("X-DATA-APPSFLYERID", "1593526559553-6753872941436942690");
        headersData.put("x-data-platform-version", "11");
        headersData.put("authorization", "Bearer " + token);

        // Body via HashMap
        Map<String, String> bodyData = new HashMap<>();
        bodyData.put("phone_number", "" + config.phone_number() + "");
        bodyData.put("pin", "" + config.pin() + "");
        bodyData.put("old_access_token", "" + token + "");
        bodyData.put("grant_type", "phone_code");
        bodyData.put("client_id", "8");
        bodyData.put("scope", "");
        bodyData.put("client_secret", "" + config.client_secret() + "");


        TokenResponse response =
                given()
                        .log().uri()
                        .contentType(JSON)
                        .headers(headersData)
                        .body(bodyData)
                        .when()
                        .post(config.baseUrl()+config.oauth_token())
                        .then()
                        .statusCode(200)
                        .extract().as(TokenResponse.class);

        return response.getAccess_token();

    }

}