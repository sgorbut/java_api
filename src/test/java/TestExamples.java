import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class TestExamples {

    @Test
    public void testAuthorization(){

        Requests request = new Requests();

        String token = request.token();
        request.app_update_availability(token);
        request.config(token);
        request.main(token);
        request.requestToken(token);
        String authorizedUserToken = request.authorization(token);
        request.profile(authorizedUserToken);

    }

    @Test
    public void testChangeAddress(){

        Requests request = new Requests();

        String token = request.token();
        request.app_update_availability(token);
        request.config(token);
        request.main(token);
        request.requestToken(token);
        String authorizedUserToken = request.authorization(token);
        int addressId = request.getAddressId(authorizedUserToken);
        request.changeAddress(authorizedUserToken, addressId);

    }

    @Test
    public void testCheckCartIsEmpty(){

        Requests request = new Requests();

        String token = request.token();
        request.app_update_availability(token);
        request.config(token);
        request.main(token);
        request.requestToken(token);
        String authorizedUserToken = request.authorization(token);
        request.checkCartIsEmpty(authorizedUserToken);

    }

}