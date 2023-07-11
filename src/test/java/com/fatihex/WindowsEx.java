package com.fatihex;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowsEx {
    @Test
    public void childWindow() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.xpath("//a[@class= 'blinkingText']")).click();

        Set <String> windows = driver.getWindowHandles();
        Iterator<String > it= windows.iterator();

        String parent = it.next();
        String child = it.next();

        driver.switchTo().window(child);

        String mail = driver.findElement(By.cssSelector("[href*='mailto']")).getText();
        System.out.println(mail);
        driver.close();


        driver.switchTo().window(parent);
        driver.findElement(By.id("username")).sendKeys(mail);


        /*
        System.out.println(parent);
        System.out.println(child);
*/



     /*


        System.out.println(windows);
        System.out.println(windows.size());
        for (String item : windows) {
            System.out.println(item);
            */
        }

    }



