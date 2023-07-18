package com.capitalenergyservices;

import org.openqa.selenium.NoSuchElementException;
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

    public static void exportAccountData(Scanner reader, WebDriver driver) {
        /*
        * console prompt for downloading account usage xlsx file
        */

        System.out.print("Download account usage data as Excel file? (Y/N): ");
        String userInput = (reader.next()).toLowerCase();

        if (userInput.equals("y") || userInput.equals("yes")) {
            PPLTool.downloadUsageFile(driver);
        }
    }

    public static void greet() {
        System.out.println("\n" +
                " _____  _____  _____                _ ______                       __      _____ \n" +
                "/  __ \\|  ___||_   _|              | || ___ \\                     /  |    |  _  |\n" +
                "| /  \\/| |__    | |    ___    ___  | || |_/ /  ___  __  __ __   __`| |    | |/' |\n" +
                "| |    |  __|   | |   / _ \\  / _ \\ | || ___ \\ / _ \\ \\ \\/ / \\ \\ / / | |    |  /| |\n" +
                "| \\__/\\| |___   | |  | (_) || (_) || || |_/ /| (_) | >  <   \\ V / _| |_ _ \\ |_/ /\n" +
                " \\____/\\____/   \\_/   \\___/  \\___/ |_|\\____/  \\___/ /_/\\_\\   \\_/  \\___/(_) \\___/ \n" +
                "                                                                                 \n" +
                "                                                                                 \n");
        System.out.println("---------------------------------------");
        System.out.println("\nWelcome to CEToolBox v1.0!");
        System.out.println("...\n");
        printHelp();
    }


    public static void printHelp() {
        System.out.println("1: ECL PPL Tool\n" +
                            "2: SFE Margin Calculator\n" +
                                "q: Quit\n" +
                                    "h: Show all commands");
    }


    public static void main(String[] args) {

        try {
            Scanner reader = new Scanner(System.in);

            greet();
            String userInput = "";
            label:
            while(!(userInput.equalsIgnoreCase("q"))) {
                System.out.print("Enter a command (h for help): ");
                try {
                    userInput = (reader.nextLine()).toLowerCase();
                    switch (userInput) {
                        case "1":
                            ECLToolPPL.executeProgram(reader);
                            break;
                        case "2":
                            Calculator.executeFeeProgram(reader);
                            break;
                        case "h":
                            printHelp();
                            break;
                        case "q":
                            break label;
                        default:
                            System.out.println("Invalid command! (h for help)");
                            break;
                    }
                } catch (NoSuchElementException nsee) {
                    System.out.println("Invalid command! (h for help)");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            reader.close();
            System.out.println("\nThank you for using CEToolBox!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.exit(0);

    }
}
