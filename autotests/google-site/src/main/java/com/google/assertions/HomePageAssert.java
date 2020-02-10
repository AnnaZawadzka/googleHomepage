package com.google.assertions;

import com.google.pageobjects.HomePage;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.SoftAssertions;

public class HomePageAssert extends AbstractAssert<HomePageAssert, HomePage> {

    public HomePageAssert(HomePage actual) {
        super(actual, HomePageAssert.class);
    }

    public static HomePageAssert assertThat(HomePage actual) {
        return new HomePageAssert(actual);
    }

    public HomePageAssert hasAllElementsDisplayed() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(actual.isLogoVisible())
                .describedAs("Google logo is displayed properly")
                .isTrue();
        softly.assertThat(actual.isLoginButtonIsVisible())
                .describedAs("Logo button displayed")
                .isTrue();
        softly.assertThat(actual.isSearchInputIsVisible())
                .describedAs("Search input displayed")
                .isTrue();
        softly.assertThat(actual.isKeyboardSearchButtonIsVisible())
                .describedAs("Keyboard search button displayed")
                .isTrue();
        softly.assertThat(actual.isVoiceSearchButtonIsVisible())
                .describedAs("Voice search button displayed")
                .isTrue();
        softly.assertThat(actual.isSearchButtonIsVisible())
                .describedAs("search button displayed")
                .isTrue();
        softly.assertThat(actual.isLuckyShotButtonIsVisible())
                .describedAs("Lucky shot button displayed")
                .isTrue();
        softly.assertAll();
        return this;
    }

    public HomePageAssert hasKeyboardDisplayed() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(actual.isKeyboardVisible())
                .describedAs("Keyboard is displayed properly")
                .isTrue();
        softly.assertAll();
        return this;
    }

    public HomePageAssert allSearchResultsStartsWithSearchTerm(String searchTerm){
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(actual.getSearchHintsText())
                .describedAs("All Search Hints starts with search term")
                .contains(searchTerm.toLowerCase());
        softly.assertAll();
        return this;
    }
}
