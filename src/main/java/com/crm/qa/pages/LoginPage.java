package com.crm.qa.pages;
import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase
{
    //define page factory / object repo for Login Page
    //defined 5 page factories/object repositories for login class
    @FindBy(name="username")
    WebElement username;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath="//input[@type='submit' and @value='Login']")
    WebElement loginBtn;

    @FindBy(xpath="//*[text()='Sign Up']")
    WebElement SignUpBtn;

    @FindBy(xpath="//img[@class='img-responsive']")
    WebElement crmLogo;

    //initialize the web elements/ OR
    public LoginPage()
    {
        PageFactory.initElements(driver, this);
    }

    //methods or actions to be performed on web elements

  public String validateLoginPageTitle()
  {
      return driver.getTitle();
  }

  public boolean validateCRMLogoImg()
  {
      return crmLogo.isDisplayed();
  }

  //As this method is landing on homepage, it will return the homepage object
  public HomePage login(String unm,String pwd)
  {
      username.sendKeys(unm);
      password.sendKeys(pwd);
      loginBtn.click();
      return new HomePage();
  }

}
