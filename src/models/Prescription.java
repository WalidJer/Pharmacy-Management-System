package models;
import java.time.LocalDate;

/**
 * The Prescription class represents a medical prescription issued by a doctor to a patient.
 * It contains details about the prescribing doctor, patient, prescribed medication, 
 * issuance date, and expiry date.
 */
public class Prescription {

    /** The unique identifier for the prescription. */
    private String prescID;

    /** The doctor who issued the prescription. */
    private Doctor doctor;

    /** The patient for whom the prescription is issued. */
    private Patient patient;

    /** The medication prescribed to the patient. */
    private Medication medication;

    /** The date the prescription was issued. */
    private LocalDate prescDate;

    /** The expiration date of the prescription (defaults to 1 year from issue date). */
    private LocalDate prescExpiry;

    /**
     * Constructs a new Prescription object.
     * The expiry date is automatically set to one year from the prescription date.
     * 
     * @param prescID The unique ID of the prescription.
     * @param doctor The doctor who issued the prescription.
     * @param patient The patient receiving the prescription.
     * @param medication The medication prescribed.
     * @param prescDate The date the prescription was issued.
     */
    public Prescription(String prescID, Doctor doctor, Patient patient, Medication medication, LocalDate prescDate) {
        this.prescID = prescID;
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.prescDate = prescDate;
        this.prescExpiry = prescDate.plusYears(1);
    }

    // Getters

    /**
     * Retrieves the prescription ID.
     * 
     * @return The prescription ID.
     */
    public String getPrescID() {
        return prescID;
    }

    /**
     * Retrieves the doctor who issued the prescription.
     * 
     * @return The doctor associated with this prescription.
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * Retrieves the patient receiving the prescription.
     * 
     * @return The patient assigned to this prescription.
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Retrieves the prescribed medication.
     * 
     * @return The medication prescribed in this prescription.
     */
    public Medication getMedication() {
        return medication;
    }

    /**
     * Retrieves the date the prescription was issued.
     * 
     * @return The issuance date of the prescription.
     */
    public LocalDate getPrescDate() {
        return prescDate;
    }

    /**
     * Retrieves the expiration date of the prescription.
     * 
     * @return The expiration date of the prescription.
     */
    public LocalDate getPrescExpiry() {
        return prescExpiry;
    }

    // Setters

    /**
     * Updates the prescription ID.
     * 
     * @param prescID The new prescription ID.
     */
    public void setPrescID(String prescID) {
        this.prescID = prescID;
    }

    /**
     * Updates the doctor associated with the prescription.
     * 
     * @param doctor The new doctor for this prescription.
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     * Updates the patient receiving the prescription.
     * 
     * @param patient The new patient assigned to this prescription.
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * Updates the medication assigned in the prescription.
     * 
     * @param medication The new medication for this prescription.
     */
    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    /**
     * Updates the prescription date.
     * 
     * @param prescDate The new issuance date for the prescription.
     */
    public void setPrescDate(LocalDate prescDate) {
        this.prescDate = prescDate;
    }

    /**
     * Updates the expiration date of the prescription.
     * 
     * @param prescExpiry The new expiration date.
     */
    public void setPrescExpiry(LocalDate prescExpiry) {
        this.prescExpiry = prescExpiry;
    }

    /**
     * Checks if the prescription has expired.
     * 
     * @return True if the prescription is expired, false otherwise.
     */
    public boolean isExpired() {
        return LocalDate.now().isAfter(prescExpiry);
    }

    /**
     * Returns a string representation of the prescription details.
     * 
     * @return A formatted string containing prescription details.
     */
    @Override
    public String toString() {
        return "Prescription ID: " + prescID +
               "\nDoctor: " + doctor.getName() +
               "\nPatient: " + patient.getName() +
               "\nMedication: " + medication.getMedName() +
               "\nIssued Date: " + prescDate +
               "\nPrescription Expiry: " + prescExpiry +
               "\nExpired: " + (isExpired() ? "Yes" : "No");
    }
}