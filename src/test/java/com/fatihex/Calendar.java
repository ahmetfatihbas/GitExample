package com.fatihex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;


public class Calendar {

    @Test
    public void CalendarSelect() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("input#ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value ='MAA']")).click();
        driver.findElement(By.xpath("//a[@value ='BLR']")).click();

        driver.findElement(By.cssSelector("td.ui-datepicker-today")).click();

    }

    @Test
    public void FamilyChkBox() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
        Thread.sleep(2000);
        WebElement divElement = driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily"));
        divElement.click();
        System.out.println(divElement.isSelected());

    }

    @Test
    public void CalendarEnable() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
        WebElement calendar1 = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']"));
        WebElement calendar2 = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date2']"));

        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();

        WebElement control = driver.findElement(By.id("Div1"));
        String enableText = control.getAttribute("style");

        boolean isEnable = enableText.contains("1") ? true : false;
        Assert.assertTrue(isEnable);





    }

}
