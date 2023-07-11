package TestNGex;

import org.testng.annotations.*;

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

    @BeforeClass
    public void beforeClass()
    {
        System.out.println("MainPage Class başlatıldı");
    }

    @AfterClass
    public void afterClass()
    {
        System.out.println("MainPage Class çalıştı.");
        System.out.println("MainPage Class sonlandırıldı.");

    }


    @BeforeMethod
    public void beforeMethod()
    {
        System.out.println("Before Method -------- Main Page ---------- de çalıştı.");
    }

    @BeforeMethod
    public void AfterMethod()
    {
        System.out.println("After Method -------- Main Page ---------- de sonlandı.");
    }
    @Test(groups = {"Monkey"})
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
