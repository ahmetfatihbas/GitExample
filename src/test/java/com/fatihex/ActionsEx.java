package com.fatihex;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;

public class ActionsEx {
    @Test
    public void mouseHover() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.amazon.com.tr");

        Actions action = new Actions(driver);
        WebElement signInMenu = driver.findElement(By.cssSelector("a#nav-link-accountList"));
        action.moveToElement(signInMenu).build().perform();
    }

    @Test
    public void keyboardInteractions() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.amazon.com.tr");

        Actions action = new Actions(driver);
        WebElement senKey = driver.findElement(By.id("twotabsearchtextbox"));

        action.moveToElement(senKey).click().keyDown(Keys.SHIFT).sendKeys("kulaklık").sendKeys(Keys.ENTER).build().perform();
    }

    @Test
    public void rightClick() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.amazon.com.tr");

        Actions action = new Actions(driver);
        WebElement signInMenu= driver.findElement(By.cssSelector("a#nav-link-accountList"));

        action.moveToElement(signInMenu).contextClick().build().perform();
    }
}
