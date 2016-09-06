package com.boniara.carinawebtestsexample.gui.gsmarena.pages;

import com.boniara.carinawebtestsexample.gui.gsmarena.components.home_page.BrandMenu;
import com.boniara.carinawebtestsexample.gui.gsmarena.components.home_page.FootMenu;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class, 'brandmenu')]")
    private BrandMenu brandMenu;

    @FindBy(id = "footmenu")
    private FootMenu footMenu;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("http://www.gsmarena.com");
    }

    public ProductsPage clickBrandByName(String brandName) {
        brandMenu.clickBrandByName(brandName);
        return new ProductsPage(driver);
    }

    public FootMenu getHomeMenu() {
        return footMenu;
    }
}
