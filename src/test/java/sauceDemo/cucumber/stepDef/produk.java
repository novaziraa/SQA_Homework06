package sauceDemo.cucumber.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import sauceDemo.cucumber.helper.LoginFunction;

import java.time.Duration;

public class produk {
    WebDriver driver; // set driver for test using webdriver selenium
    String baseUrl = "https://www.saucedemo.com/"; // set base url

    public produk() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @Given("User already on dashboard")
    public void user_already_on_dashboard() {
        LoginFunction login = new LoginFunction();
        login.userLogin(this.driver);
    }

    @When("User click product name")
    public void user_click_product_name() {
        driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).click();
    }

    @Then("User see product details")
    public void user_see_product_details() {
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div")).getText();
        driver.close();
    }
}
