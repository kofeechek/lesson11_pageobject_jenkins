package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;


public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

//    @BeforeAll
//    static void setupSelenideEnv() {
//        Configuration.browser = "chrome";
//        Configuration.browserSize = "1920x1080";
//        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.timeout = 10000; // default 4000
//    }

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "128.0";
//        Configuration.browserVersion = "130.0";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }



    @AfterEach
    void closeWebDriver() {
        Selenide.closeWebDriver();
    }
}