import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PPLTool {

    public static void loginAccount(WebDriver driver, String username, String password) {
        /*
        * Logs into PPL Supplier Portal with given login details(username, password)
        */

        // direct to login page
        driver.get("https://supplier.prod.pplweb.com/eusupplierportal/login.aspx");

        WebElement userNameInput = driver.findElement(By.id("MainContent_LoginCtrl_UserName"));
        WebElement passwordInput = driver.findElement(By.id("MainContent_LoginCtrl_Password"));
        WebElement loginButton = driver.findElement(By.id("MainContent_LoginCtrl_LoginButton"));

        // login
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public static void retrieveAccountData(WebDriver driver, String accountNumber) {
        /*
        * Retrieves Monthly Usage of an Account Number
        */
        // redirect to "Request Monthly Usage" webpage
        driver.get("https://supplier.prod.pplweb.com/eusupplierportal/Secured/Retail/RequestMonthlyUsage.aspx");

        WebElement accountInput = driver.findElement(By.id("MainContent_macct_txtKyBa"));
        WebElement submitAccount = driver.findElement(By.id("MainContent_macct_btnAddAccount"));

        // enter account# and add account
        accountInput.sendKeys(accountNumber);
        submitAccount.click();

        // get usage
        WebElement getUsage = driver.findElement(By.id("MainContent_btnGetUsage"));
        getUsage.click();

    }

    public static void main(String[] args) {
        String loginUsername = "CBergerCE1";
        String loginPassword = "ces10038!";

        String accountNumber = "2087098013";

        ChromeDriver driver = new ChromeDriver();

        loginAccount(driver, loginUsername, loginPassword);
        retrieveAccountData(driver, accountNumber);
    }

}
