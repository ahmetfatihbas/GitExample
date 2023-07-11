package TestNGex;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class XyzTest {
    @BeforeTest
    public void beforeTest()
    {
        System.out.println("Before Test çalıştırıldı.");
        System.out.println("Test modul başlangıcı.");
    }



    @Test(dependsOnMethods = {"zTest"})  //dependsOn metodu bu örnekteki gibi hangi testin adı yazıldıysa ondan sonra çalışır.
    public void xTest()
    {
        System.out.println("X Test çalıştırıldı");
    }

    @Test(groups = {"Monkey"})
    public void yTest()
    {
        System.out.println("Y Test çalıştırıldı");
    }

    @Test(timeOut = 10000)
    public void zTest()
    {
        System.out.println("Z Test çalıştırıldı");
    }
}
