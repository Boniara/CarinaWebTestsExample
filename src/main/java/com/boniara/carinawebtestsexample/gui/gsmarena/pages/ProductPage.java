package com.boniara.carinawebtestsexample.gui.gsmarena.pages;

import com.boniara.carinawebtestsexample.gui.gsmarena.components.product_page.ReviewHeader;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class, 'hreview')]")
    private ReviewHeader reviewHeader;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ReviewHeader getReviewHeader() {
        return reviewHeader;
    }
}
