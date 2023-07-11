package TestNGex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class FireFoxtest {
    @Parameters ({"browser"})
    @Test
    public void openBrowser(String browser){

    WebDriver driver = null;

    {
        if(browser.equals("chrome"))
        driver = new ChromeDriver();
        else if (browser.equals("firefox"))
        driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.rahulshettyacademy.com/LoginpagePractice/");
        }
    }


}
