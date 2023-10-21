package sauceDemo.cucumber.stepDef;

import io.cucumber.java.en.And;
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

public class cart {
    WebDriver driver; // set driver for test using webdriver selenium
    String baseUrl = "https://www.saucedemo.com/"; // set base url

    public cart() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @Given("User on dashboard")
    public void user_on_dashboard() {
        LoginFunction login = new LoginFunction();
        login.userLogin(this.driver);
    }

    @When("User click add to chart button")
    public void user_click_add_to_chart_button() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @And("User click cart icon")
    public void user_click_cart_icon() {
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    @Then("User redirect to cart page")
    public void user_redirect_to_cart_page() {
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        driver.close();
    }
}
