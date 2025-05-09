package com.crm.qa.testcases;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase
{
LoginPage loginpage;
HomePage homepage;
ContactsPage contactsPage;
TestUtils testUtil;
String sheetName="Contacts";

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
       contactsPage.selectContacts("Aarav Sharma");
    }

    @Test(priority = 3)
    public void selectMultipleContactsTest()
    {
        contactsPage.selectContacts("Aakash Nagre");
        contactsPage.selectContacts("aa bb");
    }

    @DataProvider
    public Object[][] getCRMTestData()
    {
       Object[][] data=TestUtils.getTestData(sheetName);
       return data;
    }

    @Test(priority = 4,dataProvider ="getCRMTestData")
    public void validateCreateNewContact(String title,String firstname,String lastname,String company) throws InterruptedException
    {
        homepage.clickOnNewContactLink();
        contactsPage.createNewContact(title,firstname,lastname,company);
        //Assertion
        homepage.clickOnContactsLink();
        //WebElement checkContact=driver.findElement(By.name("0TestAutoFname 0TestAutoLname"));
        WebElement checkContact=driver.findElement(By.xpath("//table//td//a[contains(text(),'0TestAutoFname 0TestAutoLname')]"));
        Assert.assertTrue(checkContact.isDisplayed(), "No such record present");
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
