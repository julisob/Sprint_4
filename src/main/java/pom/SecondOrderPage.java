package pom;

import org.openqa.selenium.*;
import org.junit.*;
import java.time.Duration;

public class SecondOrderPage {

    private final WebDriver driver;
    //поле дата
    private By date = By.xpath(".//input[@placeholder= '* Когда привезти самокат']");
    //поле срок аренды
    private By orderTime= By.className("Dropdown-control");
    // сутки
    private By oneDay= By.xpath(".//div[text()= 'сутки']");
    //чекбокс
    private By colorBlack = By.className("Checkbox_Input__14A2w");
    //поле комментарий
    private By comment = By.xpath(".//input[@placeholder= 'Комментарий для курьера']");
    //кнопка заказать
    private By finishOrderButton = By.xpath(".//div[@class=\"Order_Buttons__1xGrp\"]/button[text()= 'Заказать']");
    // кнопка подтверждения заказа
    private By confirmButton = By.xpath(".//div[@class=\"Order_Buttons__1xGrp\"]/button[text()= 'Да']");
    // кнопка просмотра успешного заказа
    private By statusButton = By.xpath(".//div[@class=\"Order_NextButton__1_rCA\"]/button[text()= 'Посмотреть статус']");


    public SecondOrderPage(WebDriver driver){
        this.driver = driver;
    }

    public void inputDate(String userdate) {
        driver.findElement(date).sendKeys(userdate, Keys.ENTER);
    }
    public void inputOrderTime() {
        driver.findElement(orderTime).click();
        driver.findElement(oneDay).click();
    }

    public void inputColor() {
        driver.findElement(colorBlack).click();
    }

    public void inputComment(String usercomment) {
        driver.findElement(comment).sendKeys(usercomment);
    }

    public void clickOrderButton() {
        driver.findElement(finishOrderButton).click();
    }

    public void clickConfirmButton() {
        driver.findElement(confirmButton).click();
    }

    public WebElement findStatusButton() {
   //     Assert.assertTrue("Заказ не создан", driver.findElement(statusButton).isDisplayed());
        return driver.findElement(statusButton);

    }

    public void completeForm2(String userdate, String usercomment) {
        inputDate(userdate);
        inputOrderTime();
        inputColor();
        inputComment(usercomment);
        clickOrderButton();
        clickConfirmButton();
    }


}
