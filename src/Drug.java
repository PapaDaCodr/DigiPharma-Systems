import java.util.LinkedList;
import java.util.List;

/**
 * Demonstrates the use of the Drug Management System.
 *
 * @author Emmanuel Kwarteng
 * @group Synapse
 */

public class Drug {
    private String drugID;
    private String name;
    private int stock;
    private double price;
    private int quantity;
    private List<Supplier> supplier;
    private List<Purchase> purchase;

    /**
     * Construct Drug with the following information;
     * @param drugID the id of the drug
     * @param name the name of the drug
     * @param stock the number of drugs available
     * @param price the price the drug goes for
     */
    public Drug(String drugID, String name, int stock, double price){
        this.drugID = drugID;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    /**
     Construct Drug with the following information;
     * @param drugID the id of the drug
     * @param name the name of the drug
     * @param stock the number of drugs available
     * @param price the price the drug goes for
     * @param quantity the amount the customer is purchasing
     */
    public Drug(String drugID, String name, int stock, double price, int quantity){
        this.drugID = drugID;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.quantity = quantity;
        this.supplier = new LinkedList<>();
        this.purchase = new LinkedList<>();
    }

    /**
     * Returns the DrugID.
     * @return the DrugID
     */
    public String getDrugID() {
        return drugID;
    }

    /**
     * Sets the DrugID
     * @param drugID the new DrugID
     */
    public void setDrugID(String drugID) {
        this.drugID = drugID;
    }

    /**
     * Returns the Name of the drug
     * @return the name of the drug
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the Name of th Drug
     * @param name tge new name of the Drug
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the number of drugs in inventory
     * @return the number of drugs in inventory
     */
    public int getStock() {
        return stock;
    }

    /**
     * Sets the Stock number of a drug
     * @param stock the new Stock number of a drug
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Returns the price of the Drug
     * @return the price of the drug
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the Drug
     * @param price the new price of the Drug
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns the Quantity the customer would like to buy
     * @return the quantity the customer would like to buy
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the Quantity the cutomer wouild like buy
     * @param quantity the new quantity the customer is buying
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns the Supplier of the Drug
     * @return the supplier of the Drug
     */
    public List<Supplier> getSupplier() {
        return supplier;
    }

    /**
     * Sets the Suppier of the Drug
     * @param supplier the new supplier of the Drug
     */
    public void setSupplier(List<Supplier> supplier) {
        this.supplier = supplier;
    }

    /**
     * Returns the
     * @return
     */
    public List<Purchase> getPurchase() {
        return purchase;
    }

    public void setPurchase(List<Purchase> purchase) {
        this.purchase = purchase;
    }
}
