import java.time.LocalDateTime;

public class Purchase {
    private LocalDateTime dateTime;
    private String buyerDetails;
    private double amount;

    public Purchase(LocalDateTime dateTime, String buyerDetails, double amount) {
        this.dateTime = dateTime;
        this.buyerDetails = buyerDetails;
        this.amount = amount;
    }

    // Getters and Setters
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getBuyerDetails() {
        return buyerDetails;
    }

    public void setBuyerDetails(String buyerDetails) {
        this.buyerDetails = buyerDetails;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
