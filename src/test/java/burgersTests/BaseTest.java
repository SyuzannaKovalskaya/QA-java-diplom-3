package burgersTests;

import burgers.api.dto.DtoUser;
import burgers.api.requests.UserRequest;
import burgers.pages.HomePage;
import burgers.pages.LoginPage;
import burgers.pages.RegistrationPage;
import burgers.testData.GenerateUserData;
import burgers.testData.User;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class BaseTest {
    public User user;
    public WebDriver driver;
    public boolean isRegistration = true;
    String url = "https://stellarburgers.nomoreparties.site";


    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
        this.driver.get(url);
        if (isRegistration) {
            registration();
        }
    }

    @After
    public void after() {
        driver.quit();
        if (null != user) {
            RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
            DtoUser dtoUser = new DtoUser(user.email, user.password);
            UserRequest.deleteUser(UserRequest.loginUser(dtoUser));
        }
    }

    private void registration() {
        User user = new User("Alex", GenerateUserData.getRandomEmail(), "123456");
        this.user = user;
        HomePage homePage = new HomePage(driver);
        RegistrationPage registrationPage = homePage.clickSignIn().clickRegistration();

        LoginPage loginPage = registrationPage.registrationUser(user.name, user.email, user.password);
        Assert.assertTrue(loginPage.getInputButton().isDisplayed());

        homePage = loginPage.loginUser(user.email, user.password);
        Assert.assertTrue(homePage.getCreateOrderButton().isDisplayed());
    }
}
