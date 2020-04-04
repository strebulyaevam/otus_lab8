package lab8;

import config.Lab8Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;

import java.util.concurrent.TimeUnit;

@Configuration
@ComponentScan(basePackages = "lab8")
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class TestConfig {

    private static Logger Log = LogManager.getLogger(TestConfig.class);

    private enum Browser{chrome, firefox};

    @Autowired
    Lab8Config config;

    @Autowired
    WebDriver driver;

    @Bean
    public Lab8Config getConfig() {
        Lab8Config cfg = ConfigFactory.create(Lab8Config.class);
        return cfg;
    }

    @Bean
    public WebDriver getDriver() {
        Browser browser;
        try {
            browser = Browser.valueOf(config.browser().toLowerCase());
        } catch (IllegalArgumentException e) {
            Log.error("Unknown browser " + config.browser(), e);
            throw e;
        }

        WebDriver driver = null;
        if (browser == Browser.chrome) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser == Browser.firefox) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            Log.error("Unknown browser type " + browser.name());
        }

        driver.manage().timeouts().implicitlyWait(4L, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

/*    @PreDestroy
    public void closeDriver() {
        if (driver != null){
            Log.info("Quit from browser");
            driver.quit();
        }
    }*/
}
