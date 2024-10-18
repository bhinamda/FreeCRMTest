package com.crm.qa.testcases;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase
{
    LoginPage loginpage;
    HomePage homepage;

    public LoginPageTest()
    {
        super();
    }

    @BeforeMethod
    public void setup()
    {
        initialization();
        loginpage=new LoginPage();
    }
    @Test(priority = 1)
    public void loginPageTitleTest()
    {
        String title= loginpage.validateLoginPageTitle();
        Assert.assertEquals(title,"Free CRM software for customer relationship management, sales, and support.");
    }

        @Test(priority = 2)
        public void CRMLogoImageTest()
        {
            boolean flag=loginpage.validateCRMLogoImg();
            Assert.assertTrue(flag);
        }

        @Test(priority = 3)
        public void loginTest()
        {
            homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));

        }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
