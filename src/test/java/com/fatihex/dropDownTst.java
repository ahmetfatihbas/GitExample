package com.fatihex;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class dropDownTst {
    @Test
    public void staticDropdown() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        Thread.sleep(1000);
        select.selectByVisibleText("Option 2");
        Thread.sleep(1000);
        select.selectByValue("1");
        Thread.sleep(1000);
        select.selectByIndex(2);
    }

    @Test
    public void staticDropdown2Approach() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        dropdown.click();
        dropdown.findElement(By.xpath("//option[text() ='Option 2']")).click();
    }

    @Test
    public void dynamicDropdown() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("div#divpaxinfo")).click();
        driver.findElement(By.id("hrefIncAdt")).click();
        driver.findElement(By.id("hrefIncAdt")).click();
        driver.findElement(By.id("hrefIncChd")).click();
        driver.findElement(By.id("hrefIncChd")).click();
        driver.findElement(By.id("hrefIncInf")).click();
        driver.findElement(By.id("hrefIncInf")).click();
        driver.findElement(By.id("btnclosepaxoption")).click();
    }

    @Test
    public void DropdownClickingGenre() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
        Thread.sleep(2000);
        WebElement dropdown = driver.findElement(By.cssSelector("div#divpaxinfo"));
        dropdown.click();
        WebElement adult = driver.findElement(By.id("hrefIncAdt"));
        WebElement child = driver.findElement(By.id("hrefIncChd"));
        WebElement infant = driver.findElement(By.id("hrefIncInf"));

        increase(adult, 1);
        increase(child, 2);
        increase(infant, 2);
        driver.findElement(By.id("btnclosepaxoption")).click();
        Assert.assertEquals(dropdown.getText(), "2 Adult, 2 Child, 2 Infant");
    }

    public void increase(WebElement element, int count) {
        for (int i = 0; i < count; i++) {
            element.click();
        }
    }

    @Test
    public void autoSuggestDd() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
        Thread.sleep(2000);
        driver.findElement(By.id("autosuggest")).sendKeys("Tur");
        List<WebElement> elements = driver.findElements(By.cssSelector("li.ui-menu-item"));

        for (WebElement element : elements) {
            System.out.println(element.getText());
            if (element.getText().equals("Turkmenistan")) {
                element.click();
                break;
            }

        }


    }
}


