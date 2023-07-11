package com.fatihex;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WindowHandles {
    @Test
    public void multiChildWindowsIterator() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");


        List<WebElement> links = driver.findElements(By.cssSelector("div#gf-BIG td:nth-child(1) li>a"));

        String keyComb = Keys.chord(Keys.COMMAND, Keys.ENTER);

        for (WebElement link : links) {
            link.sendKeys(keyComb);
        }
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parent = it.next();

        while (it.hasNext()) {
            String child = it.next();
            driver.switchTo().window(child);
            System.out.println(driver.getTitle());
            driver.close();
        }
    }
        @Test
        public void multiChildWindowsForEach ()
        {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");

            List<WebElement> links = driver.findElements(By.cssSelector("div#gf-BIG td:nth-child(1) li>a"));

            String keyComb = Keys.chord(Keys.COMMAND, Keys.ENTER);

            for (WebElement link : links) {
                link.sendKeys(keyComb);
            }
            Set<String> windows = driver.getWindowHandles();
            String parentWin = driver.getWindowHandle();


            for (String windowId : windows) {
                if(windowId.equals(parentWin))
                {
                    continue;
                }
                driver.switchTo().window(windowId);
                System.out.println(driver.getTitle());
                driver.close();
            }
        }
    }



