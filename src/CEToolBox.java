import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Scanner;

public class CEToolBox {

    public static void loginPPL(Scanner reader, WebDriver driver) {
        /*
        * console prompt for PPL login information and login into PPL Supplier Portal
        */
        System.out.print("\nAll information entered will be deleted when the program exits\nEnter username: ");
        String loginUsername = reader.nextLine();
        System.out.print(("Enter password: "));
        String loginPassword = reader.nextLine();

        try {
            PPLTool.loginAccount(driver, loginUsername, loginPassword);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getAccountDataPPL(Scanner reader, WebDriver driver) {
        /*
         * console prompt for PPL account data retrieval
         */
        System.out.print("Enter account number: ");
        String accountNumber = reader.nextLine();

        try {
            PPLTool.retrieveAccountData(driver,accountNumber);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        try {
            Scanner reader = new Scanner(System.in);

            WebDriver driver = new ChromeDriver();

            loginPPL(reader, driver);
            getAccountDataPPL(reader, driver);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
