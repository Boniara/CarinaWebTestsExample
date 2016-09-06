package com.boniara.carinawebtestsexample.onliner.components;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class ChecksBlock extends AbstractUIObject {

    @FindBy(xpath = ".//div[@class='schema-filter__fieldset']")
    private List<CheckboxBlock> checkboxBlocks;

    public ChecksBlock(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CheckboxBlock getCheckboxblock(String title) {
        for(CheckboxBlock block: checkboxBlocks) {
            assertElementPresent(block.getTitle());
            if(block.getTitleText().toLowerCase().contains(title.toLowerCase())) {
                return block;
            }
        }
        return null;
    }
}
