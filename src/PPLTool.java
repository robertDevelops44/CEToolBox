import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PPLTool {

    public void loginAccount(WebDriver driver, String username, String password) {
        /*
        * Logs into PPL Supplier Portal with given login details(username, password)
        */

        // direct to login page
        driver.get("https://supplier.prod.pplweb.com/eusupplierportal/login.aspx");

        WebElement userNameInput = driver.findElement(By.id("MainContent_LoginCtrl_UserName"));
        WebElement passwordInput = driver.findElement(By.id("MainContent_LoginCtrl_Password"));
        WebElement loginButton = driver.findElement(By.id("MainContent_LoginCtrl_LoginButton"));

        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

}
