import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pom.MainPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.*;

import java.time.Duration;

//каждый элемент списка ответов содержит конкретный текст

@RunWith(Parameterized.class)
public class CheckFAQAnswersTest {
    private WebDriver driver;
    private MainPage mainPage;

    private final String n;
    private final String exceptedAnswer;
    public CheckFAQAnswersTest(String n, String exceptedAnswer) {
        this.n = n;
        this.exceptedAnswer = exceptedAnswer;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                { "0", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                { "1", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                { "2", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                { "3", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                { "4", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                { "5", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                { "6", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                { "7", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        mainPage.open();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void FAQAnswersIsCorrect() {
        mainPage.clickCookieButton();
        mainPage.scrollToFAQBlock();
        int a = Integer.parseInt(n);
        mainPage.clickFAQQuestionN(a);
        String actualText = mainPage.getTextFAQAnswerN(a);
        Assert.assertEquals("Текст в блоке " + n + " FAQ не соответствует ожидаемому", exceptedAnswer, actualText);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}




