package models;
import java.util.ArrayList;
import java.util.List;

/**
 * The Doctor class represents a doctor in the pharmacy system.
 * It extends the Person class and includes a specialization and a list of patients.
 */
public class Doctor extends Person {

    /** The doctor's field of specialization. */
    private String specialization;

    /** List of patients assigned to the doctor. */
    private List<Patient> patients;

    /**
     * Constructs a new Doctor object.
     * Starts with an empty list of patients.
     * 
     * @param id The unique ID of the doctor.
     * @param name The full name of the doctor.
     * @param age The age of the doctor.
     * @param phoneNum The contact phone number of the doctor.
     * @param specialization The field of expertise of the doctor.
     */
    public Doctor(String id, String name, int age, String phoneNum, String specialization) {
        super(id, name, age, phoneNum);
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    /**
     * Retrieves the doctor's specialization.
     * 
     * @return The doctor's field of expertise.
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * Retrieves the list of patients assigned to the doctor.
     * 
     * @return A list of Patient objects.
     */
    public List<Patient> getPatients() {
        return patients;
    }

    /**
     * Updates the doctor's specialization.
     * 
     * @param specialization The new specialization to set for the doctor.
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /**
     * Adds a patient to the doctor's patient list.
     * Prevents adding duplicate patients.
     * 
     * @param patient The patient to be assigned to the doctor.
     */
    public void addPatient(Patient patient) {
        if (patients.contains(patient)) {
            System.out.println(patient.getName() + " is already assigned to Dr. " + getName());
        } else {
            patients.add(patient);
            System.out.println(patient.getName() + " has been assigned to Dr. " + getName());
        }
    }

    /**
     * Removes a patient from the doctor's patient list.
     * If the patient is not found, prints a message.
     * 
     * @param patient The patient to be removed from the doctor's list.
     */
    public void removePatient(Patient patient) {
        if (patients.contains(patient)) {
            patients.remove(patient);
            System.out.println(patient.getName() + " has been removed from Dr. " + getName() + "'s patient list.");
        } else {
            System.out.println(patient.getName() + " is not assigned to Dr. " + getName());
        }
    }

    /**
     * Returns a string representation of the doctor's details, including the number of assigned patients.
     * 
     * @return A formatted string containing doctor details.
     */
    @Override
    public String toString() {
        return super.toString() + 
               "\nSpecialization: " + specialization +
               "\nNumber of Patients: " + patients.size();
    }
}