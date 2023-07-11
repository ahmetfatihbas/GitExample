package com.fatihex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class TestEX {
        // annotation diyoruz.
        public void loginPositive() {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://phptravels.com/demo");
            driver.navigate().to("https://google.com");

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
        }
        public void RahulAcademyLogin() throws InterruptedException {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://rahulshettyacademy.com/locatorspractice/");
            driver.findElement(By.cssSelector("input[id ='inputUsername']")).sendKeys("Ahmet Fatih Baş");
            driver.findElement(By.cssSelector("input[name ='inputPassword']")).sendKeys("rahulshettyacademy");
            driver.findElement(By.cssSelector("input[id='chkboxOne']")).click();
            driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
            Thread.sleep(1000);
            WebElement helloTitle = driver.findElement(By.xpath("//h2"));
            String text = helloTitle.getText();
            Assert.assertTrue(text.contains("Hello"));
            Assert.assertEquals(text, "Hello Ahmet Fatih Baş,");
        }

            public void loginNegativeMissingAll() throws InterruptedException {
                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                driver.get("https://rahulshettyacademy.com/locatorspractice/");
                driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
                WebElement errorTitle = driver.findElement(By.cssSelector("p.error"));
                String text = errorTitle.getText();
                System.out.println(text);
                Assert.assertTrue(text.contains("* Incorrect username or password"));
                driver.findElement(By.xpath("//div[@class ='forgot-pwd-container']/a")).click();
                driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Fatih");
                driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("fatihbas@gmail.com");
                driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("05464021048");
                driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
                String passwordMsg = driver.findElement(By.cssSelector("p.infoMsg")).getText();
                Assert.assertEquals(passwordMsg, "Please use temporary password 'rahulshettyacademy' to Login.");
            }
        public void loginNegativeMissingPassword() throws InterruptedException {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get("https://rahulshettyacademy.com/locatorspractice/");
            driver.findElement(By.cssSelector("input[id ='inputUsername']")).sendKeys("Ahmet Fatih Baş");
            driver.findElement(By.cssSelector("input[name ='inputPassword']")).sendKeys("rahulshettyacademy");
            driver.findElement(By.cssSelector("input[id='chkboxOne']")).click();
            driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
            WebElement helloTitle = driver.findElement(By.xpath("//h2"));
            String text = helloTitle.getText();
            Assert.assertTrue(text.contains("Hello"));
            Assert.assertEquals(text, "Hello Ahmet Fatih Baş,");
        }

        public void getpassword() throws InterruptedException {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get("https://rahulshettyacademy.com/locatorspractice/");
            driver.findElement(By.xpath("//div[@class ='forgot-pwd-container']/a")).click();
            driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Fatih");
            driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("fatihbas@gmail.com");
            driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("05464021048");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
            String passwordMsg = driver.findElement(By.cssSelector("p.infoMsg")).getText();
            System.out.println(passwordMsg);
            int startIndex = passwordMsg.indexOf("'");
            int endIndex = (passwordMsg.lastIndexOf("'"));

            String password = passwordMsg.substring(startIndex+1, endIndex);
            String username = "Ahmet Fatih Baş";
            Assert.assertTrue(passwordMsg.contains("temporary password "));
            driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();
            driver.findElement(By.cssSelector("input[id ='inputUsername']")).sendKeys(username);
            driver.findElement(By.cssSelector("input[name ='inputPassword']")).sendKeys(password);
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("input[id='chkboxOne']")).click();
            driver.findElement(By.cssSelector("input[id='chkboxTwo']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
            String hello = driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText();
            Assert.assertTrue(hello.contains(username));


        }

        public void loginNegativeWrongPassword() throws InterruptedException {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get("https://rahulshettyacademy.com/locatorspractice/");
            driver.findElement(By.cssSelector("input[id ='inputUsername']")).sendKeys("Ahmet Fatih Baş");
            driver.findElement(By.cssSelector("input[name ='inputPassword']")).sendKeys("rahulshettyacademy");
            driver.findElement(By.cssSelector("input[id='chkboxOne']")).click();
            driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
            WebElement helloTitle = driver.findElement(By.xpath("//h2"));
            String text = helloTitle.getText();
            Assert.assertTrue(text.contains("Hello"));
            Assert.assertEquals(text, "Hello Ahmet Fatih Baş,");

    }


        }





