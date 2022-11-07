import org.junit.jupiter.api.Test;

public class Example {

    @Test
    public void testAuthorization(){

        PostRequest post = new PostRequest();
        GetRequest get = new GetRequest();

        String token = post.token();
        get.app_update_availability(token);
        get.config(token);
        get.main(token);
        post.requestToken(token);
        String authorizedUserToken = post.authorization(token);
        get.profile(authorizedUserToken);

    }

}