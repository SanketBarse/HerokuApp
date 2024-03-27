package com.heroku.app.TestClasses;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.heroku.app.baseClasses.BasePage;
import com.heroku.app.baseClasses.ExcelControl;
import com.heroku.app.pages.Home;
import com.heroku.app.pages.LoginPage;

public class Test1 {
    

     @Test(dataProvider = "loginData")
    public void TestMethod(String username, String password){
        BasePage page = new BasePage();
        Home home = page.involkeBrowser();
        LoginPage loginPage = home.clickMakeAppointment();
        loginPage.setUserName(username);
        loginPage.setUserPassword(password);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        loginPage.tearDown();
    }



    @DataProvider(name="loginData")
    public Object[][] LoginData(){
        ExcelControl data = new ExcelControl();
        return data.getLoginData();
    }



}
