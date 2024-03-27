package com.heroku.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.heroku.app.baseClasses.BasePage;

public class LoginPage extends BasePage{
    
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(id = "txt-username")
    public WebElement userName;

    @FindBy(id = "txt-password")
    public WebElement userPassword;

    public void setUserName(String username){
        userName.sendKeys(username);
    }

    public void setUserPassword(String password){
        userPassword.sendKeys(password);
    }

}
