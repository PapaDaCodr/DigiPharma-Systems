package com.pharmacy.management;

import com.pharmacy.models.Drug;

import java.util.ArrayList;
import java.util.List;

/**
 * @author OSei Emmanuel Kofi Kwarteng
 *
 * Represents a Drug Management System that allows the user to 
 * add search and view drugs.
 */

public class DrugManagementSystem {
    // List to store Drug objects
    private List<Drug> drugs;

    // Constructor to initialize the drugs list
    public DrugManagementSystem() {
        this.drugs = new ArrayList<>();
    }

    /**
     * Adds a new drug to the system.
     *
     * @param drug the Drug object to be added
     */
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

    /**
     * Searches for a drug by its code.
     *
     * @param code the code of the drug to search for
     * @return the Drug object if found, null otherwise
     */
    public Drug searchDrugByCode(String code) {
        for (Drug drug : drugs) {
            if (drug.getCode().equals(code)) {
                return drug;
            }
        }
        System.out.println("Drug with code " + code + " not found.");
        return null;
    }

    /**
     * Searches for drugs by their name.
     *
     * @param name the name of the drugs to search for
     * @return a list of Drug objects that match the name
     */
    public List<Drug> searchDrugsByName(String name) {
        List<Drug> result = new ArrayList<>();
        for (Drug drug : drugs) {
            if (drug.getName().equalsIgnoreCase(name)) {
                result.add(drug);
            }
        }
        if (result.isEmpty()) {
            System.out.println("No drugs found with the name " + name + ".");
        }
        return result;
    }

    /**
     * Displays all the drugs in the system.
     */
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

    // Main method for testing the DrugManagementSystem class
    public static void main(String[] args) {
        // Create an instance of DrugManagementSystem
        DrugManagementSystem drugManagementSystem = new DrugManagementSystem();

        // Create some Drug objects
        Drug drug1 = new Drug("Paracetamol", "001", 5.0);
        Drug drug2 = new Drug("Ibuprofen", "002", 10.0);
        Drug drug3 = new Drug("Amoxicillin", "003", 15.0);

        // Add drugs to the system
        drugManagementSystem.addDrug(drug1);
        drugManagementSystem.addDrug(drug2);
        drugManagementSystem.addDrug(drug3);

        // Search for a drug by code
        Drug searchedDrug = drugManagementSystem.searchDrugByCode("002");
        if (searchedDrug != null) {
            System.out.println("Drug found: " + searchedDrug);
        }

        // Search for drugs by name
        List<Drug> drugsByName = drugManagementSystem.searchDrugsByName("Paracetamol");
        if (!drugsByName.isEmpty()) {
            System.out.println("Drugs found with the name 'Paracetamol':");
            for (Drug drug : drugsByName) {
                System.out.println(drug);
            }
        }

        // View all drugs
        drugManagementSystem.viewAllDrugs();
    }
}
