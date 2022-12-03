import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.FirstOrderPage;
import pom.MainPage;
import pom.SecondOrderPage;

import java.time.Duration;

@RunWith(Parameterized.class)
public class CheckOrderUpButtonParameteriz {
    private WebDriver driver;
    private MainPage mainPage;
    private FirstOrderPage firstOrderPage;
    private SecondOrderPage secondOrderPage;

    private final String username;
    private final String usersurname;
    private final String usersadress;
    private final String userphone;
    private final String userdate;
    private final String usercomment;

    public CheckOrderUpButtonParameteriz(String username, String usersurname, String usersadress, String userphone, String userdate, String usercomment) {
        this.username = username;
        this.usersurname = usersurname;
        this.usersadress = usersadress;
        this.userphone = userphone;
        this.userdate = userdate;
        this.usercomment = usercomment;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                { "Иван", "Петров", "Москва, пл. Красная, д. 1, кв. 12", "89001234567", "01.01.2023", "Домофон"},
                { "Ян", "Ли", "Пермь", "+79001234567", "01.01.2030", "" },
        };
    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        firstOrderPage = new FirstOrderPage(driver);
        secondOrderPage = new SecondOrderPage(driver);
        mainPage.open();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test
    public void test(){
        mainPage.clickCookieButton();
        mainPage.clickTopOrderButton();
        firstOrderPage.completeForm1(username, usersurname, usersadress, userphone);
        secondOrderPage.completeForm2(userdate, usercomment);
        Assert.assertTrue("Заказ не создан", secondOrderPage.findStatusButton().isDisplayed());
    }

    @Test
    public void test2(){
        mainPage.clickCookieButton();
        mainPage.clickBottomOrderButton();
        firstOrderPage.completeForm1(username, usersurname, usersadress, userphone);
        secondOrderPage.completeForm2(userdate, usercomment);
        Assert.assertTrue("Заказ не создан", secondOrderPage.findStatusButton().isDisplayed());
    }

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}
