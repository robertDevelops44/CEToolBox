package com.capitalenergyservices;

import java.util.Scanner;

public class Calculator {

    public static double calculateFee(double ourRate, double supplierRate, double utilityTaxPercentage) {
        /*
        * calculates the broker fee/margin given
        * ourRate - rate providing
        * supplierRate - rate given by supplier (w/tax)
        * utilityTaxPercentage - the utility tax percentage of the state */
        return (ourRate - supplierRate) * ((100-utilityTaxPercentage)/100);
    }

    public static void executeFeeProgram(Scanner reader) {
        System.out.println("Loading margin calculator...");
        double ourRate;
        double supplierRate;
        double utilityTaxPercentage;
        try {
            System.out.print("Please enter your rate: ");
            ourRate = reader.nextDouble();
            System.out.print("Please enter the supplier's rate(w/tax): ");
            supplierRate = reader.nextDouble();
            System.out.print("Please enter the state's utility tax percentage: ");
            utilityTaxPercentage = reader.nextDouble();
        } catch(Exception e) {
            System.out.print("Error! Invalid input! Please try again!");
            return;
        }
        double fee = calculateFee(ourRate,supplierRate,utilityTaxPercentage);
        System.out.printf(String.format("The broker fee is: %.6f",fee));
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        executeFeeProgram(reader);
        reader.close();
        System.exit(0);
    }

}