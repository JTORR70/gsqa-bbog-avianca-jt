package pages;

import utils.BasePage;

public class SelectorFlight extends BasePage {

    String price = "//span[@class='mat-button-wrapper']";
    public SelectorFlight(){
        super(driver);
    }

    public void bestPrice(){
        clickElement(price);
    }
}
