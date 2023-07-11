package TestNGex;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class LoginPage {

    @Parameters({"URL", "browser"})
    @Test (groups = {"Monkey"})
    public void webLoginPagePositive(String link,String browser)
    {
        System.out.println("Web Login Page Positive Test");
        System.out.println("Website : " + link);
        System.out.println("Browser name : " + browser);

    }

    @Test
    public void webLoginPageNegative1()
    {
        System.out.println("Web Login Page Negative 1 Test");
    }

    @Test
    public void webLoginPageNegative2()
    {
        System.out.println("Web Login Page Negative 2 Test");
    }

    @Test (groups = {"Monkey"})
    public void webLoginPageNegative3()
    {
        System.out.println("Web Login Page Negative 3 Test");
    }

    @Test
    public void mobilLoginPagePositive()
    {
        System.out.println("Mobil Login Page Positive Test");
    }

    @Test
    public void mobilLoginPageNegative1()
    {
        System.out.println("Mobil Login Page Negative 1 Test");
    }

    @Test
    public void mobilLoginPageNegative2()
    {
        System.out.println("Mobil Login Page Negative 2 Test");
    }

    @Test
    public void mobilLoginPageNegative3()
    {
        System.out.println("Mobil Login Page Negative 3 Test");
    }

}
