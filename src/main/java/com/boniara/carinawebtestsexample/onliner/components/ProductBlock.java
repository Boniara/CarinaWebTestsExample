package com.boniara.carinawebtestsexample.onliner.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductBlock extends AbstractUIObject {

    @FindBy(xpath = ".//a[contains(@class,'product__title')]")
    private ExtendedWebElement title;

    public ProductBlock(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getTitleText() {
        return title.getText();
    }
}
