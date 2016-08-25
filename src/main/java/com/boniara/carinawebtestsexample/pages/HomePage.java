package com.boniara.carinawebtestsexample.pages;

import com.boniara.carinawebtestsexample.components.SearchIFrame;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//a[@href='http://catalog.onliner.by/']")
    private ExtendedWebElement catalogPath;

    @FindBy(xpath = "//input[@class='fast-search__input']")
    private ExtendedWebElement inputField;

    @FindBy(xpath = "//div[@title='Facebook']")
    private ExtendedWebElement facebookLogin;

    @FindBy(xpath = "//div[@class='b-top-actions']//img[@class='onliner_logo retina-off']")
    private ExtendedWebElement onlinerLogotype;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public synchronized SearchIFrame sendToInputField(String data) {
        click(inputField);
        type(inputField, data);
        inputField.getElement().submit();
        return new SearchIFrame(driver);
    }

    public LoginWithFacebookPage clickAndGetLoginFacebookWindow() {
        click(facebookLogin);
        return new LoginWithFacebookPage(driver);
    }

    public boolean isLogotypeDisplayed() {
        return isElementPresent(onlinerLogotype, 10);
    }

    public CatalogPage catalogClick() {
        click(catalogPath);
        return new CatalogPage(driver);
    }
}
