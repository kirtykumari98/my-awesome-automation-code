package com.automation.project.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


import static org.testng.Assert.assertTrue;

public class WaitsInAction {

    protected WebDriver driver;
    private WebDriverWait wait;
    Wait<WebDriver> fluentWait;

    @BeforeSuite(groups = "setup")
    public void openBrowser() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("https://www.facebook.com");
        fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class);
    }

    @Test
    public void createNewFacebookAccount() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement createAccountButton = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        createAccountButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname"))); //0ms
        System.out.println(driver.findElement(By.name("firstname")).isDisplayed());
        driver.findElement(By.name("firstname")).sendKeys("rdbatch2");
    }

    @Test
    public void facebookCreateUser() {
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));
        driver.findElement(By.name("firstname")).sendKeys("Nidhi");
        driver.findElement(By.name("lastname")).sendKeys("R");
        driver.findElement(By.name("reg_email__")).sendKeys("7894756123");
        driver.findElement(By.name("reg_passwd__")).sendKeys("Facebook1232%");
        Select select = new Select(driver.findElement(By.name("birthday_day")));
        select.selectByVisibleText("20");
//        driver.findElement(By.name("birthday_day")).sendKeys("20");
        driver.findElement(By.name("birthday_month")).sendKeys("Apr");
        driver.findElement(By.id("year")).sendKeys("1999");
        driver.findElement(By.name("sex")).click();
        driver.findElement(By.name("websubmit")).click();
//        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Continue']")));
//        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.name("websubmit"))));
        assertTrue(driver.getPageSource().contains("We need more information"));
        driver.quit();
    }

    @Test
    public void loginFacebook() {
        driver.get("https://www.facebook.com");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("7894756123");
        WebElement password = driver.findElement(By.id("pass"));
        password.sendKeys("Facebook1232%");
        password.submit();
        driver.quit();
    }

    @AfterSuite(groups = "setup")
    public void tearDown() {
        driver.close();
    }


}
