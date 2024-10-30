package com.crm.qa.base;
import com.crm.qa.util.TestUtils;
import com.crm.qa.util.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase
{
    public static WebDriver driver;
    public static Properties prop;
    public static String projectPath= System.getProperty("user.dir");
    public static EventFiringWebDriver e_driver;
    public static  WebEventListener eventListener;

    public TestBase()
    {
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

        e_driver=new EventFiringWebDriver(driver);
        //register the event listener handle(WebEventListener class object) with the EventFiringWebDriver
        eventListener=new WebEventListener();
        e_driver.register(eventListener);
        driver=e_driver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT,TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }

}
