package org.prog.driver;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;

public class WedDriverFactory {

    @SneakyThrows
    public static WebDriver getDriver() {
        String driverType = System.getProperty("driver.type", "chrome");
        switch (driverType) {
            case "remote-ide":
                return new RemoteWebDriver(
                        new URL("http://localhost:4444/wd/hub"), remoteChrome());
            case "remote-mvn":
                return new RemoteWebDriver(
                        new URL("http://selenoid-selenoid-1:4444/wd/hub"), remoteChrome());
            case "chrome":
                return new ChromeDriver();
            case "edge":
                return new EdgeDriver();
            case "firefox":
                return new FirefoxDriver();
            default:
                throw new RuntimeException("No driver selected!");
        }
    }

    private static ChromeOptions remoteChrome() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("enableVideo", true);
            put("enableVNC", true);
        }});
        return chromeOptions;
    }
}
