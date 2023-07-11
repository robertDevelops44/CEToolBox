package main.java.com.capitalenergyservices;

public class ECLEntry {

    private String months;
    private String accountNumber;
    private String annualUsage;
    private String accountName;
    private String serviceAddress;
    private String serviceCity;
    private String serviceState;
    private String serviceZipCode;
    private String billingAddress;
    private String billingCity;
    private String billingState;
    private String billingZipCode;
    private String rateClass;

    public ECLEntry(String months, String accountNumber, String annualUsage, String accountName, String serviceAddress, String serviceCity, String serviceState, String serviceZipCode, String billingAddress, String billingCity, String billingState, String billingZipCode, String rateClass) {
        this.months = months;
        this.accountNumber = accountNumber;
        this.annualUsage = annualUsage;
        this.accountName = accountName;
        this.serviceAddress = serviceAddress;
        this.serviceCity = serviceCity;
        this.serviceState = serviceState;
        this.serviceZipCode = serviceZipCode;
        this.billingAddress = billingAddress;
        this.billingCity = billingCity;
        this.billingState = billingState;
        this.billingZipCode = billingZipCode;
        this.rateClass = rateClass;
    }

    public String getMonths() {
        return months;
    }

    public void setMonths(String months) {
        this.months = months;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAnnualUsage() {
        return annualUsage;
    }

    public void setAnnualUsage(String annualUsage) {
        this.annualUsage = annualUsage;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }

    public String getServiceCity() {
        return serviceCity;
    }

    public void setServiceCity(String serviceCity) {
        this.serviceCity = serviceCity;
    }

    public String getServiceState() {
        return serviceState;
    }

    public void setServiceState(String serviceState) {
        this.serviceState = serviceState;
    }

    public String getServiceZipCode() {
        return serviceZipCode;
    }

    public void setServiceZipCode(String serviceZipCode) {
        this.serviceZipCode = serviceZipCode;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    public String getBillingZipCode() {
        return billingZipCode;
    }

    public void setBillingZipCode(String billingZipCode) {
        this.billingZipCode = billingZipCode;
    }

    public String getRateClass() {
        return rateClass;
    }

    public void setRateClass(String rateClass) {
        this.rateClass = rateClass;
    }

    @Override
    public String toString() {
        String formattedECL = String.format("%s\n\nAccount#: %s\n%s kWh/year\nService Address: %s %s %s %s\nBilling Address: %s %s %s %s\n%s",accountName,accountNumber, annualUsage, serviceAddress, serviceCity, serviceState, serviceZipCode, billingAddress, billingCity, billingState, billingZipCode, rateClass);

        return formattedECL;
    }
}
