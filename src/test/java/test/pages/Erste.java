package test.pages;

import test.utilities.BrowserUtils;
import test.utilities.ConfigurationReader;
import test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class Erste extends BasePage {
    @FindBy(id = "user")
    public WebElement userName;
    @FindBy(id = "submitButton")
    public WebElement submitBtn;
    @FindBy(id = "secret")
    public WebElement password;
    @FindBy(xpath = "//input[@value='Login']")
    public WebElement loginBtn;
    @FindBy(css = ".btn.btn-secondary")
    public WebElement cookieBtn;
    @FindBy(css = ".form-control")
    public WebElement searchBox;
    @FindBy(xpath = "//button[@data-cy='search-trigger-button']")
    public WebElement searchBtn;
    @FindBy(className = "g-status-info-title")
    public WebElement noSearchResult;
    @FindBy(xpath = "//span[@data-cy ='category-badge']")
    public WebElement publishCategory;
    @FindBy(className = "g-status-info-title")
    public WebElement sorryMessage;
    @FindBy(id = "langFlagDE")
    public WebElement languageSelection;
    public void landingPage(){
        Driver.get().get(ConfigurationReader.get("ersteUrl"));
        BrowserUtils.waitForClickablility(cookieBtn,10);
        cookieBtn.click();
        languageSelection.click();
    }
    public void textSearchBox(){
        BrowserUtils.waitForVisibility(searchBox, Duration.ofSeconds(15));
        searchBox.sendKeys("Fashion");
        searchBtn.click();
    }

    public void login() {
        userName.sendKeys("101980439");
        submitBtn.click();
        password.sendKeys("1111111");
        loginBtn.click();
    }
    public WebElement listOfFashion(int rowNumber) {
        String xpath = "(//tbody/tr)" + "[" + rowNumber + "]";
        return Driver.get().findElement(By.xpath(xpath));
    }
}