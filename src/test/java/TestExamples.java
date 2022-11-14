import org.junit.jupiter.api.Test;

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

    @Test
    public void testChangePrimaryAddress() {

        Requests request = new Requests();

        String token = request.token();
        request.app_update_availability(token);
        request.main(token);
        request.requestToken(token);
        String authorizedUserToken = request.authorization(token);
        int addressId = request.getDeliveryAddressId(authorizedUserToken);
        request.setPrimaryAddress(authorizedUserToken, addressId);
    }
}