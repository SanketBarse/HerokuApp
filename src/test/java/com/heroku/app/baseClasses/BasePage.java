package com.heroku.app.baseClasses;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.heroku.app.pages.Home;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
    
    public WebDriver driver;
    private FileInputStream inputStream;
    private Properties prop;
    private File file;
    private WebDriverWait wait;
    private String browser;


    public BasePage(){
        try{
            file = new File(System.getProperty("user.dir")+File.separator+"src\\test\\java\\com\\heroku\\app\\Utility\\util.properties");
            inputStream = new FileInputStream(file);
            prop = new Properties();
            prop.load(inputStream);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Home involkeBrowser(){
        browser = prop.getProperty("browser"); 

        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        return PageFactory.initElements(driver, Home.class);
    }

    public WebDriverWait getWait(){
        if(wait==null){
            wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        }
        return wait;
    }

    public void tearDown(){
        driver.close();
    }




}
