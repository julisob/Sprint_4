package pom;

import org.openqa.selenium.*;
import org.junit.*;
import java.time.Duration;

public class MainPage {

    private WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    public void open() {
        driver.get(urlPage);
    }
    //страница
    private final String urlPage = "https://qa-scooter.praktikum-services.ru/";
    //кнопка принять куки
    private By cookieButton = By.className("App_CookieButton__3cvqF");
    //блок FAQ
    private By FAQBlock = By.className("accordion");

    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }

    public void scrollToFAQBlock() {
        WebElement element = driver.findElement(FAQBlock);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //клик по вопросу
    public void clickFAQQuestionN(int n) {
        driver.findElement(By.id("accordion__heading-" + n)).click();
    }
    //отображение и текст ответа
    public String getTextFAQAnswerN(int n) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        By el = By.xpath("//div[@id=\"accordion__panel-" + n + "\"]");
      //  By el = By.xpath(".//div[@id =\"accordion__panel-3\"]");

        //.//div[@id ="accordion__panel-3"]

        Assert.assertTrue("Ответ FAQ в блоке " + n + " не отображается", driver.findElement(el).isDisplayed());
        return driver.findElement(el).getText();
    }

    //верхняя кнопка заказать
    private By topOrderButton = By.xpath(".//button[@class = 'Button_Button__ra12g']");
    //нижняя кнопка заказать
    private By bottomOrderButton = By.xpath(".//button[@class = \"Button_Button__ra12g Button_Middle__1CSJM\"]");
    public void clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
    }
    public void clickBottomOrderButton() {
        driver.findElement(bottomOrderButton).click();
    }
}


