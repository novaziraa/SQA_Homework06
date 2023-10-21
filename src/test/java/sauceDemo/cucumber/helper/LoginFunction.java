package sauceDemo.cucumber.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFunction {
    public String baseUrl = "https://www.saucedemo.com/";

    public void userLogin(WebDriver driver) {
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }
}
