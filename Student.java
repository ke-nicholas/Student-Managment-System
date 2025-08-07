// This class represents a student in the system.
// Each student has a unique ID and a name.
// It provides methods to access these details.
// It also includes a formatted string for display.

public class Student {
    private String id;     // Stores the student's unique identifier
    private String name;   // Stores the student's name

    // Constructor that initializes a student with an ID and name
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Returns the student's ID
    public String getId() {
        return id;
    }

    // Returns the student's name
    public String getName() {
        return name;
    }

    // Returns a formatted string showing student details
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}