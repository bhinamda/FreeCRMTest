package com.crm.qa.pages;
import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends TestBase
{

    @FindBy(xpath="//td[contains(text(),'Contacts')]")
    WebElement contactsLabel;


    //initializing the page objects
    public ContactsPage()
    {
        PageFactory.initElements(driver,this);
    }


    public boolean verifyContactsLabel()
    {
        return contactsLabel.isDisplayed();
    }

    public void selectContacts()
    {

    }
}
