import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PPLTool {

    public static boolean loginAccount(WebDriver driver, String username, String password) {
        /*
        * Logs into PPL Supplier Portal with given login details(username, password)
        */
        try {
            // direct to login page
            String loginURL = "https://supplier.prod.pplweb.com/eusupplierportal/login.aspx";
            driver.get("https://supplier.prod.pplweb.com/eusupplierportal/login.aspx");

            WebElement userNameInput = driver.findElement(By.id("MainContent_LoginCtrl_UserName"));
            WebElement passwordInput = driver.findElement(By.id("MainContent_LoginCtrl_Password"));
            WebElement loginButton = driver.findElement(By.id("MainContent_LoginCtrl_LoginButton"));

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

    public static boolean retrieveAccountData(WebDriver driver, String accountNumber) {
        /*
        * Retrieves Monthly Usage of an Account Number
        * Pre req: must be logged into PPL Supplier portal - execute loginAccount prior to adding account
        */
        try {
            // redirect to "Request Monthly Usage" webpage
            driver.get("https://supplier.prod.pplweb.com/eusupplierportal/Secured/Retail/RequestMonthlyUsage.aspx");

            WebElement accountInput = driver.findElement(By.id("MainContent_macct_txtKyBa"));
            WebElement submitAccount = driver.findElement(By.id("MainContent_macct_btnAddAccount"));

            // enter account# and add account
            System.out.println("Adding account...");
            accountInput.sendKeys(accountNumber);
            submitAccount.click();

            // get usage
            System.out.println("Getting usage...");
            WebElement getUsage = driver.findElement(By.id("MainContent_btnGetUsage"));
            if(getUsage.isEnabled()) {
                getUsage.click();
                System.out.println("Successfully retrieved data!");
                return true;
            } else {
                System.out.println("Error adding account");
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean downloadUsageFile(WebDriver driver) {
        /*
        * Downloads excel file containing account monthly usage data
        * Pre req: page must be displaying all usage data - execute retrieveAccountData prior to exporting data
        */

        System.out.println("Downloading file...");
        try {
            WebElement exportToExcel = driver.findElement(By.id("MainContent_repMUData_btnExport_0"));
            exportToExcel.click();
            System.out.println("Successfully downloaded file!");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public static void main(String[] args) {
        /*
        * FOR TESTING PURPOSES ONLY
        */
        String loginUsername = "CBergerCE1";
        String loginPassword = "ces10038!";

        String accountNumber = "208708013";

        ChromeDriver driver = new ChromeDriver();
        if(loginAccount(driver, loginUsername, loginPassword)) {
            if(retrieveAccountData(driver, accountNumber)) {
                downloadUsageFile(driver);
            }
        }

    }

}
