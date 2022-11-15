package burgersTests;

import burgers.pages.ForgotPasswordPage;
import burgers.pages.HomePage;
import burgers.pages.LoginPage;
import burgers.pages.RegistrationPage;
import burgers.testData.GenerateUserData;
import burgers.testData.User;
import org.junit.Assert;
import org.junit.Test;

public class LoginUserTest extends BaseTest {

    public LoginUserTest() {
        this.isRegistration = false;
    }

    @Test
    public void loginTest() {
        HomePage homePage = new HomePage(driver);
        RegistrationPage registrationPage = homePage.clickSignIn().clickRegistration();

        User user = new User("Alex", GenerateUserData.getRandomEmail(), "123456");
        this.user = user;
        LoginPage loginPage = registrationPage.registrationUser(user.name, user.email, user.password);
        Assert.assertTrue(loginPage.getInputButton().isDisplayed());
        loginPage.setEmail(user.email);
        Assert.assertEquals(user.email, loginPage.getEmail().getAttribute("value"));
        loginPage.setPassword(user.password);
        Assert.assertEquals(user.password, loginPage.getPassword().getAttribute("value"));

        homePage = loginPage.clickInputButton();
        Assert.assertTrue(homePage.getCreateOrderButton().isDisplayed());
    }

    @Test
    public void loginWithForgotPasswordPageTest() {
        HomePage homePage = new HomePage(driver);
        RegistrationPage registrationPage = homePage.clickSignIn().clickRegistration();

        User user = new User("Alex", GenerateUserData.getRandomEmail(), "123456");
        this.user = user;
        LoginPage loginPage = registrationPage.registrationUser(user.name, user.email, user.password);
        Assert.assertTrue(loginPage.getInputButton().isDisplayed());

        ForgotPasswordPage forgotPasswordPage = loginPage.clickPasswordRecoveryButton();
        loginPage = forgotPasswordPage.clickLoginButton();
        homePage = loginPage.loginUser(user.email, user.password);
        Assert.assertTrue(homePage.getCreateOrderButton().isDisplayed());

    }

    @Test
    public void loginWithAreaPageTest() {
        HomePage homePage = new HomePage(driver);
        RegistrationPage registrationPage = homePage.clickSignIn().clickRegistration();

        User user = new User("Alex", GenerateUserData.getRandomEmail(), "123456");
        this.user = user;
        LoginPage loginPage = registrationPage.registrationUser(user.name, user.email, user.password);
        Assert.assertTrue(loginPage.getInputButton().isDisplayed());

        loginPage = loginPage.headerContainer.clickPersonalAreaButtonNotAuth();
        homePage = loginPage.loginUser(user.email, user.password);
        Assert.assertTrue(homePage.getCreateOrderButton().isDisplayed());
    }
}
