package com.capitalenergyservices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SugarCRMTool {

    public static boolean loginAccount(WebDriver driver, String username, String password) {
        /*
         * Logs into PPL Supplier Portal with given login details(username, password)
         */
        try {
            // direct to login page
            String loginURL = "https://capenergy.sugarondemand.com";
            driver.get(loginURL);

            WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driverWait.until(ExpectedConditions.urlContains("login-us-west-2.service.sugarcrm.com"));

            WebElement userNameInput = driver.findElement(By.id("username"));
            WebElement passwordInput = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("submit_btn"));

            // login
            System.out.println("Logging in...");
            userNameInput.sendKeys(username);
            passwordInput.sendKeys(password);
            loginButton.click();

            String currentURL = driver.getCurrentUrl();
            if (currentURL.equals(loginURL)) {
                System.out.println("Invalid Login");
                return false;
            } else {
                System.out.println("Successfully logged in!");
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        String loginUsername = "rhuang";
        String loginPassword = "area51again";

        ChromeDriver driver = new ChromeDriver();
        loginAccount(driver, loginUsername, loginPassword);
        driver.get("https://capenergy.sugarondemand.com/#Leads");
        TimeUnit.SECONDS.sleep(7);
        TimeUnit.SECONDS.sleep(2);
        WebElement pageCountButton = driver.findElement(By.name("page-count"));
        pageCountButton.click();
        while(true) {
            WebElement selectAllButton = driver.findElement(By.className("toggle-all"));

            selectAllButton.click();
            WebElement nextPageButton = driver.findElement(By.cssSelector("#content > div > div > div.main-pane.span8.flex.flex-column > div.pipeline-refresh-btn.flex.flex-column.h-full > div.main-content > div.paginated-flex-list > div.flex-table-pagination > div > div > button.btn.paginate-next"));

            nextPageButton.click();
            TimeUnit.SECONDS.sleep(3);
        }
    }

}
