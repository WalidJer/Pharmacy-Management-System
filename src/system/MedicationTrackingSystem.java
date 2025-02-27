package system;
import models.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * The MedicationTrackingSystem class manages patients, doctors, medications, and prescriptions.
 * It provides functionalities such as adding, searching, editing, and removing records,
 * processing prescriptions, generating reports, and handling medication stock management.
 */
public class MedicationTrackingSystem {

    
    private List<Patient> patients;

    
    private List<Doctor> doctors;

    
    private List<Medication> medications;

    /**
     * Constructs a new MedicationTrackingSystem object.
     * Initializes empty lists for patients, doctors, and medications.
     */
    public MedicationTrackingSystem() {
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.medications = new ArrayList<>();
    }

// Getters

    /**
     * Retrieves the list of patients in the system.
     * 
     * @return A list of Patient objects.
     */
    public List<Patient> getPatients() {
        return patients;
    }

    /**
     * Retrieves the list of doctors in the system.
     * 
     * @return A list of Doctor objects.
     */
    public List<Doctor> getDoctors() {
        return doctors;
    }

    /**
     * Retrieves the list of medications available in the pharmacy.
     * 
     * @return A list of Medication objects.
     */
    public List<Medication> getMedications() {
        return medications;
    }


// ============================================================
// 1️- Adding & Removing Patients, Doctors, and Medications
// ============================================================

    /**
     * Adds a new patient to the system.
     * 
     * @param patient The patient to be added.
     */
    public boolean addPatient(Patient patient) {

        for (Patient p : patients) {
            if (p.getID().equals(patient.getID())) {

                return false;
            }
        }
        patients.add(patient);
     
        return true;
    }

    /**
     * Adds a new doctor to the system.
     * 
     * @param doctor The doctor to be added.
    */
    public boolean addDoctor(Doctor doctor) {
        for (Doctor d : doctors) {
            if (d.getID().equals(doctor.getID())) {
                return false;
            }
        }
        doctors.add(doctor);

        return true;
    }

    /**
     * Adds a new medication to the pharmacy.
     * 
     * @param medication The medication to be added.
    */
    public boolean addMedication(Medication medication) {
        for (Medication m : medications) {
            if (m.getMedID().equals(medication.getMedID())) {

                return false;
            }
        }
        medications.add(medication);

        return true;
    }

    



    /**
     * Removes a patient from the system by ID using a regular loop.
     * It iterates over the list, checks each patient's ID, and removes the matching one.
     * 
     * @param patientID The ID of the patient to be removed.
    */
    public void removePatient(String patientID) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getID().equals(patientID)) {
                Patient patient = patients.get(i); 
                patients.remove(i);  
                System.out.println("Patient '" + patient.getName() + "' (ID: " + patientID + ") has been removed from the system.");
                return;  
            }
        }
        System.out.println("Error: No patient found with ID '" + patientID + "'.");
    }



    /**
     * Removes a doctor from the system by ID.
     *
     * @param doctorID The ID of the doctor to be removed.
     */
    public void removeDoctor(String doctorID) {
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getID().equals(doctorID)) {
                Doctor doctor = doctors.get(i);  
                doctors.remove(i);  
                System.out.println("Doctor '" + doctor.getName() + "' (ID: " + doctorID + ") has been removed from the system.");
                return;  
            }
        }
        System.out.println("Error: No doctor found with ID '" + doctorID + "'.");
    }

    /**
     * Removes a medication from the pharmacy by ID.
     * 
     * @param medicationID The ID of the medication to be removed.
     */
    public void removeMedication(String medicationID) {
        for (int i = 0; i < medications.size(); i++) {
            if (medications.get(i).getMedID().equals(medicationID)) {
                Medication medication = medications.get(i);  
                medications.remove(i);  
                System.out.println("Medication '" + medication.getMedName() + "' (ID: " + medicationID + ") has been removed from the system.");
                return;  
            }
        }
        System.out.println("Error: No medication found with ID '" + medicationID + "'.");
    }
    // ============================================================
    // 2️- Editing Details (Patients, Doctors, Medications)
    // ============================================================

    /**
     * Edits a patient's details in the system using a regular `for` loop.
     * 
     * @param patientID The ID of the patient to be edited.
     * @param newName The new name for the patient.
     * @param newAge The new age of the patient.
     * @param newPhone The new contact number for the patient.
     */
    public void editPatient(String patientID, String newName, int newAge, String newPhone) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getID().equals(patientID)) {
                patients.get(i).setName(newName);
                patients.get(i).setAge(newAge);
                patients.get(i).setPhoneNum(newPhone);
                System.out.println(" Patient with ID '" + patientID + "' has been updated successfully.");
                return;
            }
        }
        System.out.println("Error: No patient found with ID '" + patientID + "'.");
    }

    /**
     * Edits a doctor's details in the system using a `foreach` loop.
     * 
     * @param doctorID The ID of the doctor to be edited.
     * @param newName The new name for the doctor.
     * @param newAge The new age of the doctor.
     * @param newPhone The new contact number for the doctor.
     * @param newSpecialization The new specialization of the doctor.
     */
    public void editDoctor(String doctorID, String newName, int newAge, String newPhone, String newSpecialization) {
        for (Doctor doctor : doctors) { 
            if (doctor.getID().equals(doctorID)) {
                doctor.setName(newName);
                doctor.setAge(newAge);
                doctor.setPhoneNum(newPhone);
                doctor.setSpecialization(newSpecialization);
                System.out.println("Doctor with ID '" + doctorID + "' has been updated successfully.");
                return;
            }
        }
        System.out.println("Error: No doctor found with ID '" + doctorID + "'.");
    }

    /**
     * Edits a medication's details in the system using a `foreach` loop.
     * 
     * @param medicationID The ID of the medication to be edited.
     * @param newName The new name for the medication.
     * @param newDose The new dosage for the medication.
     * @param newStock The new stock quantity for the medication.
     */
    public void editMedication(String medicationID, String newName, String newDose, int newStock) {
        for (Medication medication : medications) { 
            if (medication.getMedID().equals(medicationID)) {
                medication.setMedName(newName);
                medication.setDose(newDose);
                medication.setQuantityStock(newStock);
                System.out.println("Medication with ID '" + medicationID + "' has been updated successfully.");
                return;
            }
        }
        System.out.println("Error: No medication found with ID '" + medicationID + "'.");
    }


    // ============================================================
    // 3️- Searching (Patients, Doctors, Medications)
    // ============================================================

    /**
     * Searches for a patient by name using a regular `for` loop.
     * It performs a case-insensitive search and returns the first match.
     * 
     * @param name The name of the patient to search for.
     * @return The matching Patient object, or null if not found.
     */
    public Patient searchPatient(String name) {
        for (int i = 0; i < patients.size(); i++) { 
            if (patients.get(i).getName().equalsIgnoreCase(name)) {
                return patients.get(i); 
            }
        }
        return null; 
    }

    /**
     * Searches for a doctor by name using a `foreach` loop.
     * It performs a case-insensitive search and returns the first match.
     * 
     * @param name The name of the doctor to search for.
     * @return The matching Doctor object, or null if not found.
     */
    public Doctor searchDoctor(String name) {
        for (Doctor doctor : doctors) { 
            if (doctor.getName().equalsIgnoreCase(name)) {
                return doctor; 
            }
        }
        return null; 
    }

    /**
     * Searches for a medication by name using a `foreach` loop.
     * It performs a case-insensitive search and returns the first match.
     * 
     * @param name The name of the medication to search for.
     * @return The matching Medication object, or null if not found.
     */
    public Medication searchMedication(String name) {
        for (Medication medication : medications) { 
            if (medication.getMedName().equalsIgnoreCase(name)) {
                return medication; 
            }
        }
        return null; 
    }

    // ============================================================
    // 4️- Accept a New Prescription (Linking Doctor, Patient & Medication)
    // ============================================================

    /**
     * Accepts a new prescription and links it to the corresponding doctor, patient, and medication.
     * Ensures that all required entities exist before proceeding.
     * 
     * @param prescID The unique prescription ID.
     * @param doctorName The name of the prescribing doctor.
     * @param patientName The name of the patient receiving the prescription.
     * @param medName The name of the prescribed medication.
     * @param prescDate The issuance date of the prescription.
     */
    public void acceptPrescription(String prescID, String doctorName, String patientName, String medName, LocalDate prescDate) {
        
        Doctor doctor = searchDoctor(doctorName);
        Patient patient = searchPatient(patientName);
        Medication medication = searchMedication(medName);

       
        if (doctor == null) {
            System.out.println("Error: Doctor '" + doctorName + "' not found in the system.");
            return;
        }
        if (patient == null) {
            System.out.println("Error: Patient '" + patientName + "' not found in the system.");
            return;
        }
        if (medication == null) {
            System.out.println("Error: Medication '" + medName + "' not found in the system.");
            return;
        }

        for (Prescription presc : patient.getPrescriptions()) {
            if (presc.getPrescID().equals(prescID)) {
                System.out.println("[ERROR] Prescription with ID '" + prescID + "' already exists.");
                return;
            }
        }

        // Create the prescription (Expiry: 1 year from issue date)
        Prescription prescription = new Prescription(prescID, doctor, patient, medication, prescDate);

        // Add prescription to the patient's record
        patient.addPrescription(prescription);

       
        System.out.println("\n-----------------------------------------------------");
        System.out.println(" SUCCESS: Prescription has been processed successfully ");
        System.out.println("-------------------------------------------------------");
        System.out.println("Prescription ID   : " + prescID);
        System.out.println("Patient           : " + patient.getName());
        System.out.println("Doctor            : " + doctor.getName() + " (Specialization: " + doctor.getSpecialization() + ")");
        System.out.println("Medication        : " + medication.getMedName() + " (" + medication.getDose() + ")");
        System.out.println("Prescription Date : " + prescDate);
        System.out.println("Expiry Date       : " + prescDate.plusYears(1));
        System.out.println("---------------------------------------------------");
        }
    // ============================================================
    // 5- Assign a Patient to a Doctor
    // ============================================================

    /**
     * Assigns a patient to a doctor's list.
     * Ensures that both the doctor and patient exist before assigning.
     * 
     * @param patientName The name of the patient to be assigned.
     * @param doctorName The name of the doctor to whom the patient will be assigned.
     */
    public void assignPatientToDoctor(String patientName, String doctorName) {
        
        Patient patient = searchPatient(patientName);
        Doctor doctor = searchDoctor(doctorName);

        
        if (patient == null) {
            System.out.println("[ERROR] Patient '" + patientName + "' not found in the system.");
            return;
        }
        if (doctor == null) {
            System.out.println("[ERROR] Doctor '" + doctorName + "' not found in the system.");
            return;
        }

        
        doctor.addPatient(patient);
        System.out.println("\n=== PATIENT ASSIGNMENT SUCCESSFUL ===");
        System.out.println("Patient '" + patient.getName() + "' has been assigned to Dr. " + doctor.getName() + ".");
    }




    // ============================================================
    // 6- Generate a Full System Report (Patients, Doctors, Medications)
    // ============================================================

    /**
     * Generates a comprehensive system report including:
     * - A list of all patients
     * - A list of all doctors with their specializations
     * - A list of all medications with stock and expiry details
     * If any section is empty, a message is displayed.
     */
    public void generateReport() {
        System.out.println("\n=============================================");
        System.out.println("           PHARMACY SYSTEM REPORT            ");
        System.out.println("=============================================\n");
    
        // Print Patients
        System.out.println(" Patients: " + patients.size());
        System.out.println("---------------------------------------------");
        if (patients.isEmpty()) {
            System.out.println("   No patients found.");
        } else {
            for (int i = 0; i < patients.size(); i++) {
                Patient patient = patients.get(i);
                System.out.println(" Patient ID: " + patient.getID());
                System.out.println(" Name: " + patient.getName());
                System.out.println(" Age: " + patient.getAge());
                System.out.println(" Phone: " + patient.getPhoneNum());
                System.out.println(" Medications: " + patient.getMedications().size());
                System.out.println(" Prescriptions: " + patient.getPrescriptions().size());
                System.out.println();
            }
        }
        System.out.println("---------------------------------------------");
    
        
        System.out.println(" Doctors: " + doctors.size());
        System.out.println("---------------------------------------------");
        if (doctors.isEmpty()) {
            System.out.println("   No doctors found.");
        } else {
            for (int i = 0; i < doctors.size(); i++) {
                Doctor doctor = doctors.get(i);
                System.out.println(" Doctor ID: " + doctor.getID());
                System.out.println(" Name: Dr. " + doctor.getName());
                System.out.println(" Age: " + doctor.getAge());
                System.out.println(" Phone: " + doctor.getPhoneNum());
                System.out.println(" Specialization: " + doctor.getSpecialization());
                System.out.println(" Patients Assigned: " + doctor.getPatients().size());
                System.out.println();
            }
        }
        System.out.println("---------------------------------------------");
    
        // Print Medications
        System.out.println(" Medications: " + medications.size());
        System.out.println("---------------------------------------------");
        if (medications.isEmpty()) {
            System.out.println("   No medications found.");
        } else {
            for (int i = 0; i < medications.size(); i++) {
                Medication med = medications.get(i);
                System.out.println(" Medication ID: " + med.getMedID());
                System.out.println(" Name: " + med.getMedName());
                System.out.println(" Dosage: " + med.getDose());
                System.out.println(" Stock: " + med.getQuantityStock());
                System.out.println(" Expiry Date: " + med.getExpiryDate());
                System.out.println(" Expired: " + (med.isExpired() ? "YES - REMOVE" : "NO - SAFE TO USE"));
                System.out.println();
            }
        }
        System.out.println("=============================================");
    }

    
    // ============================================================
    // 7- Check for Expired Medications
    // ============================================================

    /**
     * Checks for expired medications in the system.
     * - Iterates through the medication list and identifies expired drugs.
     * - Displays the expiration status in a structured format.
     * - Alerts if expired medications are found.
     */
    public void checkForExpiredMedications() {
        System.out.println("\n========================================");
        System.out.println("          EXPIRED MEDICATION CHECK       ");
        System.out.println("========================================");

        boolean hasExpired = false;
        LocalDate today = LocalDate.now();

    
        for (int i = 0; i < medications.size(); i++) {
            Medication med = medications.get(i);
            if (med.getExpiryDate().isBefore(today)) {  
                System.out.println("Expired Medication: " + med.getMedName());
                System.out.println("  Expiry Date   : " + med.getExpiryDate());
                System.out.println("  Stock Remaining: " + med.getQuantityStock());
                System.out.println("----------------------------------------");
                hasExpired = true;
            }
        }

       
        if (!hasExpired) {
            System.out.println("No expired medications found. All stock is up-to-date.");
        } else {
            System.out.println("\nALERT: Some medications have expired. Consider restocking or removing them.");
        }

        System.out.println("========================================");
        System.out.println("           END OF CHECK                 ");
        System.out.println("========================================\n");
    }



    // ============================================================
    // 8- Print All Prescriptions for a Specific Doctor
    // ============================================================

    /**
     * Prints all prescriptions issued by a specific doctor.
     * - Searches for the doctor by name.
     * - Iterates through all patients to find prescriptions linked to the doctor.
     * - Displays prescription details in a structured format.
     * 
     * @param doctorName The name of the doctor whose prescriptions need to be displayed.
     */
    public void printPrescriptionsByDoctor(String doctorName) {
       
        Doctor doctor = searchDoctor(doctorName);

        
        if (doctor == null) {
            System.out.println("\n[ERROR] Doctor '" + doctorName + "' not found in the system.");
            return;
        }

        System.out.println("\n========================================");
        System.out.println("   PRESCRIPTIONS ISSUED BY DR. " + doctor.getName().toUpperCase());
        System.out.println("========================================");

        boolean hasPrescriptions = false;

     
        for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i);
            for (int j = 0; j < patient.getPrescriptions().size(); j++) {
                Prescription presc = patient.getPrescriptions().get(j);
                if (presc.getDoctor().equals(doctor)) { 
                    System.out.println("\nPrescription ID: " + presc.getPrescID());
                    System.out.println("  Patient     : " + presc.getPatient().getName());
                    System.out.println("  Medication  : " + presc.getMedication().getMedName() + " (" + presc.getMedication().getDose() + ")");
                    System.out.println("  Issued Date : " + presc.getPrescDate());
                    System.out.println("  Expiry Date : " + presc.getPrescExpiry());
                    System.out.println("----------------------------------------");
                    hasPrescriptions = true;
                }
            }
        }

       
        if (!hasPrescriptions) {
            System.out.println("\nNo prescriptions found for Dr. " + doctor.getName() + ".");
        }

        System.out.println("\n========================================");
        System.out.println("        END OF PRESCRIPTION LIST        ");
        System.out.println("========================================\n");
    }
    // ============================================================
    // 9- Print All Prescriptions for a Specific Patient
    // ============================================================
    
    /**
     * Prints all prescriptions assigned to a specific patient.
     * - Searches for the patient by name.
     * - Retrieves and displays all prescriptions linked to the patient.
     * - Provides structured output with prescription details.
     *
     * @param patientName The name of the patient whose prescriptions need to be displayed.
     */
    public void printPrescriptionsByPatient(String patientName) {
        
        Patient patient = searchPatient(patientName);
    

        if (patient == null) {
            System.out.println("\n[ERROR] Patient '" + patientName + "' not found in the system.");
            return;
        }
    
        System.out.println("\n========================================");
        System.out.println("   PRESCRIPTIONS FOR " + patient.getName().toUpperCase());
        System.out.println("========================================");
    

    
        if (patient.getPrescriptions().isEmpty()) {
            System.out.println("\nNo prescriptions found for " + patient.getName() + ".");
        } else {
            for (int i = 0; i <  patient.getPrescriptions().size(); i++) {
                Prescription presc = patient.getPrescriptions().get(i);
                System.out.println("\nPrescription ID: " + presc.getPrescID());
                System.out.println("  Doctor      : Dr. " + presc.getDoctor().getName());
                System.out.println("  Medication  : " + presc.getMedication().getMedName() + " (" + presc.getMedication().getDose() + ")");
                System.out.println("  Issued Date : " + presc.getPrescDate());
                System.out.println("  Expiry Date : " + presc.getPrescExpiry());
                System.out.println("----------------------------------------");
            }
        }
    
        System.out.println("\n========================================");
        System.out.println("        END OF PRESCRIPTION LIST        ");
        System.out.println("========================================\n");
    }


    // ============================================================
    // 10 Restock All Medications in the Pharmacy
    // ============================================================

    /**
     * Restocks all medications in the pharmacy.
     * - The user can choose to restock by a random amount (5-20) or enter a specific amount.
     * - If no medications exist, an error message is displayed.
     * - Provides a structured report after restocking.
     * 
     * @param scanner A shared Scanner object from MainMenu to avoid closing issues.
     */
    public void restockAllMedications(Scanner scanner) {
        System.out.println("\n========================================");
        System.out.println("         RESTOCKING MEDICATIONS         ");
        System.out.println("========================================");

        if (medications.isEmpty()) {
            System.out.println("\nNo medications found in the system to restock.");
            return;
        }

        System.out.print("\nWould you like to: \n1. Restock with a random amount (5-20) \n2. Enter a specific restock amount \nEnter choice (1 or 2): ");
        
        int choice;
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
        } else {
            System.out.println("[ERROR] Invalid input! Defaulting to random restock.");
            scanner.next(); 
            choice = 1;
        }

        Random rand = new Random();

        
        for (int i = 0; i < medications.size(); i++) {
            Medication med = medications.get(i);
            int restockAmount;

            if (choice == 1) {
                // Generate a random restock amount between 5 and 20
                restockAmount = rand.nextInt(16) + 5;
            } else if (choice == 2) {
                System.out.print("Enter restock amount for " + med.getMedName() + ": ");
                if (scanner.hasNextInt()) {
                    restockAmount = scanner.nextInt();
                    if (restockAmount < 0) {
                        System.out.println("[WARNING] Invalid input! Restock amount cannot be negative. Skipping this medication.");
                        continue;
                    }
                } else {
                    System.out.println("[ERROR] Invalid input! Skipping this medication.");
                    scanner.next(); 
                    continue;
                }
            } else {
                System.out.println("[ERROR] Invalid choice. Defaulting to random restock.");
                restockAmount = rand.nextInt(16) + 5;
            }

            int previousStock = med.getQuantityStock();
            med.setQuantityStock(previousStock + restockAmount);

            System.out.println("\nMedication: " + med.getMedName());
            System.out.println("  Previous Stock : " + previousStock);
            System.out.println("  Restocked By   : " + restockAmount);
            System.out.println("  New Stock      : " + med.getQuantityStock());
            System.out.println("----------------------------------------");
        }

        System.out.println("\n========================================");
        System.out.println("   RESTOCKING PROCESS COMPLETED         ");
        System.out.println("========================================\n");
    }

}
