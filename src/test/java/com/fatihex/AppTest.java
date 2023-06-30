package com.fatihex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;


public class AppTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ebilet.tcddtasimacilik.gov.tr/view/eybis/tnmGenel/tcddWebContent.jsf");
        WebElement textbox = driver.findElement(By.id("nereden"));
        driver.findElement(By.id("nereden"));
        textbox.sendKeys("Ankara");

        WebElement textbox1 = driver.findElement(By.id("nereye"));
        driver.findElement(By.id("nereye"));
        textbox1.sendKeys("İstanbul(Bakırköy)");
    }
}