import models.ProfileResponse;
import org.aeonbits.owner.ConfigFactory;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GetRequest {

    public void app_update_availability(String token){

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

        given()
                .log().uri()
                .contentType(JSON)
                .headers(headersData)
                .when()
                .get(config.baseUrl()+config.app_update_availability())
                .then()
                .statusCode(200);
    }

    public void main(String token){
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

        given()
                .log().uri()
                .contentType(JSON)
                .headers(headersData)
                .when()
                .get(config.baseUrl()+config.main())
                .then()
                .statusCode(200);
    }

    public void config(String token){

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

        given()
                .log().uri()
                .contentType(JSON)
                .headers(headersData)
                .when()
                .get(config.baseUrl()+config.config())
                .then()
                .statusCode(200);
    }

    public void profile(String token){

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

        ProfileResponse response =
        given()
                .log().uri()
                .contentType(JSON)
                .headers(headersData)
                .when()
                .get(config.baseUrl()+config.profile())
                .then()
                .statusCode(200)
                .extract().as(ProfileResponse.class);

        assertThat(response.getIsRegistered()).isTrue();
        assertThat(response.getPhone()).isEqualTo(config.phone_number());

    }

}