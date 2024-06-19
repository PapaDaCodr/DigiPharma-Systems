import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class SalesTracker {
    private String salesFilePath;
    private String sales;

    public SalesTracker(String salesFilePath, String sales) {
        this.salesFilePath = salesFilePath;
        this.sales = sales;
    }

    public SalesTracker(String salesFilePath) {
        this.salesFilePath = salesFilePath;
    }

    public void trackSale(Drug drug, int quantity) {
        try (FileWriter writer = new FileWriter(salesFilePath, true)) {
            writer.write(drug.getDrugID() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }
}
