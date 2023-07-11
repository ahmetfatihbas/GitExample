package TestNGex;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderEx {

    @Test(dataProvider = "getData")
    public void test(String username, String password) {
        System.out.println("Username : " + username);
        System.out.println("Password : " + password);
        System.out.println("---------------d");

    }
    @Test(dataProvider = "getDatas")
    public void test2(String username, String password) {
        System.out.println("Username : " + username);
        System.out.println("Password : " + password);
        System.out.println("---------------d");

    }

    @DataProvider
    public Object[][] getData() {
        Object[][] datas = new Object[3][2];
        datas[0][0] = "username1";
        datas[0][1] = "password1";

        datas[1][0] = "username2";
        datas[1][1] = "password2";

        datas[2][0] = "username3";
        datas[2][1] = "password3";

        return datas;
    }

    @DataProvider
    public Object[][] getDatas() {
        Object[][] datas = new Object[3][2];
        datas[0][0] = "username4";
        datas[0][1] = "password4";

        datas[1][0] = "username5";
        datas[1][1] = "password5";

        datas[2][0] = "username6";
        datas[2][1] = "password6";

        return datas;
    }
}
