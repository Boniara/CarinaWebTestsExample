package com.boniara.carinawebtestsexample.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CatalogPage extends AbstractPage {

    @FindBy(xpath = "//a[@href='http://catalog.onliner.by/mobile' and" +
            " contains(@class, 'catalog-bar')]")
    private ExtendedWebElement mobilesPath;

    public CatalogPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("http://catalog.onliner.by");
    }

    public MobileCatalogPage mobileCatalogClick() {
        click(mobilesPath);
        return new MobileCatalogPage(driver);
    }
}
