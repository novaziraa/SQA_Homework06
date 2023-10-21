package sauceDemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver; // set driver for test using webdriver selenium
    String baseUrl = "https://www.saucedemo.com/"; // set base url

    // Success Login
    @Given("User Open the Website")
    public void user_open_the_website(){
        WebDriverManager.chromedriver().setup(); //setup chrome driver automatically using web driver manager
        ChromeOptions opt = new ChromeOptions(); // create object to set up option for chrome driver
        opt.setHeadless(false); // set chrome driver to not using handless mode

        driver = new ChromeDriver(opt); // apply chrome driver setup to driver
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); // set timeout for web driver on waiting element
        //driver.manage().window().maximize(); // maximize window
        driver.get(baseUrl); //access base url
    }

    @When("User input valid username")
    public void user_input_valid_username() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("User input valid password")
    public void user_input_valid_password() {
       driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("User click Login Button")
    public void user_click_login_button() {
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }

    @Then("User redirect to dashboard page")
    public void user_redirect_to_dashboard_page() {
        driver.findElement(By.cssSelector("#header_container > div.primary_header > div.header_label > div"));
        driver.close();
//        driver.quit();
    }

// Failed Login
    @Given("User Open Website")
    public void user_open_website() {
        WebDriverManager.chromedriver().setup(); //setup chrome driver automatically using web driver manager
        ChromeOptions opt = new ChromeOptions(); // create object to set up option for chrome driver
        opt.setHeadless(false); // set chrome driver to not using handless mode

        driver = new ChromeDriver(opt); // apply chrome driver setup to driver
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); // set timeout for web driver on waiting element
        //driver.manage().window().maximize(); // maximize window
        driver.get(baseUrl); //access base url
    }

    @When("User input invalid username")
    public void user_input_invalid_username() {
        driver.findElement(By.id("user-name")).sendKeys("hello_world");
    }

    @And("User input invalid password")
    public void user_input_invalid_password() {
        driver.findElement(By.id("password")).sendKeys("1234567");
    }

    @And("click Login Button")
    public void click_login_button() {
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }

    @Then("Error message")
    public void error_message() {
        String errorLogin = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]")).getText();
//        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); // set timeout for web driver on waiting element
//        String errorLogin = String.valueOf(driver.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3 > button")));
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }
}
