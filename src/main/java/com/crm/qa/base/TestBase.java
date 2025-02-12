package com.crm.qa.base;
import com.crm.qa.util.TestUtils;
import com.crm.qa.util.myWebListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase
{
    public static WebDriver driver;
    public static Properties prop;
    public static String projectPath= System.getProperty("user.dir");
    public static WebDriverListener eventListener;

    public TestBase()
    {
        //add code to read the properties
        try
        {
            prop=new Properties();
            FileInputStream ip=new FileInputStream(projectPath + "/src/main/java/com/crm/qa/config/config.properties");
            prop.load(ip);
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void initialization()
    {
        //initialize the drivers
        String browserName=prop.getProperty("browser");
        if(browserName.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        if(browserName.equals("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }

        // Initialize the event listener and wrap the driver
        eventListener=new myWebListener();
        driver=new EventFiringDecorator<>(eventListener).decorate(driver);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtils.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtils.IMPLICIT_WAIT));
        driver.get(prop.getProperty("url"));
    }
}
