package com.boniara.carinawebtestsexample.onliner.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ReviewsPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='ppdescr']")
    private ExtendedWebElement phoneDescriptionFromReviewLink;

    public ReviewsPage(WebDriver driver) {
        super(driver);
    }

    public String getPhoneDescription() {
        phoneDescriptionFromReviewLink.assertElementPresent(10);
        return phoneDescriptionFromReviewLink.getText();
    }
}
