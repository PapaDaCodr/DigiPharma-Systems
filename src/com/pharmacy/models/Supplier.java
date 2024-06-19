package com.pharmacy.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Osei Owusu Ansah
 *
 *
 * Represents a supplier of drugs in a pharmacy management system.
 */
public class Supplier implements Serializable {
    private String name;
    private String location;
    private String contact;
    private List<Drug> suppliedDrugs;

    /**
     * Constructs a new Supplier object with the given name, location, and contact.
     *
     * @param name     the name of the supplier
     * @param location the location of the supplier
     * @param contact  the contact information of the supplier
     */
    public Supplier(String name, String location, String contact) {
        this.name = name;
        this.location = location;
        this.contact = contact;
        this.suppliedDrugs = new ArrayList<>();
    }

    /**
     * Returns the name of the supplier.
     *
     * @return the name of the supplier
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the location of the supplier.
     *
     * @return the location of the supplier
     */
    public String getLocation() {
        return location;
    }

    /**
     * Returns the contact information of the supplier.
     *
     * @return the contact information of the supplier
     */
    public String getContact() {
        return contact;
    }

    /**
     * Returns the list of drugs supplied by this supplier.
     *
     * @return the list of supplied drugs
     */
    public List<Drug> getSuppliedDrugs() {
        return suppliedDrugs;
    }

    /**
     * Adds a drug to the list of supplied drugs.
     * If the drug is already supplied, it is not added again.
     *
     * @param drug the drug to be added
     */
    public void addSuppliedDrug(Drug drug) {
        if (drug != null && !suppliedDrugs.contains(drug)) {
            suppliedDrugs.add(drug);
            drug.addSupplier(this);
        }
    }

    /**
     * Removes a drug from the list of supplied drugs.
     *
     * @param drug the drug to be removed
     */
    public void removeSuppliedDrug(Drug drug) {
        if (suppliedDrugs.contains(drug)) {
            suppliedDrugs.remove(drug);
            drug.getSuppliers().remove(this);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Supplier other = (Supplier) obj;
        return Objects.equals(name, other.name) && Objects.equals(location, other.location);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}