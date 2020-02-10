package com.google.pageobjects;

import static com.google.tools.threadsafedriver.LocalDriverManager.getDriver;
import static org.openqa.selenium.support.PageFactory.initElements;

public abstract class AbstractBasePage {
    public AbstractBasePage() {
        initElements(getDriver(), this);
    }
}
