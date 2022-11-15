package burgersTests;

import burgers.pages.HomePage;
import burgers.pages.LoginPage;
import burgers.pages.RegistrationPage;
import burgers.testData.GenerateUserData;
import burgers.testData.User;
import org.junit.Assert;
import org.junit.Test;


public class RegistrationTest extends BaseTest {

    public RegistrationTest() {
        this.isRegistration = false;
    }

    @Test
    public void registrationTest() {
        HomePage homePage = new HomePage(driver);
        RegistrationPage registrationPage = homePage.clickSignIn().clickRegistration();

        User user = new User("Alex", GenerateUserData.getRandomEmail(), "123456");
        registrationPage.setNameInput(user.name);
        registrationPage.setEmailInput(user.email);
        registrationPage.setPasswordInput(user.password);

        Assert.assertEquals(user.name, registrationPage.getNameInput().getAttribute("value"));
        Assert.assertEquals(user.email, registrationPage.getEmailInput().getAttribute("value"));
        Assert.assertEquals(user.password, registrationPage.getPasswordInput().getAttribute("value"));

        LoginPage loginPage = registrationPage.clickRegistrationButton();
        Assert.assertTrue(loginPage.getInputButton().isDisplayed());
        this.user = user;

    }

    @Test
    public void registrationWithNotCorrectPasswordTest() {
        HomePage homePage = new HomePage(driver);
        RegistrationPage registrationPage = homePage.clickSignIn().clickRegistration();

        User user = new User("Alex", GenerateUserData.getRandomEmail(), "12345");

        registrationPage.registrationUser(user.name, user.email, user.password);
        Assert.assertTrue(registrationPage.getErrorMessage().isDisplayed());
    }
}
