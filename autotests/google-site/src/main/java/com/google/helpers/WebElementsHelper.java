package com.google.helpers;

import org.openqa.selenium.WebElement;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class WebElementsHelper {
    public static List<String> getWebElementsListTexts(List<WebElement> list) {
        return list.stream().map(WebElement::getText).collect(toList());
    }

    public static boolean checkIfStringContainsSubstring(String text, String subtext) {
        return text.matches(String.format("(.*)%s(.*)", subtext));
    }
}
