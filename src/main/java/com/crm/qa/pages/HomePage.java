package com.crm.qa.pages;
import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase
{

    @FindBy(xpath="//td[contains(text(),'User: Gagan Khanna')]")
    WebElement usernameLabel;

    @FindBy(xpath="//a[contains(text(),'Contacts')]")
    WebElement contactsLink;

    @FindBy(xpath="//a[contains(text(),'Deals')]")
    WebElement DealsLink;

    @FindBy(xpath="//a[contains(text(),'Tasks')]")
    WebElement TasksLink;

public HomePage()
{
    PageFactory.initElements(driver,this);
}

    //methods
    public String verifyHomepageTitle()
    {
        return driver.getTitle();
    }

    public boolean verifyCorrectUsername()
    {
        return usernameLabel.isDisplayed();
    }

    public ContactsPage clickOnContactsLink()
    {
        contactsLink.click();
        return new ContactsPage();
    }

    public DealsPage clickOnDealsLink()
    {
        DealsLink.click();
        return new DealsPage();
    }

    public TasksPage clickOnTasksLink()
    {
        TasksLink.click();
        return new TasksPage();
    }



}
