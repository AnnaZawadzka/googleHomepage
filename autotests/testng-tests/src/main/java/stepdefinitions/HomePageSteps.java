package stepdefinitions;

import com.google.helpers.WaitHelper;
import com.google.pageobjects.HomePage;
import io.qameta.allure.Step;

import static com.google.helpers.WaitHelper.*;
import static com.google.tools.threadsafedriver.LocalDriverManager.getDriver;
import static com.google.tools.threadsafedriver.LocalDriverManager.getEnvironment;

public class HomePageSteps {
    HomePage homePage = new HomePage();

    @Step("Open homepage")
    public HomePage openHomepage() {
        getDriver().get(getEnvironment().getBaseUrl());
        return new HomePage();
    }

    @Step("Click on keyboard button")
    public void clickOnKeyboardButton() {
        homePage.clickOnKeyboardButton();
    }

    @Step("Type a search term")
    public void typeSearchTerm(String searchTerm){
        homePage.typeSearchTerm(searchTerm);
    }

    @Step("Confirm search term by Enter Key")
    public void pressEnterKey(){
        homePage.pressEnterKey();
        waitForPageToLoad();
    }
}
