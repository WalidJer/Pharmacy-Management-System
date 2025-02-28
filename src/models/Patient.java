package models;
import java.util.ArrayList;
import java.util.List;

/**
 * The Patient class represents a patient in the pharmacy system.
 * It extends the Person class and includes lists of medications and prescriptions.
 */
public class Patient extends Person {

    private List<Medication> medications;
    private List<Prescription> prescriptions;

    /**
     * Constructs a new Patient object.
     * Starts with empty medication and prescription lists.
     * 
     * @param id The unique ID of the patient.
     * @param name The full name of the patient.
     * @param age The age of the patient.
     * @param phoneNum The contact phone number of the patient.
     */
    public Patient(String id, String name, int age, String phoneNum) {
        super(id, name, age, phoneNum);
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    /**
     * Retrieves the list of medications the patient is currently taking.
     * 
     * @return A list of Medication objects.
     */
    public List<Medication> getMedications() {
        return medications;
    }

    /**
     * Retrieves the list of prescriptions assigned to the patient.
     * 
     * @return A list of Prescription objects.
     */
    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    /**
     * Adds a medication to the patient's medication list.
     * Prevents adding duplicate medications.
     * 
     * @param medication The medication to be added.
     */
    public void addMedication(Medication medication) {
        if (medications.contains(medication)) {
            System.out.println(medication.getMedName() + " is already in the patient's medication list.");
        } else {
            medications.add(medication);
            System.out.println(medication.getMedName() + " has been added to the patient's medications.");
        }
    }

    /**
     * Adds a prescription to the patient's prescription list.
     * Prevents adding duplicate prescriptions.
     * 
     * @param prescription The prescription to be added.
     */
    public void addPrescription(Prescription prescription) {
        if (prescriptions.contains(prescription)) {
            System.out.println("Prescription " + prescription.getPrescID() + " is already in the list.");
        } else {
            prescriptions.add(prescription);
            System.out.println("Prescription " + prescription.getPrescID() + " has been added to the patient's prescriptions.");
        }
    }

    /**
     * Removes a medication from the patient's medication list.
     * If the medication is not found, prints a message.
     * 
     * @param medication The medication to be removed.
     */
    public void removeMedication(Medication medication) {
        if (medications.contains(medication)) {
            medications.remove(medication);
            System.out.println(medication.getMedName() + " has been removed from the patient's medications.");
        } else {
            System.out.println(medication.getMedName() + " is not in the list.");
        }
    }

    /**
     * Removes a prescription from the patient's prescription list.
     * If the prescription is not found, prints a message.
     * 
     * @param prescription The prescription to be removed.
     */
    public void removePrescription(Prescription prescription) {
        if (prescriptions.contains(prescription)) {
            prescriptions.remove(prescription);
            System.out.println("Prescription " + prescription.getPrescID() + " has been removed.");
        } else {
            System.out.println("Prescription " + prescription.getPrescID() + " is not in the list.");
        }
    }

    /**
     * Returns a string representation of the patient's details, including the number of medications and prescriptions.
     * 
     * @return A formatted string containing patient details.
     */
    @Override
    public String toString() {
        return super.toString() +
               "\nMedications: " + medications.size() +
               "\nPrescriptions: " + prescriptions.size();
    }
}