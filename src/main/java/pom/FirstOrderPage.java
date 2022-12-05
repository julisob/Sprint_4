package pom;

import org.openqa.selenium.*;

public class FirstOrderPage {
    private final WebDriver driver;
    //поле имя
    private final By name = By.xpath(".//input[@placeholder= '* Имя']");
    //поле фамилия
    private final By surname = By.xpath(".//input[@placeholder= '* Фамилия']");
    //поле адрес
    private final By address = By.xpath(".//input[@placeholder= '* Адрес: куда привезти заказ']");
    //поле станция метро
    private final By subway = By.className("select-search__input");
    //поле номер телефона
    private final By phone = By.xpath(".//input[@placeholder= '* Телефон: на него позвонит курьер']");
    //кнопка далее
    private final By nextButton = By.className("Button_Middle__1CSJM");

    public FirstOrderPage(WebDriver driver){
        this.driver = driver;
    }
    public void inputName(String username) {
        driver.findElement(name).sendKeys(username);
    }
    public void inputSurname(String usersurname) {
        driver.findElement(surname).sendKeys(usersurname);
    }
    public void inputAdress(String usersadress) {
        driver.findElement(address).sendKeys(usersadress);
    }
    public void inputSubway() {
        driver.findElement(subway).click();
        driver.findElement(subway).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }
    public void inputPhone(String userphone) {
        driver.findElement(phone).sendKeys(userphone);
    }
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void completeFirstForm(String username, String usersurname, String usersadress, String userphone) {
        inputName(username);
        inputSurname(usersurname);
        inputAdress(usersadress);
        inputSubway();
        inputPhone(userphone);
        clickNextButton();
    }
}



