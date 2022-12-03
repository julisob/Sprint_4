import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pom.MainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

//каждый элемент списка ответов содержит конкретный текст
public class CheckQuestionsAccordion {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        mainPage.open();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void test0() {
        mainPage.clickCookieButton();
        mainPage.scrollToFAQBlock();
        mainPage.clickFAQQuestionN(0);
        String actualText = mainPage.getTextFAQAnswerN(0);
        String exceptedAnswer = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        Assert.assertEquals("Текст в блоке 0 FAQ не соответствует ожидаемому", exceptedAnswer, actualText);
    }

    @Test
    public void test1() {
        mainPage.clickCookieButton();
        mainPage.scrollToFAQBlock();
        mainPage.clickFAQQuestionN(1);
        String actualText = mainPage.getTextFAQAnswerN(1);
        String exceptedAnswer = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        Assert.assertEquals("Текст в блоке 1 FAQ не соответствует ожидаемому", exceptedAnswer, actualText);
    }

    @Test
    public void test2() {
        mainPage.clickCookieButton();
        mainPage.scrollToFAQBlock();
        mainPage.clickFAQQuestionN(2);
        String actualText = mainPage.getTextFAQAnswerN(2);
        String exceptedAnswer = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        Assert.assertEquals("Текст в блоке 2 FAQ не соответствует ожидаемому", exceptedAnswer, actualText);
    }

    @Test
    public void test3() {
        mainPage.clickCookieButton();
        mainPage.scrollToFAQBlock();
        mainPage.clickFAQQuestionN(3);
        String actualText = mainPage.getTextFAQAnswerN(3);
        String exceptedAnswer = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        Assert.assertEquals("Текст в блоке 3 FAQ не соответствует ожидаемому", exceptedAnswer, actualText);
    }
    @Test
    public void test4() {
        mainPage.clickCookieButton();
        mainPage.scrollToFAQBlock();
        mainPage.clickFAQQuestionN(4);
        String actualText = mainPage.getTextFAQAnswerN(4);
        String exceptedAnswer = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        Assert.assertEquals("Текст в блоке 4 FAQ не соответствует ожидаемому", exceptedAnswer, actualText);
    }
    @Test
    public void test5() {
        mainPage.clickCookieButton();
        mainPage.scrollToFAQBlock();
        mainPage.clickFAQQuestionN(5);
        String actualText = mainPage.getTextFAQAnswerN(5);
        String exceptedAnswer = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        Assert.assertEquals("Текст в блоке 5 FAQ не соответствует ожидаемому", exceptedAnswer, actualText);
    }
    @Test
    public void test6() {
        mainPage.clickCookieButton();
        mainPage.scrollToFAQBlock();
        mainPage.clickFAQQuestionN(6);
        String actualText = mainPage.getTextFAQAnswerN(6);
        String exceptedAnswer = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        Assert.assertEquals("Текст в блоке 6 FAQ не соответствует ожидаемому", exceptedAnswer, actualText);
    }
    @Test
    public void test7() {
        mainPage.clickCookieButton();
        mainPage.scrollToFAQBlock();
        mainPage.clickFAQQuestionN(7);
        String actualText = mainPage.getTextFAQAnswerN(7);
        String exceptedAnswer = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        Assert.assertEquals("Текст в блоке 7 FAQ не соответствует ожидаемому", exceptedAnswer, actualText);
    }



    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}




