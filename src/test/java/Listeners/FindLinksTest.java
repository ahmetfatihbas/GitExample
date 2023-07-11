package Listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindLinksTest {
    @Test
            public void FindLinkSimple() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> alinks = driver.findElements(By.tagName("a"));
        System.out.println(alinks.size());  //27

        for (WebElement alink : alinks) {
            System.out.println(alink.getText());
        }

        driver.switchTo().frame("courses-iframe");
        alinks = driver.findElements(By.tagName("a"));
        System.out.println(alinks.size());
    }
    @Test
    public void FindLinkInFooter() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement footerTable = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
        List<WebElement> footerlinks = footerTable.findElements(By.tagName("a"));
        System.out.println(footerlinks.size());

        for (WebElement link : footerlinks) {
            System.out.println(link.getText());
        }
    }
}
