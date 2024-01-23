package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import pages.LandingAvianca;
import pages.SelectorFlight;
import utils.BasePage;

import java.util.concurrent.TimeUnit;

public class PageTestAvianca extends BasePage {

    public PageTestAvianca() {
        super(driver);
        driver.manage().deleteAllCookies();
    }

    LandingAvianca landing = new LandingAvianca();
    SelectorFlight flight = new SelectorFlight();

    @Test()
    public void reserve() throws Exception {
        driver.get("https://www.avianca.com/es/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        landing.cookie();
        landing.countries();
        landing.dates();
        landing.cantPassengers();
        landing.searchButton();
    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(15000);
        driver.quit();
    }
}
