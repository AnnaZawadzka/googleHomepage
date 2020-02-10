package com.google.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.google.helpers.WaitHelper.waitForPageToLoad;
import static com.google.helpers.WebElementsHelper.checkIfStringContainsSubstring;
import static org.openqa.selenium.By.xpath;
import static sun.plugin.dom.html.HTMLConstants.ATTR_HREF;

public class SearchResultsPage extends AbstractBasePage {
    @FindBy(id = "logo")
    private WebElement logoImg;

    @FindBy(id = "hdtb-msb")
    private WebElement tabPanel;

    @FindBy(xpath = "//div[@class='rc']")
    private List<WebElement> resultContainerList;

    @FindBy(css = ".g h3")
    private List<WebElement> resultHeadersList;

    private static final By RESULT_LINK = xpath(".//a[@ping]");
    private static final By HEADER = xpath(".//h3");
    private static final By DESCRIPTION = xpath(".//*[@class='st']");

    public boolean isLogoVisible() {
        return logoImg.isDisplayed();
    }

    public boolean isTabPanelDisplayed() {
        return tabPanel.isDisplayed();
    }

    public int getResultsHeaderListSize() {
        return resultHeadersList.size();
    }

    public List<Boolean> checkIfResultsContainerMatchToSearchTerm(String searchTerm) {
        waitForPageToLoad();
        List<Boolean> checkedContainersList = new ArrayList<>();
        for (WebElement resultRow : resultContainerList) {
            boolean foundSearchTerm = checkIfStringContainsSubstring(resultRow.findElement(RESULT_LINK)
                    .getAttribute(ATTR_HREF), searchTerm) ||
                    checkIfStringContainsSubstring(resultRow.findElement(HEADER).getText(), searchTerm) ||
                    checkIfStringContainsSubstring(resultRow.findElement(DESCRIPTION).getText(), searchTerm);
            checkedContainersList.add(foundSearchTerm);
        }
        return checkedContainersList;
    }
}
