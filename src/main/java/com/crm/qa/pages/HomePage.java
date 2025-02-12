package com.crm.qa.pages;
import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase
{
    @FindBy(xpath="//td[contains(text(),'User: Gagan Khanna')]")
    @CacheLookup
    WebElement usernameLabel;

    @FindBy(xpath="//a[contains(text(),'Contacts')]")
    WebElement contactsLink;

    @FindBy(xpath="//a[contains(text(),'Deals')]")
    WebElement DealsLink;

    @FindBy(xpath="//a[contains(text(),'Tasks')]")
    WebElement TasksLink;

    @FindBy(xpath="//a[contains(text(),'New Contact')]")
    WebElement newContactLink;

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

    public void clickOnNewContactLink() throws InterruptedException
    {
        Actions action=new Actions(driver);
        action.moveToElement(contactsLink).build().perform();
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", newContactLink);
    }
}
