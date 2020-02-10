package com.google.pageobjects;

import com.google.constants.Timeouts;
import com.google.helpers.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.google.constants.Timeouts.*;
import static com.google.helpers.WaitHelper.*;
import static com.google.helpers.WaitHelper.waitForPageToLoad;
import static com.google.helpers.WebElementsHelper.getWebElementsListTexts;
import static org.openqa.selenium.Keys.ENTER;

public class HomePage extends AbstractBasePage {
    @FindBy(id = "hplogo")
    private WebElement logoImg;

    @FindBy(id = "gb_70")
    private WebElement loginButton;

    @FindBy(css = ".gLFyf.gsfi")
    private WebElement searchInput;

    @FindBy(className = "hOoLGe")
    private WebElement keyboardSearchBtn;

    @FindBy(id = "kbd")
    private WebElement keyboardPopup;

    @FindBy(className = "HPVvwb")
    private WebElement voiceSearchBtn;

    @FindBy(css = ".FPdoLc.tfB0Bf .gNO89b")
    private WebElement searchInGoogleBtn;

    @FindBy(css = ".FPdoLc.tfB0Bf .RNmpXc")
    private WebElement luckyShotBtn;

    @FindBy(className = "erkvQe")
    private WebElement searchHintsContainer;

    @FindBy(css = ".erkvQe .sbl1")
    private List<WebElement> searchHintsList;

    public boolean isLogoVisible() {
        return logoImg.isDisplayed();
    }

    public boolean isLoginButtonIsVisible() {
        return loginButton.isDisplayed();
    }

    public boolean isSearchInputIsVisible() {
        return searchInput.isDisplayed();
    }

    public boolean isKeyboardSearchButtonIsVisible() {
        return keyboardSearchBtn.isDisplayed();
    }

    public boolean isVoiceSearchButtonIsVisible() {
        return voiceSearchBtn.isDisplayed();
    }

    public boolean isSearchButtonIsVisible() {
        return searchInGoogleBtn.isDisplayed();
    }

    public boolean isLuckyShotButtonIsVisible() {
        return luckyShotBtn.isDisplayed();
    }

    public boolean isKeyboardVisible() {
        return keyboardPopup.isDisplayed();
    }

    public List<String> getSearchHintsText() {
        return getWebElementsListTexts(searchHintsList);
    }

    public void clickOnKeyboardButton() {
        keyboardSearchBtn.click();
        waitForPageToLoad();
    }

    public void typeSearchTerm(String searchTerm) {
        searchInput.sendKeys(searchTerm);
        waitForElementToBeVisible(searchHintsContainer, TIMEOUT_5_SECONDS);
    }

    public void pressEnterKey() {
        searchInput.sendKeys(ENTER);
    }
}
