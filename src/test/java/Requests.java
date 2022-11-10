import models.*;
import org.aeonbits.owner.ConfigFactory;
import org.assertj.core.api.AssertionsForClassTypes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;

public class Requests {

    Headers headers = new Headers();

    public String token(){

        TestConfig config = ConfigFactory.create(TestConfig.class, System.getProperties());

        // Body
        Map<String, String> bodyData = new HashMap<>();
        bodyData.put("grant_type", "client_credentials_luuid");
        bodyData.put("client_id", "8");
        bodyData.put("scope", "");
        bodyData.put("client_secret", "" + config.client_secret() + "");

        TokenResponse response =
                given()
                        .log().uri()
                        .contentType(JSON)
                        .headers(headers.unauthorizedHeaders())
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

        // Body
        Map<String, String> bodyData = new HashMap<>();
        bodyData.put("client_id", "8");
        bodyData.put("phone_number", "" + config.phone_number() + "");
        bodyData.put("response_type", "phone_code");
        bodyData.put("client_secret", "" + config.client_secret() + "");

        String response =
                given()
                        .log().uri()
                        .contentType(JSON)
                        .headers(headers.authorizedHeaders(token))
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

        // Body
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
                        .headers(headers.authorizedHeaders(token))
                        .body(bodyData)
                        .when()
                        .post(config.baseUrl()+config.oauth_token())
                        .then()
                        .statusCode(200)
                        .extract().as(TokenResponse.class);

        return response.getAccess_token();

    }

    public void app_update_availability(String token){

        TestConfig config = ConfigFactory.create(TestConfig.class, System.getProperties());

        given()
                .log().uri()
                .contentType(JSON)
                .headers(headers.authorizedHeaders(token))
                .when()
                .get(config.baseUrl()+config.app_update_availability())
                .then()
                .statusCode(200);
    }

    public void main(String token){
        TestConfig config = ConfigFactory.create(TestConfig.class, System.getProperties());

        given()
                .log().uri()
                .contentType(JSON)
                .headers(headers.authorizedHeaders(token))
                .when()
                .get(config.baseUrl()+config.main())
                .then()
                .statusCode(200);
    }

    public void config(String token){

        TestConfig config = ConfigFactory.create(TestConfig.class, System.getProperties());

        given()
                .log().uri()
                .contentType(JSON)
                .headers(headers.authorizedHeaders(token))
                .when()
                .get(config.baseUrl()+config.config())
                .then()
                .statusCode(200);
    }

    public void profile(String token){

        TestConfig config = ConfigFactory.create(TestConfig.class, System.getProperties());

        ProfileResponse response =
                given()
                        .log().uri()
                        .contentType(JSON)
                        .headers(headers.authorizedHeaders(token))
                        .when()
                        .get(config.baseUrl()+config.profile())
                        .then()
                        .statusCode(200)
                        .body("phone", is(config.phone_number()))
                        .extract().as(ProfileResponse.class);

        AssertionsForClassTypes.assertThat(response.getIsRegistered()).isTrue();
    //    AssertionsForClassTypes.assertThat(response.getPhone()).isEqualTo(config.phone_number());

    }

    public void checkCartIsEmpty(String token){

        TestConfig config = ConfigFactory.create(TestConfig.class, System.getProperties());

        CartResponse response =
                given()
                        .log().uri()
                        .contentType(JSON)
                        .headers(headers.authorizedHeaders(token))
                        .when()
                        .get(config.baseUrl()+config.cart() + "?updatingCart=true&cartType=regular")
                        .then()
                        .statusCode(200)
                        .extract().as(CartResponse.class);

        AssertionsForClassTypes.assertThat(response.getCart()).isNull(); // Не всегда null при пустой корзине

    }

}