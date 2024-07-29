package org.prog.page;

import org.openqa.selenium.WebDriver;

import javax.annotation.PreDestroy;

public class AbstractPage {

    protected final WebDriver driver;
    private final String url;

    public AbstractPage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public void loadPage(){
        driver.get("about:blank");
        driver.get(url);
    }

    @PreDestroy
    public void tearDown() {
        if (this.driver != null) {
            driver.quit();
        }
    }
}
