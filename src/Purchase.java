import java.time.LocalDateTime;

public class Purchase {
    private String purchaseID;
    private Drug drugID;
    private Drug price;
    private Drug purchaseNo;
    private LocalDateTime dateTime;
    private String buyDetails;
    private double amount;

    public Purchase(String purchaseID, Drug drugID, Drug price, Drug purchaseNo, LocalDateTime dateTime, String buyerDetails, double amount){
        this.purchaseID = purchaseID;
        this.drugID = drugID;
        this.price = price;
        this.purchaseNo = purchaseNo;
        this.dateTime = dateTime;
        this.buyDetails = buyerDetails;
        this.amount = amount;
    }

    public String getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(String purchaseID) {
        this.purchaseID = purchaseID;
    }

    public Drug getDrugID() {
        return drugID;
    }

    public void setDrugID(Drug drugID) {
        this.drugID = drugID;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getBuyDetails() {
        return buyDetails;
    }

    public void setBuyDetails(String buyDetails) {
        this.buyDetails = buyDetails;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
