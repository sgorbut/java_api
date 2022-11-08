package models;

import java.util.HashMap;
import java.util.Map;

public class Headers {

    public Map unauthorizedHeaders(){

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

        return headersData;

    }

    public Map authorizedHeaders(String token){

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

        return headersData;

    }

}