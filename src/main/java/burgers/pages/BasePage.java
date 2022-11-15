package burgers.pages;

import burgers.pages.containers.HeaderContainer;
import org.openqa.selenium.WebDriver;

public class BasePage {
    public WebDriver driver;
    public HeaderContainer headerContainer;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.headerContainer = new HeaderContainer(driver);
    }
}
