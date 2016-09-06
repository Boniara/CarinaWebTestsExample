package com.boniara.carinawebtestsexample.onliner.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CheckboxBlock extends AbstractUIObject {

    @FindBy(xpath = ".//div[@class='schema-filter__label']/span")
    private ExtendedWebElement blockTitle;

    @FindBy(xpath = ".//span[@class='i-checkbox']")
    private List<ExtendedWebElement> checkBoxList;

    @FindBy(xpath = ".//span[@class='schema-filter__checkbox-text']")
    private List<ExtendedWebElement> titleList;

    public CheckboxBlock(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    private ExtendedWebElement getCheckboxByTitle(String title) {
        ExtendedWebElement currentTitle = null;
        ExtendedWebElement currentCheckbox = null;
        for(int index = 0; index < titleList.size(); index++) {
            currentTitle = titleList.get(index);
            currentCheckbox = currentTitle.getText().equals(title)
                    ? checkBoxList.get(index) : null;
            if(currentCheckbox != null) {
                return currentTitle;
            }
        }
        return currentTitle;
    }

    public void check(String title) {
        getCheckboxByTitle(title).check();
    }

    public void check(Integer title) {
        getCheckboxByTitle(title.toString()).check();
    }

    public String getTitleText() {
        return blockTitle.getText();
    }

    public ExtendedWebElement getTitle() {
        return blockTitle;
    }
}
