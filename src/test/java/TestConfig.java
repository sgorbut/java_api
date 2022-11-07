import org.aeonbits.owner.Config;

@Config.Sources({"classpath:testing.properties"})
public interface TestConfig extends Config {
    @Key("baseUrl")
    String baseUrl();

    @Key("request_token")
    String request_token();

    @Key("oauth_token")
    String oauth_token();

    @Key("client_secret")
    String client_secret();

    @Key("app_update_availability")
    String app_update_availability();

    @Key("config")
    String config();

    @Key("main")
    String main();

    @Key("profile")
    String profile();

    @Key("phone_number")
    String phone_number();

    @Key("pin")
    String pin();
}