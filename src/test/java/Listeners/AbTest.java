package Listeners;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AbTest {

    @BeforeMethod
    public void beforeMethod()
    {
        System.out.println("Before Method ........");
    }

    @AfterMethod
    public void afterMethod()
    {
        System.out.println("After Method ........void\n");
    }

    @Test
    public void aTest()
    {
        System.out.println("A Test from ABTEST... ");
    }

    @Test
    public void bTest()
    {
        System.out.println("B Test from ABTEST... ");
    }
}
