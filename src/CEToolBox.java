import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

public class CEToolBox {

    public static void loginPPL(Scanner reader, WebDriver driver) {
        /*
        * console prompt for PPL login information and login into PPL Supplier Portal
        */
        String loginUsername;
        String loginPassword;
        System.out.print("\nAll information entered will be deleted when the program exits\nEnter username: ");
        loginUsername = reader.next();
        System.out.print(("Enter password: "));
        loginPassword = reader.next();
        /*
        char[] passwordArray = System.console().readPassword("Enter password: ");
        loginPassword = new String(passwordArray);
        */

        PPLTool.loginAccount(driver, loginUsername, loginPassword);

    }

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        WebDriver driver = new ChromeDriver();

        loginPPL(reader, driver);

    }
}
