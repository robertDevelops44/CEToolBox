public class Calculator {

    public static double calculateFee(double ourRate, double supplierRate, double utilityTaxPercentage) {
        /*
        * calculates the broker fee/margin given
        * ourRate - rate providing
        * supplierRate - rate given by supplier (w/tax)
        * utilityTaxPercentage - the utility tax percentage of the state */
        return (ourRate - supplierRate) * ((100-utilityTax)/100)
    }

}