package com.fatihex;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChkBoxEx {

    @Test
    public void checkBoxSample() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("dropdown-class-example")).click();
        driver.findElement(By.xpath("//option[@value ='option2']")).click();
        driver.findElement(By.id("checkBoxOption2")).click();
    }

    @Test
    public void checkBoxSmp() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
        Thread.sleep(2000);
        WebElement chkbox = driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount"));
        chkbox.click();
        Assert.assertTrue(chkbox.isSelected()); // checkbox işaretlenip işaretlenmediğini kontrol eder.True-false cevabı verir.
    }

    @Test
    public void checkBoxThird() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_mainContent_chk_IndArm")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_mainContent_chk_Unmr")).click();

    }

    @Test
    public void checkBoxGeneric() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");

        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("div#discount-checkbox>div input"));
        System.out.println("Eleman Sayısı : " + checkBoxes.size());

        for (WebElement chck : checkBoxes) {
            chck.click();
            Thread.sleep(1000);
        }
    }

    @Test
    public void checkBoxGeneric2() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");

        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("div#discount-checkbox>div input"));
        List<WebElement> labels = driver.findElements(By.cssSelector("div#discount-checkbox>div label"));
        for (int i = 0; i < checkBoxes.size(); i++) {

            String labelText = labels.get(i).getText().trim();
            if (labelText.equalsIgnoreCase("student")) {
                checkBoxes.get(i).click();
                break;
            }
        }
    }

            @Test
            public void checkBoxGenericMap () {
                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");

                List<WebElement> divContainers = driver.findElements(By.cssSelector("div#discount-checkbox>div"));

                Map<String, WebElement> checkboxes = new HashMap<>();

                for (int j = 0; j < divContainers.size(); j++) {
                    String label = divContainers.get(j).findElement(By.cssSelector("label")).getText();
                    WebElement element = divContainers.get(j).findElement(By.cssSelector("input"));

                    checkboxes.put(label, element);
                }
                for (Map.Entry<String, WebElement> item : checkboxes.entrySet()) {
                    if (item.getKey().equals("Senior Citizen")) {
                        item.getValue().click();
                    }

                }
            }




        }

