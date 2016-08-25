package com.boniara.carinawebtestsexample.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PhonePage extends AbstractPage {

    @FindBy(xpath = "//div[@class='b-offers-desc__info-specs']/p[1]")
    private ExtendedWebElement phoneDescription;

    @FindBy(xpath = "//a[@href='http://catalog.onliner.by/mobile/xiaomi/note3pro16gr/reviews'" +
            " and @class='b-offers-desc__reviews']")
    private ExtendedWebElement reviewLink;

    public PhonePage(WebDriver driver) {
        super(driver);
    }

    public String getPhoneDescription() {
        phoneDescription.assertElementPresent(10);
        return phoneDescription.getText();
    }

    public ReviewsPage reviewsPageClick() {
        click(reviewLink);
        return new ReviewsPage(driver);
    }
}
