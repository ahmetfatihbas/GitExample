package com.fatihex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class LoginWaitingExamples {
    @Test
    public void LoginPositive() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // explicity waiting için kodun başına yazılır.

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("learning");
        driver.findElement(By.xpath("//span[contains(text(),'User')]")).click();

        By okBtn = By.id("okayBtn");

        wait.until(ExpectedConditions.visibilityOfElementLocated(okBtn));
        driver.findElement(okBtn).click();

        driver.findElement(By.xpath("//a[text() = 'terms and conditions']")).click();
        driver.findElement(By.xpath("//input[@id='signInBtn']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("a[contains(@class,'btn-primary')]")));


        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        Assert.assertEquals(currentUrl, "https://rahulshettyacademy.com/angularpractice/shop");

        List<WebElement> cards = driver.findElements(By.cssSelector("div.card.h-100"));
        System.out.println(cards.size());

        for (WebElement card : cards) {

            card.findElement(By.tagName("button")).click();

        }
        driver.findElement(By.cssSelector("a[contains(@class,'btn-primary')]"));
    }
}


