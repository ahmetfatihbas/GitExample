package com.fatihex;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class IFrameExamples {
    @Test
    public void IframeHandle()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://jqueryui.com/droppable/");

        // driver.findElements(By.tagName("iframe"));     kaç tane iframe olduğunu öğrenmek için

        WebElement iframe = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(iframe);
        String text = driver.findElement(By.id("draggable")).getText();
        System.out.println(text);

        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[text()='Accept']"));

    }



    @Test
    public void DragDropAction()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://jqueryui.com/droppable/");

        WebElement iframe = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(iframe);

        WebElement sourceDrag = driver.findElement(By.cssSelector("div#draggable"));
        WebElement targetDrop = driver.findElement(By.cssSelector("div#droppable"));

        String text = driver.findElement(By.id("draggable")).getText();
        System.out.println(text);


        Actions action = new Actions(driver);
        action.dragAndDrop(sourceDrag, targetDrop).build().perform();

        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[text()='Accept']"));

    }
    @Test
    public void NestedFrameBottom() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-bottom");

        System.out.println(driver.findElement(By.tagName("body")).getText());


    }
    @Test
    public void NestedFrame() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-top").switchTo().frame("frame-right");

        WebElement body = driver.findElement(By.tagName("body"));
        System.out.println(body.getText());


    }
    @Test
    public void NestedFrame2() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-top").switchTo().frame("frame-right");

        WebElement body = driver.findElement(By.tagName("body"));
        System.out.println(body.getText());
    }
    @Test
    public void NestedFramesBottom() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        WebElement iframeBottom = driver.findElement(By.name("frame-bottom"));
        driver.switchTo().frame(iframeBottom);
        System.out.println(driver.findElement(By.tagName("body")).getText());

    }
    @Test
    public void NestedFrames() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-top").switchTo().frame("frame-right");
        WebElement body = driver.findElement(By.tagName("body"));

        System.out.println(body.getText());

        driver.switchTo().parentFrame().switchTo().frame("frame-left");
        WebElement bodyLeft = driver.findElement(By.tagName("body"));

        System.out.println(bodyLeft.getText());

        driver.switchTo().parentFrame().switchTo().frame("frame-middle");
        WebElement bodyMiddle = driver.findElement(By.tagName("body"));

        System.out.println(bodyMiddle.getText());
        /*
        driver.switchTo().frame("frame-top").switchTo().frame("frame-right");

        WebElement body = driver.findElement(By.tagName("body"));
        System.out.println(body.getText());
*/

    }
    @Test
    public void FindLinksInFooter() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");


        WebElement footerTable = driver.findElement(By.xpath("//div[@id='gf-BIG']//li/a"));
        List<WebElement> footerLinks = footerTable.findElements(By.tagName("a"));


        for(WebElement link : footerLinks)
        {
            link.click();
            System.out.println(link.getText());
        }
    }
    @Test
    public void Find16Links() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");


        WebElement footerTable = driver.findElement(By.xpath("//div[@id='gf-BIG']//li/a"));
        List<WebElement> footerLinks = footerTable.findElements(By.tagName("a"));


        for(WebElement link : footerLinks)
        {
            System.out.println(link.getText());
        }
    }
}
