import java.util.*;
import java.util.function.Supplier;

public class PharmacyManagementSystem {
    private List<Drug> drugList;
    private Map<String, Supplier> suppliers;
    private Queue<Sale> sales;

    public PharmacyManagementSystem() {
        this.drugList = new LinkedList<>();
        this.suppliers = new HashMap<>();
        this.sales = new LinkedList<>();
    }

    public void addDrug(Drug drug) {
        drugList.add(drug);
    }

    public Drug searchDrug(String drugName) {
        for (Drug drug : drugList) {
            if (drug.getName().equalsIgnoreCase(drugName)) {
                return drug;
            }
        }
        return null;
    }

    public void viewAllDrugs() {
        for (Drug drug : drugList) {
            System.out.println("Drug ID: " + drug.getDrugID() + ", Name: " + drug.getName() + ", Stock: " + drug.getStock());
            System.out.println("Suppliers:");
            for (Supplier supplier : drug.getSupplier()) {
                System.out.println(" - " + Supplier.getName() + ", Location: " + supplier.getLocation() + ", Contact: " + supplier.getContactDetails());
            }
        }
    }

    public void viewPurchaseHistory(String drugID) {
        Drug drug = findDrugById(drugID);
        if (drug != null) {
            System.out.println("Purchase History for Drug: " + drug.getName());
            for (Purchase purchase : drug.getPurchaseHistory()) {
                System.out.println("Date: " + purchase.getDateTime() + ", Buyer: " + purchase.getBuyerDetails() + ", Amount: " + purchase.getAmount());
            }
        } else {
            System.out.println("Drug not found!");
        }
    }

    public void generateReports() {
        // Implement report generation logic
    }

    private Drug findDrugById(String drugID) {
        for (Drug drug : drugList) {
            if (drug.getDrugID().equals(drugID)) {
                return drug;
            }
        }
        return null;
    }
}
