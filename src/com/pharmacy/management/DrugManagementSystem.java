package com.pharmacy.management;

import com.pharmacy.models.Drug;
import com.pharmacy.models.PurchaseHistory;
import com.pharmacy.models.PurchaseManager;
import com.pharmacy.models.SalesTracker;
import com.pharmacy.models.Supplier;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a DrugManagementSystem that allows the pharmacist
 * the manage the drugs and suppliers for the drugs as well as track drug 
 * purchases
 * 
 * @author Emmanuel Kofi Kwarteng
 */

public class DrugManagementSystem {
    // List to store Drug objects
    private List<Drug> drugs;
    // List to store Supplier objects
    private List<Supplier> suppliers;
    // Instantiating a variable for the SalesTracker class
    private SalesTracker salesTracker;
    // Instantiating a variable for the PurchaseManager class
    private PurchaseManager purchaseManager;

    // Constructor to initialize the drugs and suppliers list
    public DrugManagementSystem() {
        this.drugs = new ArrayList<>();
        this.suppliers = new ArrayList<>();
        this.salesTracker = new SalesTracker();
        this.purchaseManager = new PurchaseManager();
    }

    // Method to add a new drug
    public void addDrug(Drug drug) {
        // Check if the drug already exists (based on code)
        for (Drug existingDrug : drugs) {
            if (existingDrug.getCode().equals(drug.getCode())) {
                System.out.println("Drug with code " + drug.getCode() + " already exists.");
                return;
            }
        }
        // Add the drug to the list
        drugs.add(drug);
        System.out.println("Drug added successfully: " + drug);
    }

    // Method to add a new supplier
    public void addSupplier(Supplier supplier) {
        // Check if the supplier already exists (based on name and location)
        for (Supplier existingSupplier : suppliers) {
            if (existingSupplier.equals(supplier)) {
                System.out.println("Supplier " + supplier.getName() + " already exists.");
                return;
            }
        }
        // Add the supplier to the list
        suppliers.add(supplier);
        System.out.println("Supplier added successfully: " + supplier);
    }

    // Method to link a supplier to a drug
    public void linkSupplierToDrug(String drugCode, Supplier supplier) {
        Drug drug = searchDrugByCode(drugCode);
        if (drug != null) {
            drug.addSupplier(supplier);
            supplier.addSuppliedDrug(drug);
            System.out.println("Supplier " + supplier.getName() + " linked to drug " + drug.getName() + ".");
        } else {
            System.out.println("Drug with code " + drugCode + " not found.");
        }
    }

    // Method to search for a drug by code
    public Drug searchDrugByCode(String code) {
        for (Drug drug : drugs) {
            if (drug.getCode().equals(code)) {
                return drug;
            }
        }
        System.out.println("Drug with code " + code + " not found.");
        return null;
    }

    // Method to search for suppliers by location
    public List<Supplier> searchSuppliersByLocation(String location) {
        List<Supplier> result = new ArrayList<>();
        for (Supplier supplier : suppliers) {
            if (supplier.getLocation().equalsIgnoreCase(location)) {
                result.add(supplier);
            }
        }
        if (result.isEmpty()) {
            System.out.println("No suppliers found in location " + location + ".");
        }
        return result;
    }

    // Method to view suppliers for a specific drug by Drug Code
    public void viewSuppliersForDrug(String code) {
    Drug drug = searchDrugByCode(code);
    if (drug != null) {
        System.out.println("Suppliers for Drug: " + drug.getName());
        List<Supplier> drugSuppliers = drug.getSuppliers();
        if (drugSuppliers.isEmpty()) {
            System.out.println("No suppliers found for the given drug.");
        } else {
            int supplierCount = 0;
            for (Supplier supplier : drugSuppliers) {
                System.out.println("Supplier " + (++supplierCount) + ": ");
                System.out.println("Name: " + supplier.getName());
                System.out.println("Location: " + supplier.getLocation());
                System.out.println("Contact: " + supplier.getContact());
                System.out.println();
            }
        }
    } else {
        System.out.println("Drug not found in the system.");
    }
}


    // Method to view all drugs
    public void viewAllDrugs() {
        if (drugs.isEmpty()) {
            System.out.println("No drugs available in the system.");
        } else {
            System.out.println("Available drugs:");
            for (Drug drug : drugs) {
                System.out.println(drug);
            }
        }
    }

    public void trackSale(String drugCode) {
        Drug drug = searchDrugByCode(drugCode);
        if (drug != null) {
            salesTracker.trackSale(drugCode);

            // Record the sale in purchase history
            PurchaseHistory purchaseHistory = new PurchaseHistory(LocalDateTime.now());
            purchaseHistory.addPurchasedDrug(drug);
            purchaseManager.addPurchase(purchaseHistory);

            System.out.println("Sale tracked for drug: " + drug.getName());
        } else {
            System.out.println("Cannot track sale. Drug with code " + drugCode + " not found.");
        }
    }

    public void viewPurchaseHistoryByDrug(String drugCode) {
        Drug drug = searchDrugByCode(drugCode);
        if (drug != null) {
            List<PurchaseHistory> histories = purchaseManager.getPurchaseHistoriesByDrug(drug);
            if (histories.isEmpty()) {
                System.out.println("No purchase history found for drug: " + drug.getName());
            } else {
                System.out.println("Purchase history for drug: " + drug.getName());
                for (PurchaseHistory history : histories) {
                    history.displayPurchaseDetails();
                }
            }
        } else {
            System.out.println("Drug with code " + drugCode + " not found.");
        }
    }

    public void viewAllPurchaseHistories() {
        List<PurchaseHistory> histories = purchaseManager.getPurchaseHistories();
        if (histories.isEmpty()) {
            System.out.println("No purchase histories available.");
        } else {
            System.out.println("All purchase histories:");
            for (PurchaseHistory history : histories) {
                history.displayPurchaseDetails();
            }
        }
    }

    public void sortAndViewPurchaseHistoriesByDate() {
        List<PurchaseHistory> sortedHistories = purchaseManager.sortPurchaseHistoriesByDate();
        System.out.println("Purchase histories sorted by date:");
        for (PurchaseHistory history : sortedHistories) {
            history.displayPurchaseDetails();
        }
    }

    public void sortAndViewPurchaseHistoriesByAmount() {
        List<PurchaseHistory> sortedHistories = purchaseManager.sortPurchaseHistoriesByAmount();
        System.out.println("Purchase histories sorted by amount:");
        for (PurchaseHistory history : sortedHistories) {
            history.displayPurchaseDetails();
        }
    }

    // Main method for testing the DrugManagementSystem class
    public static void main(String[] args) {
        // Create an instance of DrugManagementSystem
        DrugManagementSystem drugManagementSystem = new DrugManagementSystem();

        // Create some Drug objects
        Drug drug1 = new Drug("Paracetamol", "001", 5.0);
        Drug drug2 = new Drug("Ibuprofen", "002", 10.0);
        Drug drug3 = new Drug("Amoxicillin", "003", 15.0);

        // Create some Supplier objects
        Supplier supplier1 = new Supplier("Supplier A", "New York", "123-456-7890");
        Supplier supplier2 = new Supplier("Supplier B", "Los Angeles", "987-654-3210");

        // Add drugs to the system
        drugManagementSystem.addDrug(drug1);
        drugManagementSystem.addDrug(drug2);
        drugManagementSystem.addDrug(drug3);

        // Add suppliers to the system
        drugManagementSystem.addSupplier(supplier1);
        drugManagementSystem.addSupplier(supplier2);

        // Link suppliers to drugs
        drugManagementSystem.linkSupplierToDrug("001", supplier1);
        drugManagementSystem.linkSupplierToDrug("002", supplier2);

        // View suppliers for a specific drug
        // drugManagementSystem.viewSuppliersForDrug("001");

        // Search for suppliers by location
        List<Supplier> suppliersInNY = drugManagementSystem.searchSuppliersByLocation("New York");
        if (!suppliersInNY.isEmpty()) {
            System.out.println("Suppliers in New York:");
            for (Supplier supplier : suppliersInNY) {
                System.out.println(supplier);
            }
        }

        // View all drugs
        // drugManagementSystem.viewAllDrugs();

        // Tracking sales
        drugManagementSystem.trackSale("001");
        drugManagementSystem.trackSale("003");
        drugManagementSystem.trackSale("001");

        // View purchase history for a specific drug
        drugManagementSystem.viewPurchaseHistoryByDrug("001");

        // View all purchase histories
        drugManagementSystem.viewAllPurchaseHistories();

        // Sort and view purchase histories by date
        drugManagementSystem.sortAndViewPurchaseHistoriesByDate();

        // Sort and view purchase histories by amount
        drugManagementSystem.sortAndViewPurchaseHistoriesByAmount();
    }
}
