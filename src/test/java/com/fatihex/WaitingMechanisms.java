package com.fatihex;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class WaitingMechanisms {
    @Test
    public void implicitWaitMechanism2() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        List<WebElement> productNames = driver.findElements(By.cssSelector("h4.product-name"));
        List<WebElement> productButtons = driver.findElements(By.xpath("//div[@class='product-action']/button"));
        System.out.println(productNames.size());
        String wanted = "Cucumber";
        int count = 0;

        for (int i = 0; i < productNames.size(); i++) {
            String prName = productNames.get(i).getText();

            if (prName.contains(wanted)) {
                productButtons.get(i).click();
                count++;
                break;
            }
        }
        String cartProNum = driver.findElement(By.xpath("//div[@class='cart-info']//strong[1]")).getText();
        Assert.assertEquals(cartProNum, String.valueOf(count));
    }

    @Test
    public void implicitWaitMechanism3() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        //driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/#/");
        List<WebElement> productNames = driver.findElements(By.cssSelector("h4.product-name"));
        List<WebElement> productButtons = driver.findElements(By.xpath("//div[@class='product-action']/button"));
        System.out.println(productNames.size());

        int count = 0;
        String[] wantedProducts = {"Cucumber", "Tomato", "Potato"};

        for (String wanted : wantedProducts) {
            for (int i = 0; i < productNames.size(); i++) {
                String productName = productNames.get(i).getText();
                if (productName.contains(wanted)) {
                    productButtons.get(i).click();
                    break;
                }
            }
        }
            String cartProNum = driver.findElement(By.xpath("//div[@class='cart-info']//strong[1]")).getText();
            Assert.assertEquals(Integer.parseInt(cartProNum), wantedProducts.length);
        driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));// Beklenmesi gereken yerde özel bekleme komutu
        driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//button[@class='promoBtn']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));// Beklenmesi gereken yerde özel bekleme komutu

        WebElement promomessage = driver.findElement(By.cssSelector("span.promoInfo"));
        System.out.println(promomessage.getText());
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();


    }
    }
