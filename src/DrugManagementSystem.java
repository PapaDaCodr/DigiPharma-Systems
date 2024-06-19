import java.util.*;

/**
 * Represents a management system that gives the pharmacist the following features
 * 1. Add Drugs
 * 2. Search Drugs
 * 3. View Drugs
 * 4. View Supplier(s) of a Drug
 * 5. Track sales
 * 6. Write to sales file
 * 7. Generate Report
 *
 * @author Emmanuel Kwarteng
 * @group Synapse
 */

public class DrugManagementSystem {
    private Map<String, Drug> drugs;
    private Map<String, Supplier> suppliers;
    private PurchaseHistory purchaseHistory;
    private SalesTracker salesTracker;
    private ReportGenerator reportGenerator;

    public DrugManagementSystem(String salesFilePath) {
        this.drugs = new HashMap<>();
        this.suppliers = new HashMap<>();
        this.purchaseHistory = new PurchaseHistory();
        this.salesTracker = new SalesTracker(salesFilePath);
        this.reportGenerator = new ReportGenerator();
    }

    // Methods to add, search, and view drugs
    public void addDrug(Drug drug) {
        drugs.put(drug.getDrugID(), drug);
    }

    public void searchDrug(String name) {
        boolean drugFound = false;
        for (Drug drug : drugs.values()) {
            if (drug.getName().equalsIgnoreCase(name)) {
                System.out.println("DrugID: " + drug.getDrugID() + ", Name: " + drug.getName() + ", Price: " + drug.getPrice() + ", Stock: " + drug.getStock());
                drugFound = true;
                break;
            }
        }
        if (!drugFound) {
            System.out.println("Drug not available or out of stock!");
        }
    }

    public void viewDrugs() {
        for (Drug drug : drugs.values()) {
            System.out.println("DrugID: " + drug.getDrugID() + ", Name: " + drug.getName() + ", Price: " + drug.getPrice() + ", Stock: " + drug.getStock());
        }
    }

    // Methods to add, view, and search suppliers
    public void addSupplier(Supplier supplier) {
        suppliers.put(supplier.getName(), supplier);
    }

    public void viewSuppliersForDrug(String drugID) {
        Drug drug = drugs.get(drugID);
        if (drug != null) {
            System.out.println("Suppliers for Drug: " + drug.getName());
            int supplierCount = 0;
            for (Supplier supplier : suppliers.values()) {
                if (supplier.getDrugID().equals(drugID)) {
                    System.out.println("Supplier " + (++supplierCount) + ": ");
                    System.out.println("Name: " + supplier.getName());
                    System.out.println("Location: " + supplier.getLocation());
                    System.out.println("Contact: " + supplier.getContactDetails());
                    System.out.println();
                }
            }
            if (supplierCount == 0) {
                System.out.println("No suppliers found for the given drug.");
            }
        } else {
            System.out.println("Drug not found in the system.");
        }
    }

    public void searchSuppliersByLocation(String location) {
        int supplierCount = 0;
        System.out.println("Suppliers located in " + location + ":");
        for (Supplier supplier : suppliers.values()) {
            if (supplier.getLocation().equalsIgnoreCase(location)) {
                System.out.println("Supplier " + (++supplierCount) + ": ");
                System.out.println("Name: " + supplier.getName());
                System.out.println("Location: " + supplier.getLocation());
                System.out.println("Contact: " + supplier.getContactDetails());
                System.out.println("Drug: " + supplier.getDrugID());
                System.out.println();
            }
        }
        if (supplierCount == 0) {
            System.out.println("No suppliers found in the given location.");
        }
    }

    // Methods for sales tracking
    public void sellDrug(String drugID, int quantity) {
        Drug drug = drugs.get(drugID);
        if (drug != null && drug.getStock() >= quantity && quantity > 0) {
            System.out.println("Selling " + quantity + " units of " + drug.getName() + "...");
            drug.setQuantity(drug.getQuantity() - quantity);
            salesTracker.trackSale(drug, quantity);
        } else if (drug == null) {
            System.out.println("Drug not found in the system.");
        } else if (drug.getQuantity() < quantity) {
            System.out.println("Insufficient stock for " + drug.getName() + ". Only " + drug.getQuantity() + " units available.");
        } else {
            System.out.println("Invalid quantity. Please enter a positive number.");
        }
    }

    // Methods to view purchase history and generate reports
    public void viewPurchaseHistory(String drugID) {
        List<Purchase> purchases = purchaseHistory.getPurchases();
        for (Purchase purchase : purchases) {
            if (purchase.getDrugID().getDrugID().equals(drugID)) {
                System.out.println("Date: " + purchase.getDateTime() + ", Amount: " + purchase.getAmount());
            }
        }
    }

    public void generateReports() {
        reportGenerator.generatePurchaseHistoryReport(purchaseHistory.getPurchases());
        reportGenerator.generateSupplierReport(new ArrayList<>(suppliers.values()));
//        reportGenerator.generateSalesReport(new ArrayList<>(salesTracker.getSales()));
        reportGenerator.generateStockReport(new ArrayList<>(drugs.values()));
    }
}
