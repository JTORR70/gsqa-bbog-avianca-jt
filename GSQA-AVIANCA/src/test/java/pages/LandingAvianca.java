package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;
import utils.ExcelData;


public class LandingAvianca extends BasePage {


    public LandingAvianca() {
        super(driver);
        WebDriver driver;
    }

    ExcelData readFile = new ExcelData();

    String cookies = "//button[@id='onetrust-accept-btn-handler']";
    String clickOrigin = "//span[@id='originStationSelected']";
    String writeOrigin = "//input[@id='']";
    String clickDestination = "//input[@placeholder='Hacia']";
    String clickSelDate = "//div[@aria-label='25-1-2024']//span[@class='custom-day_day'][normalize-space()='25']";
    String clickFinDate = "//div[@aria-label='29-2-2024']//span[@class='custom-day_day'][normalize-space()='29']";
    String passengers = "//div[@class='pax-control']";
    String clickPassengers = "//button[@aria-label='Pasajeros :1' and @aria-expanded='false']";
    String whoFly = "(//button[@aria-label='increase'])[1]";
    String confirmWhoFly = "//button[@class='button control_options_selector_action_button']";
    String srchButton = "//button[@class='ibe-search_action_button button btn-created' and @id='searchButton']";

    public void cookie() {
        clickElement(cookies);
    }
    public void countries() throws Exception {
        String filepath = "data/Data_Avianca.xlsx";
        String origen = readFile.excelData(filepath, 1,0);
        String destino = readFile.excelData(filepath, 1,1);
        clickElement(clickOrigin);
        writeElement(writeOrigin, origen);
        writeElement(clickDestination, destino);
    }

    public void dates()throws Exception{
        clickElement(clickSelDate);
        clickElement(clickFinDate);
    }

    public void cantPassengers() throws Exception {
        clickElement(passengers);
        clickElement(clickPassengers);
        for (int i = 1; i<4; i++){
            clickElement(whoFly);
        }
        clickElement(confirmWhoFly);
    }

    public void searchButton() throws Exception{
        clickElement(srchButton);

    }
}