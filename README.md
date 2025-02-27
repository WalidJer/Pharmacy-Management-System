 ## Pharmacy Management System
 ## Overview
The Pharmacy Management System is a comprehensive Java-based application designed to streamline pharmacy operations. It enables efficient management of patients, doctors, medications, and prescriptions while ensuring smooth interactions between users. The system provides an intuitive command-line interface, automating essential pharmacy functions such as tracking prescriptions, checking medication expiration, generating reports, and restocking inventory.

## Key Features
- Manage Patients, Doctors, and Medications (Add, Edit, Search, Remove)
- Process and Track Prescriptions efficiently
- Check for Expired Medications with automatic alerts
- Generate System Reports summarizing pharmacy data
- Automated Restocking of medications
- Interactive Command-Line Menu with error handling and validation

## How to run the program?
# Option 1: Running in an IDE
    Open VS Code, IntelliJ IDEA, or Eclipse.
    Locate the MainMenu.java file in the src/ui/ directory.
    Click Run to start the application.
# Option 2: Running via Terminal
    Compile and execute manually:
    javac -d bin -sourcepath src src/ui/MainMenu.java
    java -cp bin ui.MainMenu

## How to Use?
Once launched, the system presents an interactive menu for performing various operations:

==========================================
    PHARMACY MANAGEMENT SYSTEM MENU
==========================================

1: Add a New Patient
2: Add a New Doctor
3: Add a New Medication
4: Generate System Report
5: Check for Expired Medications
6: Process a New Prescription
7: View Prescriptions by Doctor
8: Restock Medications
9: View Prescriptions by Patient
10: Edit a Patient, Doctor, or Medication
11: Search for a Patient, Doctor, or Medication
12: Remove a Patient, Doctor, or Medication
13: Exit

## User Instructions
- Select an option (1-13) to perform an action.
- Follow system prompts to enter or modify data.
- Navigate back to the main menu or exit the system when done.

## System Documentation
For a detailed explanation of the Pharmacy Management System, check the full documentation:
(docs/System-Documentation.pdf)