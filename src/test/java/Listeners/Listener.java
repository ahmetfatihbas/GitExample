package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
    ITestListener.super.onTestStart(result);
    System.out.println("onTestStart ........");
}
    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        System.out.println("onTestSuccess ........");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        System.out.println("onTestFailure ........" + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        System.out.println("onStart ........");
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        System.out.println("onFinish ........");
    }
}
