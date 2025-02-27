package models;
import java.time.LocalDate;
import java.util.Random;

/**
 * The Medication class represents a drug in the pharmacy system.
 * It stores details such as medication name, dosage, stock, and expiry date.
 */
public class Medication {

    /** The unique identifier for the medication. */
    private String medID;

    /** The name of the medication. */
    private String medName;

    /** The dosage of the medication. */
    private String dose;

    /** The quantity of the medication in stock. */
    private int quantityStock;

    /** The expiry date of the medication. */
    private LocalDate expiryDate;

    /**
     * Constructs a new Medication object.
     * If no expiry date is provided, a random expiry date (past or future) is generated.
     * 
     * @param medID The unique identifier of the medication.
     * @param medName The name of the medication.
     * @param dose The dosage of the medication.
     * @param quantityStock The initial stock quantity of the medication.
     * @param expiryDate The expiry date of the medication (can be null, in which case a random expiry date is generated).
     */
    public Medication(String medID, String medName, String dose, int quantityStock, LocalDate expiryDate) {
        this.medID = medID;
        this.medName = medName;
        this.dose = dose;
        this.quantityStock = quantityStock;
        this.expiryDate = (expiryDate != null) ? expiryDate : generateRandomExpiryDate(); // Uses provided expiry date or generates one
    }

    /**
     * Generates a random expiry date, which can be in the past or future.
     * 
     * @return A randomly generated LocalDate representing the expiry date.
     */
    private LocalDate generateRandomExpiryDate() {
        Random rand = new Random();

        int minYears = -3; // Allows expiry up to 3 years in the past
        int maxYears = 4;  // Allows expiry up to 5 years in the future

        // Generate random year within range
        int randomYearOffset = rand.nextInt(maxYears - minYears + 1) + minYears;//rand.nextInt(9)//{0to9}+minyear
        int randomYear = LocalDate.now().getYear() + randomYearOffset;//either previous years or next years

        // Generate random month (1 to 12)
        int randomMonth = rand.nextInt(12) + 1;

        // Generate random day (1 to max days in month)
        int maxDay = LocalDate.of(randomYear, randomMonth, 1).lengthOfMonth();//first day to last day of month
        int randomDay = rand.nextInt(maxDay) + 1;

        return LocalDate.of(randomYear, randomMonth, randomDay);
    }

    // Getters

    /**
     * Retrieves the unique ID of the medication.
     * 
     * @return The medication ID.
     */
    public String getMedID() {
        return medID;
    }

    /**
     * Retrieves the name of the medication.
     * 
     * @return The medication name.
     */
    public String getMedName() {
        return medName;
    }

    /**
     * Retrieves the dosage of the medication.
     * 
     * @return The dosage of the medication.
     */
    public String getDose() {
        return dose;
    }

    /**
     * Retrieves the current stock quantity of the medication.
     * 
     * @return The stock quantity.
     */
    public int getQuantityStock() {
        return quantityStock;
    }

    /**
     * Retrieves the expiry date of the medication.
     * 
     * @return The expiry date.
     */
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    // Setters

    /**
     * Updates the medication ID.
     * 
     * @param medID The new ID for the medication.
     */
    public void setMedID(String medID) {
        this.medID = medID;
    }

    /**
     * Updates the name of the medication.
     * 
     * @param medName The new name for the medication.
     */
    public void setMedName(String medName) {
        this.medName = medName;
    }

    /**
     * Updates the dosage of the medication.
     * 
     * @param dose The new dosage for the medication.
     */
    public void setDose(String dose) {
        this.dose = dose;
    }

    /**
     * Updates the stock quantity of the medication.
     * 
     * @param quantityStock The new stock quantity.
     */
    public void setQuantityStock(int quantityStock) {
        this.quantityStock = quantityStock;
    }

    /**
     * Updates the expiry date of the medication.
     * 
     * @param expiryDate The new expiry date.
     */
    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Checks if the medication is expired.
     * 
     * @return True if the medication is expired, false otherwise.
     */
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    /**
     * Increases the stock quantity of the medication.
     * 
     * @param amount The amount to be added to the stock. Must be positive.
     */
    public void restock(int amount) {
        if (amount > 0) {
            this.quantityStock += amount;
        }
    }

    /**
     * Returns a string representation of the medication details.
     * 
     * @return A formatted string containing medication details.
     */
    @Override
    public String toString() {
        return "Medication ID: " + medID +
               ", Name: " + medName +
               ", Dose: " + dose +
               ", Stock: " + quantityStock +
               ", Expiry Date: " + expiryDate +
               ", Expired: " + (isExpired() ? "Yes" : "No");
    }
}