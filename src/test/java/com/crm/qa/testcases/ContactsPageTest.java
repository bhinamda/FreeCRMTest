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

public class ContactsPageTest extends TestBase
{
LoginPage loginpage;
HomePage homepage;
ContactsPage contactsPage;
TestUtils testUtil;

    public ContactsPageTest()
    {
        super();
    }

    @BeforeMethod
    public void setup()
    {
        initialization();
        testUtil=new TestUtils();
        loginpage=new LoginPage();
       // contactsPage=new ContactsPage();
        homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
        testUtil.switchToFrame();
        contactsPage=homepage.clickOnContactsLink();
    }

    @Test(priority = 1)
    public void verifyContactsPageLabel()
    {
        Assert.assertTrue(contactsPage.verifyContactsLabel(),"Contacts label is missing on the page");
    }

    @Test(priority = 2)
    public void selectSingleContactsTest()
    {
       contactsPage.selectContacts("Aamy Tom");
    }

    @Test(priority = 3)
    public void selectMultipleContactsTest()
    {
        contactsPage.selectContacts("Aamy Tom");
        contactsPage.selectContacts("AFname1 ALname1");
    }

    @Test
    public void validateCreateNewContact() throws InterruptedException
    {
        homepage.clickOnNewContactLink();
        contactsPage.createNewContact("Mr.","0Test1","0Test1","0Company1");
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
