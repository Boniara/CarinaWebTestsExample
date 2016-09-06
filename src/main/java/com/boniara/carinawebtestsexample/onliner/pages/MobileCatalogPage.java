package com.boniara.carinawebtestsexample.onliner.pages;

import com.boniara.carinawebtestsexample.onliner.components.ChecksBlock;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MobileCatalogPage extends AbstractPage {

    @FindBy(xpath = "//div[@id='schema-filter']")
    public ChecksBlock checksBlock;

    @FindBy(xpath = "//div[@class='schema-product__group' and" +
            " descendant::span[@data-bind='text: product.reviews.count' and" +
            " contains(text(),//span[@data-bind='text: product.reviews.count']" +
            "/text()[not(.<//span[@data-bind='text: product.reviews.count']/text())])]]" +
            "//a[descendant::span[@data-bind='html: product.full_name']]")
    private ExtendedWebElement maxReviewPhone;

    public MobileCatalogPage(WebDriver driver) {
        super(driver);
        setPageURL("/mobile");
    }

    public PhonePage maxReviewsPageClick() {
        click(maxReviewPhone);
        return new PhonePage(driver);
    }
}
