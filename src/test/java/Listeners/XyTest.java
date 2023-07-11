package Listeners;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class XyTest {

    @BeforeTest
    public void beforeTest()
    {
        System.out.println("Before Test .......\n");
    }

    @AfterTest
    public void afterTest()
    {
        System.out.println("After Test .......");
    }
    @Test
    public void xTest()
    {
        System.out.println("X Test from XYTEST... ");
    }

    @Test
    public void yTest()
    {
        System.out.println("Y Test from XYTEST... ");
    }
}


