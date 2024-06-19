/**
 * Demonstrates the use of the Drug Management System.
 *
 * @author Emmanuel Kwarteng
 * @group Synapse
 */

public class Main {
    public static void main(String[] args) {
        DrugManagementSystem dms = new DrugManagementSystem("sales.txt");

        // Example usage
        Drug drug1 = new Drug("001", "Paracetamol", 5, 100.00);
        Drug drug2 = new Drug("002", "Ibuprofen", 3, 10.20);
        Drug drug3 = new Drug("003", "Malaris", 6, 34.50);
        Drug drug4 = new Drug("004", "Pentol", 3, 134.60);
        Drug drug5 = new Drug("005", "Fentnol", 2, 90.50);
        dms.addDrug(drug1);
        dms.addDrug(drug2);
        dms.addDrug(drug3);
        dms.addDrug(drug4);
        dms.addDrug(drug5);

        Supplier supplier1 = new Supplier("Supplier A", "Location A", "Contact A", "002", "002");
        Supplier supplier2 = new Supplier("Supplier B", "Location B", "Contact D", "001");
        Supplier supplier3 = new Supplier("Supplier C", "Location C", "Contact D", "002");
        Supplier supplier4 = new Supplier("Supplier D", "Location D", "Contact D", "003");
        Supplier supplier5 = new Supplier("Supplier E", "Location E", "Contact E", "002");
        dms.addSupplier(supplier1);
        dms.addSupplier(supplier2);
        dms.addSupplier(supplier3);
        dms.addSupplier(supplier4);
        dms.addSupplier(supplier5);

//        dms.viewDrugs();
//        dms.viewSuppliersForDrug("002");
//        dms.viewSuppliersForDrug("003");
//        dms.viewSuppliersForDrug("002");
//        dms.searchDrug("Pentol");
//        dms.searchSuppliersByLocation("Contact D");
//        dms.sellDrug("002", 20);
//        dms.sellDrug("002", 2);
//        dms.viewPurchaseHistory("002");
    }
}