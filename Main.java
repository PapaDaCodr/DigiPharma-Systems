import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        PharmacyManagementSystem pharmacy = new PharmacyManagementSystem();

        // Adding Suppliers
        Supplier supplier1 = new Supplier("Supplier1", "Location1", "Contact1");
        Supplier supplier2 = new Supplier("Supplier2", "Location2", "Contact2");

        // Adding Drugs
        Drug drug1 = new Drug("D001", "Paracetamol", 100);
        drug1.addSupplier(supplier1);
        drug1.addSupplier(supplier2);

        Drug drug2 = new Drug("D002", "Ibuprofen", 50);
        drug2.addSupplier(supplier1);

        pharmacy.addDrug(drug1);
        pharmacy.addDrug(drug2);

        // Adding Purchase History
        Purchase purchase1 = new Purchase(LocalDateTime.now(), "Buyer1", 20.0);
        drug1.addPurchase(purchase1);

        // Viewing All Drugs
        pharmacy.viewAllDrugs();

        // Viewing Purchase History
        pharmacy.viewPurchaseHistory("D001");

        // Searching for a Drug
        Drug searchedDrug = pharmacy.searchDrug("Ibuprofen");
        if (searchedDrug != null) {
            System.out.println("Found drug: " + searchedDrug.getName());
        } else {
            System.out.println("Drug not found!");
        }
    }
}
