import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

public class Drug {
    private Drug drugID;
    private String name;
    private List<Supplier> supplier;
    private List<Customer> customer;
    private List<Purchase> purchaseHistory;
    private int stock;

    public Drug(Drug drugID, String name, List<Purchase> purchaseHistory, int stock){
        this.drugID = drugID;
        this.name = name;
        this.purchaseHistory = purchaseHistory;
        this.stock = stock;
        this.supplier = new LinkedList<>();
    }

    public String getDrugID(){
        return drugID;
    }

    public void setDrugID(String drugID){
        this.drugID = drugID;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name= name;
    }

    public List<Supplier> getSupplier(){
        return supplier;
    }

    public void addSupplier(Supplier supplier, String name, String location, String contactDetails) {
        Supplier newSupplier = new supplier(name, location, contactDetails);
        supplier.put(name, newSupplier);

        this.supplier = supplier;
    }

    public List<Customer> getCustomer(){
        return customer;
    }

    public void addCustomer(Customer customer){
        this.customer.add(customer);
    }

    public List<Purchase> getPurchaseHistory(){
        return purchaseHistory;
    }

    public void addPurchase(Purchase purchase){
        this.purchaseHistory.add(purchase);
    }

    public int getStock(){
        return stock;
    }

    public void setStock(int stock){
        this.stock = stock;
    }
}
