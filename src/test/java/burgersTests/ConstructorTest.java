package burgersTests;

import burgers.pages.HomePage;
import org.junit.Test;

public class ConstructorTest extends BaseTest {

    public ConstructorTest() {
        this.isRegistration = false;
    }

    @Test
    public void transitionsToSectionsTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.constructorContainer.clickToppings();
        homePage.constructorContainer.clickSauce();
        homePage.constructorContainer.clickBuns();
//        Thread.sleep(3000);
//        System.out.println(homePage.constructorContainer.getToppings().getCssValue("box-shadow"));
       // Assert.assertEquals("", homePage.constructorContainer.getToppings());
    }

}
// Assert.assertTrue(homePage.constructorContainer.getToppingsHeader();



