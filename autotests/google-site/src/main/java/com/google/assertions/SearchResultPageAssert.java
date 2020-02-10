package com.google.assertions;

import com.google.pageobjects.SearchResultsPage;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.SoftAssertions;

public class SearchResultPageAssert extends AbstractAssert<SearchResultPageAssert, SearchResultsPage> {

    public SearchResultPageAssert(SearchResultsPage actual) {
        super(actual, SearchResultPageAssert.class);
    }

    public static SearchResultPageAssert assertThat(SearchResultsPage actual) {
        return new SearchResultPageAssert(actual);
    }

    public SearchResultPageAssert hasSearchPageLoaded() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(actual.isLogoVisible())
                .describedAs("Google logo is displayed properly")
                .isTrue();
        softly.assertThat(actual.isTabPanelDisplayed())
                .describedAs("Tab panel is displayed")
                .isTrue();
        softly.assertAll();
        return this;
    }

    public SearchResultPageAssert allHeadersContainsText() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(actual.getResultsHeaderListSize())
                .describedAs("Google logo is displayed properly")
                .isNotZero()
                .isNotNull();
        softly.assertAll();
        return this;
    }

    public SearchResultPageAssert allSearchResultsMatchesToSearchTerm(String searchTerm) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(actual.checkIfResultsContainerMatchToSearchTerm(searchTerm))
                .describedAs("Search result container contain searchTerm in link, header or description")
                .doesNotContain(false);
        softly.assertAll();
        return this;
    }
}
