package com.fatihex;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class PhpTravel {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://phptravels.com/demo");

        WebElement textbox = driver.findElement(By.xpath("//input[@class='first_name input mb1']"));
        textbox.sendKeys("Ahmet Fatih Baş");
        driver.findElement(By.xpath("//input[@class='last_name input mb1']")).sendKeys("Baş");
        driver.findElement(By.xpath("//input[@class='business_name input mb1']")).sendKeys("İşadamı");
        driver.findElement(By.xpath("//input[@class='email input mb1']")).sendKeys("fatihbas@gmail.com");
        String spamText = driver.findElement(By.xpath("//h2[@class='cw mw100']")).getText();  // 4+3 =
        System.out.println(spamText);

        int num1 = Integer.parseInt(spamText.split("\\+")[0].trim());
        int num2 = Integer.parseInt(spamText.split("\\+")[1].split("=")[0].trim());
        System.out.println("1. Sayı : " + num1);
        System.out.println("2. Sayı : " + num2);

        driver.findElement(By.id("number")).sendKeys("" + (num1 + num2));
        driver.findElement(By.xpath("//button[@class='btn w100']")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'privacy')]")).click();
        driver.findElement(By.xpath("//div[@class='row']/a[contains(@href,'statement')]")).click();






    }
}
