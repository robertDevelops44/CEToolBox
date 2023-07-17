package com.capitalenergyservices;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;


public class ECLToolPPL {

    private static final String accountInfoFilePath = "data/Account_Information_PPL.xlsx";
    private static final Map<String, Integer> sheetColumns = new HashMap<>();
    private static Sheet currentSheet;
    public static ECLEntry parseInfoFile(int row) {
        /*
        * parses entry from excel file on the inputted row number
        */
        row--;
        File file = new File(accountInfoFilePath);
        try (var workbooks = WorkbookFactory.create(file)) {
            currentSheet = workbooks.getSheet("Sheet1");
            currentSheet.getRow(0).forEach(cell -> sheetColumns.put(cell.getStringCellValue(), cell.getColumnIndex()));

            String months = getCellData("Months", row);
            String accountNumber = getCellData("ACCOUNT NO.", row);
            String annualUsage = getCellData("KWh/Year", row);
            String accountName = getCellData("ACCOUNT NAME", row);
            String accountName2 = getCellData("ALINE 2", row);
            String serviceAddress = getCellData("SERVICE ADDRESS LINE 1", row);
            String serviceAddress2 = getCellData("SLINE 2", row);
            String serviceCity = getCellData("SERVICE CITY", row);
            String serviceState = getCellData("SSTATE", row);
            String serviceZipCode = getCellData("SERVICE ZIP", row);
            String billingAddress = getCellData("BILL ADDRESS", row);
            String billingAddress2 = getCellData("BLINE 2", row);
            String billingCity = getCellData("BILL CITY", row);
            String billingState = getCellData("BSTATE", row);
            String billingZipCode = getCellData("BZIP", row);
            String rateClass = getCellData("RATE CLASS", row);

            accountName += " " + accountName2;
            serviceAddress += " " + serviceAddress2;
            billingAddress += " " + billingAddress2;

            return new ECLEntry(months, accountNumber, annualUsage, accountName, serviceAddress, serviceCity, serviceState, serviceZipCode, billingAddress, billingCity, billingState, billingZipCode, rateClass);
            } catch(Exception e) {
                e.printStackTrace();
                return null;
        }
    }

    public static String getCellData(String column, int row) {
        /*
        * retrieves data from an excel sheet cell
        */
        var dataRow = currentSheet.getRow(row);
        return getCellDataAsString(dataRow.getCell(sheetColumns.get(column)));
    }

    public static String getCellDataAsString(Cell cell) {
        /*
        * parses/converts cell data into string format
        */
        String cellString;
        try {
            switch (cell.getCellType()) {
                case STRING:
                    cellString = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    cellString = String.valueOf((int) cell.getNumericCellValue());
                    break;
                default:
                    cellString = "";
                    break;
            }

        } catch (NullPointerException e) {
            cellString = "";
        }
        return cellString;
    }

    public static void executeProgram(Scanner reader) throws FileNotFoundException {
        /*
        * runs main program for ECL and PPL Portal tools with Command-Line-Interface
        */

        /*
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920, 1080");
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        */
        System.out.println("Loading Tool...");
        WebDriver driver = new ChromeDriver();    // comment out and replace with comment block above for headless browser
        System.out.println();
        PPLTool.parseLoginCSV();
        PPLTool.loginAccount(driver,PPLTool.loginUsername, PPLTool.loginPassword);
        int rowInput = -1;
        while(rowInput != 0) {
            System.out.print("Enter row number (0 to quit): ");
            try {
                rowInput = reader.nextInt();
                if(rowInput == 0) {
                    System.out.println("Goodbye!");
                    driver.quit();
                    reader.close();
                    System.exit(0);
                }
                System.out.println("Processing...Please wait...");
                ECLEntry entry = parseInfoFile(rowInput);
                String accountNumber = entry.getAccountNumber();

                if(PPLTool.retrieveAccountData(driver, accountNumber)) {
                    PPLTool.downloadUsageFile(driver);
                } else {
                    PPLTool.loginAccount(driver,PPLTool.loginUsername, PPLTool.loginPassword);
                    if(PPLTool.retrieveAccountData(driver, accountNumber)) {
                        PPLTool.downloadUsageFile(driver);
                    }
                }
                System.out.println("-----------------------");
                System.out.println(entry);
                System.out.println("-----------------------");
                System.out.println("Account processed! Current Row: " + rowInput);
            } catch(InputMismatchException ime) {
                System.out.println("!!! Invalid input, please enter a number !!!");
            } catch (NullPointerException npe) {
                System.out.println("!!! Invalid input, please enter a valid row number !!!");
            }

        }
        System.out.println("Exiting ECL Tool...");
        driver.quit();
    }


    public static void main(String[] args) throws FileNotFoundException {

        Scanner reader = new Scanner(System.in);
        executeProgram(reader);
        reader.close();
        System.exit(0);

    }
}
