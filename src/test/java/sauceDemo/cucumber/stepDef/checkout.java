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

public class checkout {
    WebDriver driver; // set driver for test using webdriver selenium
    String baseUrl = "https://www.saucedemo.com/"; // set base url

    public checkout() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @Given("User already add {int} product")
    public void userAlreadyAddProduct(int arg0) {
        LoginFunction login = new LoginFunction();
        login.userLogin(this.driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    @When("User click checkout button")
    public void userClickCheckoutButton() {
        driver.findElement(By.id("checkout")).click();
    }

    @And("User input shipping info")
    public void userInputShippingInfo() {
        driver.findElement(By.id("first-name")).sendKeys("Novazira");
        driver.findElement(By.id("last-name")).sendKeys("A.F");
        driver.findElement(By.id("postal-code")).sendKeys("16452");
    }

    @And("User click continue button")
    public void userClickContinueButton() {
        driver.findElement(By.id("continue")).click();
    }

    @And("User see checkout overview")
    public void userSeeCheckoutOverview() {
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
    }

    @And("User click finish button")
    public void userClickFinishButton() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("User checkout complete")
    public void userCheckoutComplete() {
        driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText();
        driver.findElement(By.id("back-to-products")).click();
        driver.close();
    }
}
