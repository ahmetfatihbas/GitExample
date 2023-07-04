package com.fatihex;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class Js {
    @Test
    public void scrollDownSimple()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        js.executeScript("document.querySelector('.tableFixHead').scrollTo(0,100)");

    }

    @Test
    public void scrollTableJsEx()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement tableFix = driver.findElement(By.cssSelector("div.tableFixHead"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", tableFix);

        List<WebElement> rows = driver.findElements(By.cssSelector("div.tableFixHead tbody tr td:nth-child(4)"));
        int sum = 0;

        for(WebElement row : rows)
        {
            sum += Integer.parseInt(row.getText());
        }

        System.out.println(sum);

        WebElement actualSum = driver.findElement(By.cssSelector("div.totalAmount"));
        System.out.println(actualSum.getText());
        String text = actualSum.getText();

        String num = text.split(":")[1].trim();
        Assert.assertEquals(Integer.parseInt(num),sum);
    }

    @Test
    public void scrollTableActionsEx()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement tableFix = driver.findElement(By.cssSelector("div.tableFixHead"));
        Actions act = new Actions(driver);
        act.scrollToElement(tableFix).build().perform();

        // JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("arguments[0].scrollIntoView();", tableFix);

        List<WebElement> rows = driver.findElements(By.cssSelector("div.tableFixHead tbody tr td:nth-child(4)"));
        int sum = 0;

        for(WebElement row : rows)
        {
            sum += Integer.parseInt(row.getText());
        }

        System.out.println(sum);

        WebElement actualSum = driver.findElement(By.cssSelector("div.totalAmount"));
        System.out.println(actualSum.getText());
        String text = actualSum.getText();

        String num = text.split(":")[1].trim();
        Assert.assertEquals(Integer.parseInt(num),sum);
    }

        @Test
    public void StaticTest() {
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");

            driver.findElement(By.cssSelector("a[href*='soap']")).click();
            System.out.println("tiklandi");
        }

        @Test
    public void suggestionDropdown()
        {
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");
            driver.findElement(By.cssSelector("inpu#autocomplete")).sendKeys("Tu");

            Actions actions = new Actions(driver);
            WebElement resultCountry = driver.findElement(By.xpath("//div[text()='Tuvalu']"));

            actions.moveToElement(resultCountry).click().build().perform();
        }

}
