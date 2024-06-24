package com.pharmacy.models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
/**
 * This class represents a SalesTracker class for tracking drugs bought
 * and write drug code to sales file.
 * 
 * @author Emmanuel Kofi Kwarteng
 */

 public class SalesTracker {
=======
public class SalesTracker {
>>>>>>> 81e6002f144d2c6e4460e4f96d033b2b5965fb0b
    private List<String> sales;

    public SalesTracker() {
        this.sales = new ArrayList<>();
    }

    /**
     * Tracks a drug sale by adding the drug code to the sales list.
     *
     * @param drugCode the code of the sold drug
     */
    public void trackSale(String drugCode) {
        sales.add(drugCode);
    }

    /**
     * Writes the tracked sales to a sales file.
     *
     * @param filename the name of the file to write to
     */
    public void writeSalesToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String sale : sales) {
                writer.write(sale);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to sales file: " + e.getMessage());
        }
    }
}
