package ui;
import system.MedicationTrackingSystem;
import models.*;
import java.util.Scanner;
import java.time.LocalDate;

/**
 * MainMenu class - Provides the interactive menu system for managing the Pharmacy Management System.
 * Users can perform various operations such as adding, searching, and processing prescriptions.
 */
public class MainMenu {
    public static void main(String[] args) {
        MedicationTrackingSystem system = new MedicationTrackingSystem();
        Scanner scanner = new Scanner(System.in);

        // -------------------------------------------------
        //  STEP 1: PREPOPULATE SYSTEM WITH SAMPLE DATA
        // -------------------------------------------------

        // Adding Doctors
        Doctor doctor1 = new Doctor("D001", "Emily Watson", 45, "555-1234", "Cardiology");
        Doctor doctor2 = new Doctor("D002", "James Carter", 50, "555-5678", "Neurology");
        system.addDoctor(doctor1);
        system.addDoctor(doctor2);

        // Adding Patients
        Patient patient1 = new Patient("P001", "John Doe", 30, "555-1111");
        Patient patient2 = new Patient("P002", "Alice Smith", 25, "555-2222");
        system.addPatient(patient1);
        system.addPatient(patient2);

        // Adding Medications
        Medication med1 = new Medication("M001", "Ibuprofen", "400mg", 50, null);
        Medication med2 = new Medication("M002", "Paracetamol", "500mg", 100, null);
        system.addMedication(med1);
        system.addMedication(med2);

        // Assign Patients to Doctors
        doctor1.addPatient(patient1);
        doctor2.addPatient(patient2);

        // Creating and Assigning Prescriptions
        Prescription presc1 = new Prescription("PRESC001", doctor1, patient1, med1, LocalDate.of(2024, 1, 15));
        Prescription presc2 = new Prescription("PRESC002", doctor2, patient2, med2, LocalDate.of(2024, 2, 5));
        patient1.addPrescription(presc1);
        patient2.addPrescription(presc2);

        // -------------------------------------------------
        //  STEP 2: DISPLAY THE MENU
        // -------------------------------------------------

        boolean exit = false;

        while (!exit) {
            System.out.println("\n==========================================");
            System.out.println("  WELCOME TO THE PHARMACY MANAGEMENT SYSTEM  ");
            System.out.println("==========================================");
            System.out.println("1. Add a New Patient");
            System.out.println("2. Add a New Doctor");
            System.out.println("3. Add a New Medication to the Pharmacy");
            System.out.println("4. Print System Report");
            System.out.println("5. Check If Medications Are Expired");
            System.out.println("6. Process a New Prescription");
            System.out.println("7. Print All Prescriptions for a Specific Doctor");
            System.out.println("8. Restock the Drugs in the Pharmacy");
            System.out.println("9. Print All Prescriptions for a Specific Patient");
            System.out.println("10: Remove a Patient, Doctor, or Medication");
            System.out.println("11: Edit a Patient, Doctor, or Medication");
            System.out.println("12: Search for a Patient, Doctor, or Medication");
            System.out.println("13: Exit");
            System.out.print("\nEnter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("[ERROR] Invalid input! Please enter a number between 1 and 10.");
                scanner.next(); 
                continue;
            }

            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    addNewPatient(scanner, system);
                    break;
                case 2:
                    addNewDoctor(scanner, system);
                    break;
                case 3:
                    addNewMedication(scanner, system);
                    break;
                case 4:
                    System.out.println("\nGenerating the Full System Report...");
                    system.generateReport();
                    System.out.println("\nReport successfully generated.");
                    break;
                case 5:
                    System.out.println("\nChecking for expired medications...");
                    system.checkForExpiredMedications();
                    System.out.println("\nExpired medication check completed.");
                    break;
                case 6:
                    System.out.println("\nProcessing a New Prescription...");
                    processNewPrescription(scanner, system);
                    System.out.println("\nPrescription successfully recorded.");
                    break;
                case 7:
                    printPrescriptionsForDoctor(scanner, system);
                    break;
                case 8:
                    system.restockAllMedications(scanner);
                    break;
                case 9:
                    printPrescriptionsForPatient(scanner, system);
                    break;
                    case 10:
                    removeEntity(scanner, system);
                    break;
                case 11:
                    editEntity(scanner, system);
                    break;
                case 12:
                    searchEntity(scanner, system);
                    break;
                case 13:
                    System.out.println("\nExiting The Pharmacy Management System...");
                    exit = true;
                    System.out.println("System has been successfully closed. Goodbye!");
                    break;
                default:
                    System.out.println("[ERROR] Invalid option. Please enter a number between 1 and 10.");
            }
        }
        scanner.close();
    }

    /********************************************************************************
     * 1- Adds a new patient to the system.
     * 
     * This method prompts the user for patient details and validates the input
     * to ensure correct data entry.
     *
     * @param scanner Scanner object for user input.
     * @param system  The MedicationTrackingSystem instance.
     ******************************************************************************/
    private static void addNewPatient(Scanner scanner, MedicationTrackingSystem system) {
        boolean adding = true;
        while (adding) {
            System.out.println("\n=============================================");
            System.out.println("         ADDING A NEW PATIENT                ");
            System.out.println("=============================================");
            System.out.print("Enter Patient ID: ");
            String id = scanner.nextLine().trim();
            
            System.out.print("Enter Patient Name: ");
            String name = scanner.nextLine().trim();
            
            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); 
            
            System.out.print("Enter Phone Number: ");
            String phone = scanner.nextLine().trim();

            // Create and add patient
            Patient patient = new Patient(id, name, age, phone);
            if (system.addPatient(patient)) {

            
                System.out.println("\n---------------------------------------------");
                System.out.println(" SUCCESS: Patient has been added successfully ");
                System.out.println("---------------------------------------------");
                System.out.println(" Patient ID     : " + id);
                System.out.println(" Name           : " + name);
                System.out.println(" Age            : " + age);
                System.out.println(" Contact Number : " + phone);
                System.out.println("---------------------------------------------\n");
            }else{
                System.out.println("[ERROR] Patient with ID '" + id + "' already exists. Please use a different ID.");
            }
                System.out.println("\nWould you like to:");
                System.out.println("1: Add another patient");
                System.out.println("2: Return to the main menu");
                System.out.print("Enter your choice: ");


            int choice = scanner.nextInt();
            scanner.nextLine(); 
    
            if (choice != 1) {
                adding = false;
            }
        }
    }

    /****************************************************************************
     * 2- Adds a new doctor to the system.
     * 
     * This method collects doctor details from user input 
     * and adds the doctor to the system.
     *
     * @param scanner Scanner object for user input.
     * @param system  The MedicationTrackingSystem instance.
     *****************************************************************************/
    private static void addNewDoctor(Scanner scanner, MedicationTrackingSystem system) {
        boolean adding = true;
        while (adding) {
            System.out.println("\n=============================================");
            System.out.println("             ADDING A NEW DOCTOR             ");
            System.out.println("=============================================");

            // Collect user input for doctor details
            System.out.print("Enter Doctor ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter Doctor Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Phone Number: ");
            String phone = scanner.nextLine();
            System.out.print("Enter Specialization: ");
            String specialization = scanner.nextLine();

            // Create and add a doctor
            Doctor doctor = new Doctor(id, name, age, phone, specialization);
            if (system.addDoctor(doctor)) {
            

            
                System.out.println("\n---------------------------------------------");
                System.out.println(" SUCCESS: Doctor has been added successfully ");
                System.out.println("---------------------------------------------");
                System.out.println(" Doctor ID        : " + id);
                System.out.println(" Name             : " + name);
                System.out.println(" Age              : " + age);
                System.out.println(" Contact Number   : " + phone);
                System.out.println(" Specialization   : " + specialization);
                System.out.println("---------------------------------------------\n");
            } else {
                
                System.out.println("[ERROR] Doctor with ID '" + id + "' already exists. Please use a different ID.");
            }
                System.out.println("\nWould you like to:");
                System.out.println("1: Add another doctor");
                System.out.println("2: Return to the main menu");
                System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice != 1) {
                adding = false;
            }
        }
    }

    /****************************************************************************************
     * 3- Adds a new medication to the system.
     * 
     * This method collects medication details from user input.
     * Users can either enter an expiry date manually or allow the system to generate one.
     *
     * @param scanner Scanner object for user input.
     * @param system  The MedicationTrackingSystem instance.
     ****************************************************************************************/
    private static void addNewMedication(Scanner scanner, MedicationTrackingSystem system) {
        boolean adding = true;
        while (adding) {
            System.out.println("\n=============================================");
            System.out.println("         ADDING A NEW MEDICATION             ");
            System.out.println("=============================================");

            // Collect user input for medication details
            System.out.print("Enter Medication ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter Medication Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Dosage (e.g., 200mg): ");
            String dose = scanner.nextLine();
            System.out.print("Enter Quantity in Stock: ");
            int stock = scanner.nextInt();
            scanner.nextLine(); 

            
            System.out.print("Enter Expiry Date (YYYY-MM-DD) or press Enter for a random date: ");
            String expiryInput = scanner.nextLine();

            LocalDate expiryDate = expiryInput.isEmpty() ? null : LocalDate.parse(expiryInput);

            // Create Medication Object (Medication class will generate random expiry if expiryDate is null)
            Medication medication = new Medication(id, name, dose, stock, expiryDate);
            if (system.addMedication(medication)) {
            

            
                System.out.println("\n---------------------------------------------");
                System.out.println(" SUCCESS: Medication has been added successfully ");
                System.out.println("---------------------------------------------");
                System.out.println(" Medication ID  : " + medication.getMedID());
                System.out.println(" Name           : " + medication.getMedName());
                System.out.println(" Dosage         : " + medication.getDose());
                System.out.println(" Stock Quantity : " + medication.getQuantityStock());
                System.out.println(" Expiry Date    : " + medication.getExpiryDate());
                System.out.println("---------------------------------------------\n");
            } else {
               
                System.out.println("[ERROR] Medication with ID '" + id + "' already exists. Please use a different ID.");
            }
    
            System.out.println("\nWould you like to:");
            System.out.println("1: Add another medication");
            System.out.println("2: Return to the main menu");
            System.out.print("Enter your choice: ");
    
            int choice = scanner.nextInt();
            scanner.nextLine(); 
    
            if (choice != 1) {
                adding = false;
            }
        }
    }

    /********************************************************************************
     * 6- Processes a new prescription by linking a doctor, patient, and medication.
     * 
     * This method prompts the user for prescription details, ensuring that 
     * the doctor, patient, and medication exist in the system before proceeding.
     *
     * @param scanner Scanner object for user input.
     * @param system  The MedicationTrackingSystem instance.
     **********************************************************************************/
    private static void processNewPrescription(Scanner scanner, MedicationTrackingSystem system) {
        boolean process = true;

        while (process) {
            System.out.println("\n=============================================");
            System.out.println("          PROCESSING A NEW PRESCRIPTION       ");
            System.out.println("=============================================");

            // Collect prescription details
            System.out.print("Enter Prescription ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter Doctor Name: ");
            String doctorName = scanner.nextLine();
            System.out.print("Enter Patient Name: ");
            String patientName = scanner.nextLine();
            System.out.print("Enter Medication Name: ");
            String medName = scanner.nextLine();
            System.out.print("Enter Prescription Date (YYYY-MM-DD): ");

            String dateInput = scanner.nextLine();
            LocalDate prescDate = LocalDate.parse(dateInput);

            system.acceptPrescription(id, doctorName, patientName, medName, prescDate);
            System.out.println("\nWould you like to:");
            System.out.println("1: process another prescription");
            System.out.println("2: Return to the main menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 
    
            if (choice != 1) {
                process= false;
            }
        }
    }

    /************************************************************************************************
     * Prints all prescriptions issued by a specific doctor.
     * 
     * This method prompts the user to enter a doctor's name, retrieves the doctor's prescriptions,
     * and displays them in a structured format.
     *
     * @param scanner Scanner object for user input.
     * @param system  The MedicationTrackingSystem instance.
     ************************************************************************************************/
    private static void printPrescriptionsForDoctor(Scanner scanner, MedicationTrackingSystem system) {
        System.out.println("\n=============================================");
        System.out.println("   VIEWING PRESCRIPTIONS BY A SPECIFIC DOCTOR ");
        System.out.println("=============================================");

        
        System.out.print("Enter Doctor Name: ");
        String doctorName = scanner.nextLine().trim();

       
        system.printPrescriptionsByDoctor(doctorName);


    }

    /*******************************************************************************************
     * 9- Prints all prescriptions assigned to a specific patient.
     * 
     * This method prompts the user to enter a patient's name, retrieves their prescriptions,
     * and displays them in a structured format.
     *
     * @param scanner Scanner object for user input.
     * @param system  The MedicationTrackingSystem instance.
     **********************************************************************************************/
    private static void printPrescriptionsForPatient(Scanner scanner, MedicationTrackingSystem system) {
        System.out.println("\n=============================================");
        System.out.println("  VIEWING PRESCRIPTIONS FOR A SPECIFIC PATIENT ");
        System.out.println("=============================================");

        // Prompt user for patient name
        System.out.print("Enter Patient Name: ");
        String patientName = scanner.nextLine().trim();

        
        system.printPrescriptionsByPatient(patientName);

    }




    /*********************************************************************************************
     * Removes a patient, doctor, or medication from the system.
     * 
     * This method prompts the user to select an entity type, then asks for the corresponding ID.
     * The user is required to confirm before deleting the selected entity.
     * 
     * @param scanner Scanner object for user input.
     * @param system  The MedicationTrackingSystem instance managing all entities.
    **********************************************************************************************/
    private static void removeEntity(Scanner scanner, MedicationTrackingSystem system) {
        boolean removing = true;
        while (removing) {
            System.out.println("\n=============================================");
            System.out.println("           REMOVE AN ENTITY                  ");
            System.out.println("=============================================");
            System.out.println("\nSelect an entity to remove:");
            System.out.println("1: Remove a Patient");
            System.out.println("2: Remove a Doctor");
            System.out.println("3: Remove a Medication");
            System.out.println("4: Return to the main menu");
            System.out.print("\nEnter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            String entityID;
        
            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID to remove: ");
                    entityID = scanner.nextLine();
                    System.out.print("Are you sure? (yes/no): ");
                    if (scanner.nextLine().equalsIgnoreCase("yes")) {
                        system.removePatient(entityID);
                    }
                    break;
                case 2:
                    System.out.print("Enter Doctor ID to remove: ");
                    entityID = scanner.nextLine();
                    System.out.print("Are you sure? (yes/no): ");
                    if (scanner.nextLine().equalsIgnoreCase("yes")) {
                        system.removeDoctor(entityID);
                    }
                    break;
                case 3:
                    System.out.print("Enter Medication ID to remove: ");
                    entityID = scanner.nextLine();
                    System.out.print("Are you sure? (yes/no): ");
                    if (scanner.nextLine().equalsIgnoreCase("yes")) {
                        system.removeMedication(entityID);
                    }
                    break;
                case 4:
                    removing = false;
                    break;
                default:
                    System.out.println("[ERROR] Invalid choice. Please try again.");
            }
        }
    }



    /********************************************************************************************
     * Edits the details of a patient, doctor, or medication in the system.
     * 
     * The user selects the type of entity to edit, provides the corresponding ID,
     * and then inputs the updated details. The system ensures valid input before applying changes.
     * 
     * @param scanner Scanner object for user input.
     * @param system  The MedicationTrackingSystem instance managing all entities.
     *********************************************************************************************/


    private static void editEntity(Scanner scanner, MedicationTrackingSystem system) {
        boolean editing = true;

        while (editing) {
            System.out.println("\n=============================================");
            System.out.println("           EDIT AN ENTITY                    ");
            System.out.println("=============================================");
            System.out.println("\nSelect an entity to edit:");
            System.out.println("1: Edit a Patient");
            System.out.println("2: Edit a Doctor");
            System.out.println("3: Edit a Medication");
            System.out.println("4: Return to the main menu");
            System.out.print("\nEnter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 
        
            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    String patientID = scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String newPatientName = scanner.nextLine();
                    System.out.print("Enter New Age: ");
                    int newPatientAge = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter New Phone Number: ");
                    String newPatientPhone = scanner.nextLine();

                    system.editPatient(patientID, newPatientName, newPatientAge, newPatientPhone);
                    break;
                    
                case 2:
                    System.out.print("Enter Doctor ID: ");
                    String doctorID = scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String newDoctorName = scanner.nextLine();
                    System.out.print("Enter New Age: ");
                    int newDoctorAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Phone Number: ");
                    String newDoctorPhone = scanner.nextLine();
                    System.out.print("Enter New Specialization: ");
                    String newSpecialization = scanner.nextLine();

                    system.editDoctor(doctorID, newDoctorName, newDoctorAge, newDoctorPhone, newSpecialization);
                    break;
                    
                case 3:
                    System.out.print("Enter Medication ID: ");
                    String medID = scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String medName = scanner.nextLine();
                    System.out.print("Enter New Dosage: ");
                    String medDose = scanner.nextLine();
                    System.out.print("Enter New Stock: ");
                    int medStock = scanner.nextInt();
                    scanner.nextLine();
                    system.editMedication(medID, medName, medDose, medStock);
                    break;

                case 4:
                    editing = false;
                    break;
                    
                default:
                    System.out.println("\nInvalid choice. Please select a valid option.");

            }

            if (editing) {
                System.out.println("\nWould you like to:");
                System.out.println("1: Edit another entity");
                System.out.println("2: Return to the main menu");
                System.out.print("Enter your choice: ");
    
                int nextAction = scanner.nextInt();
                scanner.nextLine(); 
    
                if (nextAction != 1) {
                    editing = false;
                }
            }
        }
    }

    /**********************************************************************************************
     * Searches for a patient, doctor, or medication by name.
     * 
     * The user selects the entity type and enters a name. If found, the system displays details;
     * otherwise, an error message is shown. Users can perform multiple searches before returning.
     * 
     * @param scanner Scanner object for user input.
     * @param system  The MedicationTrackingSystem instance managing all entities.
     **********************************************************************************************/
    private static void searchEntity(Scanner scanner, MedicationTrackingSystem system) {
        boolean searching = true;

        while (searching) {
            System.out.println("\n=============================================");
            System.out.println("           SEARCH FOR AN ENTITY              ");
            System.out.println("=============================================");
            System.out.println("\nSelect an entity to search for:");
            System.out.println("1: Search for a Patient");
            System.out.println("2: Search for a Doctor");
            System.out.println("3: Search for a Medication");
            System.out.println("4: Return to the main menu");
            System.out.print("\nEnter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient Name: ");
                    String patientName = scanner.nextLine();
                    Patient patient = system.searchPatient(patientName);
                    if (patient != null) {
                        System.out.println("\nPatient Found:");
                        System.out.println(patient);
                    } else {
                        System.out.println("\nError: Patient not found.");
                    }
                    break;
                case 2:
                    System.out.print("Enter Doctor Name: ");
                    String doctorName = scanner.nextLine();
                    Doctor doctor = system.searchDoctor(doctorName);
                    if (doctor != null) {
                        System.out.println("\nDoctor Found:");
                        System.out.println(doctor);
                    } else {
                        System.out.println("\nError: Doctor not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Medication Name: ");
                    String medName = scanner.nextLine();
                    Medication medication = system.searchMedication(medName);
                    if (medication != null) {
                        System.out.println("\nMedication Found:");
                        System.out.println(medication);
                    } else {
                        System.out.println("\nError: Medication not found.");
                    }
                    break;

                case 4:
                    searching = false;
                    break;
                default:
                    System.out.println("\nInvalid choice. Please select a valid option.");
            }
            if (searching) {
                System.out.println("\nWould you like to:");
                System.out.println("1: Search for another entity");
                System.out.println("2: Return to the main menu");
                System.out.print("Enter your choice: ");
    
                int nextAction = scanner.nextInt();
                scanner.nextLine(); 
    
                if (nextAction != 1) {
                    searching = false;
                }
            }
        }

    }
}