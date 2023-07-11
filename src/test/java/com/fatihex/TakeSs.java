package com.fatihex;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TakeSs {

    @Test
    public void TakeSs() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        TakesScreenshot screenshot= (TakesScreenshot) driver;
        File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(sourcefile, new File(".src/main/resources/deneme.png"));
    }
}
