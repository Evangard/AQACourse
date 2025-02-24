package config;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.Sources("classpath:config.properties")
public interface TestConfig extends Config{

    TestConfig CONFIG = ConfigFactory.create((TestConfig.class));

    @DefaultValue("chrome")
    String browser();

    boolean remote();

    @Key("selenium.server.url")
    String seleniumServerUrl();

    @Key("base.url")
    String baseUrl();
}
