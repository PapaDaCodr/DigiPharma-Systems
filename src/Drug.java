import java.util.LinkedList;
import java.util.List;

public class Drug {
    private String drugID;
    private String name;
    private int stock;
    private double price;
    private int quantity;
    private List<Supplier> supplier;
    private List<Purchase> purchase;

    public Drug(String drugID, String name, int stock, double price){
        this.drugID = drugID;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public Drug(String drugID, String name, int stock, double price, int quantity){
        this.drugID = drugID;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.quantity = quantity;
        this.supplier = new LinkedList<>();
        this.purchase = new LinkedList<>();
    }

    public String getDrugID() {
        return drugID;
    }

    public void setDrugID(String drugID) {
        this.drugID = drugID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Supplier> getSupplier() {
        return supplier;
    }

    public void setSupplier(List<Supplier> supplier) {
        this.supplier = supplier;
    }

    public List<Purchase> getPurchase() {
        return purchase;
    }

    public void setPurchaseHistory(List<Purchase> purchase) {
        this.purchase = purchase;
    }
}
