package com.fatihex;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import static io.netty.handler.codec.rtsp.RtspHeaderValues.URL;

public class Http404BrokenLinks {
    @Test
    public void BrokenLinks() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> alinks = driver.findElements(By.cssSelector("div#gf-BIG li>a"));

        for (WebElement link : alinks) {
            String url = link.getAttribute("href");

            int statusCode = isLinkBroken(url);

            System.out.println(statusCode);
            if (statusCode >= 400) {
                Assert.assertTrue(false, "" + statusCode + " : " + url);
            }
        }
    }

    public int isLinkBroken(String url) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestMethod("HEAD");
        conn.connect();

        int statusCode = conn.getResponseCode();

        return statusCode;
    }


    @Test
    public void BrokenLinks2() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> alinks = driver.findElements(By.cssSelector("div#gf-BIG li>a"));

        SoftAssert softAssert = new SoftAssert();

        for (WebElement link : alinks) {
            String url = link.getAttribute("href");

            int statusCode = isLinkBroken(url);

            if (statusCode >= 400) {
                softAssert.assertTrue(false);
                System.out.println(url);
            }

         }
        softAssert.assertAll();
        }
    }