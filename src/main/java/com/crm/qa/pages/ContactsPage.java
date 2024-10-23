package com.crm.qa.pages;
import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
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
}
