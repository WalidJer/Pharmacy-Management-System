package models;
/**
 * The Person class represents a general person in the system.
 * It serves as a base class for patients and doctors, providing common attributes
 * such as id, name, age, and phone number.
 */
public class Person {

    // Attributes (Encapsulated)
    /** The unique identifier for a person. */
    private String id;

    /** The name of the person. */
    private String name;

    /** The age of the person. */
    private int age;

    /** The phone number of the person. */
    private String phoneNum;

    /**
     * Constructs a new Person object with specified details.
     * 
     * @param id The unique identifier for the person.
     * @param name The full name of the person.
     * @param age The age of the person.
     * @param phoneNum The contact phone number of the person.
     */
    public Person(String id, String name, int age, String phoneNum) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNum = phoneNum;
    }

    // Getters (Retrieve Values)

    /**
     * Retrieves the person's unique ID.
     * 
     * @return The ID of the person.
     */
    public String getID() {
        return id;
    }

    /**
     * Retrieves the person's name.
     * 
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the person's age.
     * 
     * @return The age of the person.
     */
    public int getAge() {
        return age;
    }

    /**
     * Retrieves the person's phone number.
     * 
     * @return The phone number of the person.
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    // Setters (Modify Values)

    /**
     * Updates the person's id.
     * 
     * @param id The new id to set for the person.
     */
    public void setID(String id) {
        this.id = id;
    }

    /**
     * Updates the person's name.
     * 
     * @param name The new name to set for the person.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Updates the person's age.
     * 
     * @param age The new age to set for the person.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Updates the person's phone number.
     * 
     * @param phoneNum The new phone number to set for the person.
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    

    /**
     * Returns a string representation of the person's details.
     * 
     * @return A formatted string containing the person's id, name, age, and phone number.
     */
    @Override
    public String toString() {
        return "Person ID: " + this.id +
               ", Name: " + this.name +
               ", Age: " + this.age +
               ", Phone: " + this.phoneNum;
    }
}