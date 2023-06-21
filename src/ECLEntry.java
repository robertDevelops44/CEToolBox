public class ECLEntry {

    private String accountNumber;
    private String annualUsage;
    private String accountName;
    private String serviceAddress;
    private String serviceCity;
    private String serviceZipCode;
    private String billingAddress;
    private String billingCity;
    private String billingZipCode;
    private String rateClass;

    public ECLEntry(String accountNumber, String annualUsage, String accountName, String serviceAddress, String serviceCity, String serviceZipCode, String billingAddress, String billingCity, String billingZipCode, String rateClass) {
        this.accountNumber = accountNumber;
        this.annualUsage = annualUsage;
        this.accountName = accountName;
        this.serviceAddress = serviceAddress;
        this.serviceCity = serviceCity;
        this.serviceZipCode = serviceZipCode;
        this.billingAddress = billingAddress;
        this.billingCity = billingCity;
        this.billingZipCode = billingZipCode;
        this.rateClass = rateClass;
    }

    public ECLEntry(){

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
        String formattedECL = String.format("Account#: %s\n%s kWh/year\nService Address: %s %s %s\nBilling Address: %s %s %s\n%s",accountNumber, annualUsage, accountName, serviceAddress, serviceCity, serviceZipCode, billingAddress, billingCity, billingZipCode, rateClass);

        return formattedECL;
    }
}
