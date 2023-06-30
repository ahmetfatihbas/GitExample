package com.fatihex;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
    @Test
public void simpleAlertOk() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("name")).sendKeys("Ahmet Fatih");
        driver.findElement(By.id("alertbtn")).click();
        String message = driver.switchTo().alert().getText();
        System.out.println(message);
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
    }

    @Test
    public void alertOkCancel()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("name")).sendKeys("Ahmet Fatih");
        driver.findElement(By.id("confirmbtn")).click();

        Alert alert = driver.switchTo().alert();

        alert.getText();

}

}
