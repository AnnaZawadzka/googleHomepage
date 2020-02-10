package tests;

import com.google.assertions.SearchResultPageAssert;
import com.google.pageobjects.HomePage;
import com.google.pageobjects.SearchResultsPage;
import io.qameta.allure.Story;
import listeners.AllureScreenshotListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import stepdefinitions.HomePageSteps;

import static com.google.assertions.HomePageAssert.*;
import static com.google.helpers.DataGenerator.generateRandomCapital;

@Listeners(AllureScreenshotListener.class)
public class SearchTest extends BaseTest {
    private final static String SEARCH_TERM = generateRandomCapital();

    @Story("SearchOption")
    @Test
    public void simpleSearchTest() {
        HomePageSteps homePageSteps = new HomePageSteps();
        HomePage homePage = homePageSteps.openHomepage();
        homePageSteps.typeSearchTerm(SEARCH_TERM);
        assertThat(homePage)
                .allSearchResultsStartsWithSearchTerm(SEARCH_TERM);

        homePageSteps.pressEnterKey();
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        SearchResultPageAssert.assertThat(searchResultsPage)
                .hasSearchPageLoaded()
                .allHeadersContainsText()
                .allSearchResultsMatchesToSearchTerm(SEARCH_TERM);
    }
}
