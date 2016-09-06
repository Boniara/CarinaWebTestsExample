package com.boniara.carinawebtestsexample.onliner.components;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;
import java.util.List;

public class SearchIFrame extends AbstractUIObject {

    private static final Logger LOG = Logger.getLogger(SearchIFrame.class);

    @FindBy(xpath = "//div[@class='result__wrapper']")
    private List<ProductBlock> productBlockList;

    public SearchIFrame(WebDriver driver) {
        super(driver);
        driver.switchTo().frame(driver.findElement(By.className("modal-iframe")));
    }

    public SoftAssert checkResultContains(String containsString) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(! productBlockList.isEmpty(), "Result list is empty");
        for(ProductBlock productBlock: productBlockList) {
            String title = productBlock.getTitleText();
            LOG.debug(title + "is checked");
            softAssert.assertTrue(title.contains(containsString), "Product blockTitle text don`t contains the product" +
                    " blockTitle text from reviews page. Expected value = " + title + " actual value = " + containsString);
        }
        return softAssert;
    }
}
