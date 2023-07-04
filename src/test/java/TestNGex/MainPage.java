package TestNGex;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MainPage {


    @BeforeSuite
    public void beforeSuite()
    {
        System.out.println("Before Suite çalıştı.");
        System.out.println("Suite başlatılıyor.");
    }
    @AfterSuite
    public void AfterSuite()
    {
        System.out.println("After Suite çalıştı.");
        System.out.println("Suite sona erdi.");
    }

    @Test(priority = 2)
    public void aTest()
    {
        System.out.println("a Test çalıştırıldı");
    }

    @Test(priority = 3)
    public void bTest()
    {
        System.out.println("b Test çalıştırıldı");
    }

    @Test(priority = 1)
    public void cTest()
    {
        System.out.println("c Test çalıştırıldı");
    }
}
