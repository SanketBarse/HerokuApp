package com.heroku.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.heroku.app.baseClasses.BasePage;

public class Home extends BasePage{

    public Home(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(id = "btn-make-appointment")
    private WebElement makeAppointmentButton;
    
    public LoginPage clickMakeAppointment(){
        makeAppointmentButton.click();
        return PageFactory.initElements(driver, LoginPage.class);
    }

}
