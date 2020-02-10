package tests;

import com.google.pageobjects.HomePage;
import io.qameta.allure.Story;
import listeners.AllureScreenshotListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import stepdefinitions.HomePageSteps;

import static com.google.assertions.HomePageAssert.assertThat;

@Listeners(AllureScreenshotListener.class)
public class HomepageViewTest extends BaseTest {

    @Story("Home Page")
    @Test
    public void hasOpenedPage() {
        HomePage homePage = new HomePageSteps().openHomepage();
        assertThat(homePage)
                .hasAllElementsDisplayed();
    }

    @Story("Home Page")
    @Test
    public void hasKeyboardDisplayed() {
        HomePageSteps homePageSteps = new HomePageSteps();
        HomePage homePage = homePageSteps.openHomepage();
        homePageSteps.clickOnKeyboardButton();
        assertThat(homePage)
                .hasKeyboardDisplayed();
    }
}
