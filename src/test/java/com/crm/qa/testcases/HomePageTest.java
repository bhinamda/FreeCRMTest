package com.crm.qa.testcases;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase
{
    LoginPage loginpage;
    HomePage homepage;
    TestUtils testUtil;
    ContactsPage contactspage;

    public HomePageTest()
    {
        super();
    }
//    Test cases should be separated ie: independent of each other
//    before each test case, launch the browser and  login
//    Test-execute test case
//    After each test case-close the browser
//    Even if there are 1000s of test cases do the same

    @BeforeMethod
    public void setup()
    {
        initialization();
        testUtil=new TestUtils();
        loginpage=new LoginPage();
        homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyHomePageTitleTest()
    {
        String homepageTitle=homepage.verifyHomepageTitle();
        Assert.assertEquals(homepageTitle,"CRMPRO","Homepage title not matched");
    }

    @Test(priority = 2)
    public void verifyUsernameTest()
    {
        testUtil.switchToFrame();
        Assert.assertTrue(homepage.verifyCorrectUsername());
    }

    @Test(priority = 3)
    public void verifyContactsLinkTest()
    {
    testUtil.switchToFrame();
    contactspage=homepage.clickOnContactsLink();
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

}
