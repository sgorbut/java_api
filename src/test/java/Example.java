import org.junit.jupiter.api.Test;

public class Example {

    @Test
    public void testAuthorization(){

        Requests post = new Requests();

        String token = post.token();
        post.app_update_availability(token);
        post.config(token);
        post.main(token);
        post.requestToken(token);
        String authorizedUserToken = post.authorization(token);
        post.profile(authorizedUserToken);

    }

}