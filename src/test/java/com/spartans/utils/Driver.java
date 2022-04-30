package com.spartans.utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {


    private Driver() {
    }


    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();


    public static WebDriver getDriver() {

        if (driverPool.get() == null) {


            String browserType = ConfigurationReader.getProperty("browser");


            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                    break;
                case "remote-chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    try{
                        URL url = new URL(ConfigurationReader.getProperty("remote_server"));
                        driverPool.set(new RemoteWebDriver(url,chromeOptions));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "remote-firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    try {
                        URL url = new URL(ConfigurationReader.getProperty("remote_server"));
                        driverPool.set(new RemoteWebDriver(url,firefoxOptions));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "remote-edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    try {
                        URL url = new URL(ConfigurationReader.getProperty("remote_server"));
                        driverPool.set(new RemoteWebDriver(url,edgeOptions));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;


            }
        }

        return driverPool.get();

    }


    public static void closeDriver() {

        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}