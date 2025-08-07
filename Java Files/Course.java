// This class represents a course or subject in the system.
// Each course has a unique code and a title.
// It provides methods to access these details.
// It also includes a formatted string for display.

public class Course {
    private String code;    // Stores the course code
    private String title;   // Stores the course title

    // Constructor that initializes a course with a code and title
    public Course(String code, String title) {
        this.code = code;
        this.title = title;
    }

    // Returns the course code
    public String getCode() {
        return code;
    }

    // Returns the course title
    public String getTitle() {
        return title;
    }

    // Returns a formatted string showing course details
    public String toString() {
        return "Code: " + code + ", Title: " + title;
    }
}