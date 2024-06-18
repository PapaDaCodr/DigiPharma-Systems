import java.time.LocalDateTime;

public class Sale {
    private String drugID;
    private LocalDateTime saleDateTime;

    public Sale(String drugID, LocalDateTime saleDateTime) {
        this.drugID = drugID;
        this.saleDateTime = saleDateTime;
    }

    // Getters and Setters
    public String getDrugID() {
        return drugID;
    }

    public void setDrugID(String drugID) {
        this.drugID = drugID;
    }

    public LocalDateTime getSaleDateTime() {
        return saleDateTime;
    }

    public void setSaleDateTime(LocalDateTime saleDateTime) {
        this.saleDateTime = saleDateTime;
    }
}
