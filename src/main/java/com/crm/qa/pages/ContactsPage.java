package com.crm.qa.pages;
import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactsPage extends TestBase
{
    @FindBy(xpath="//td[contains(text(),'Contacts')]")
    WebElement contactsLabel;

    @FindBy(name="title")
    WebElement title;

    @FindBy(name="first_name")
    WebElement firstName;

    @FindBy(name="surname")
    WebElement lastName;

    @FindBy(name="client_lookup")
    WebElement companyName;

    @FindBy(xpath="//input[@type='submit' and @value='Save']")
    WebElement saveBtn;

    //initializing the page objects
    public ContactsPage()
    {
        PageFactory.initElements(driver,this);
    }

    //methods
    public boolean verifyContactsLabel()
    {
        return contactsLabel.isDisplayed();
    }

    public void selectContacts(String name)
    {
        driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"+
                "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
    }

    public void createNewContact(String titleName,String fName,String lName,String company) throws InterruptedException
    {
        //To select the title from dropdown
        Select s=new Select(title);
        s.selectByVisibleText(titleName);
        Thread.sleep(2000);
        firstName.sendKeys(fName);
        Thread.sleep(2000);
        lastName.sendKeys(lName);
        Thread.sleep(2000);
        companyName.sendKeys(company);
        Thread.sleep(2000);
        saveBtn.click();
        Thread.sleep(2000);
    }


}
