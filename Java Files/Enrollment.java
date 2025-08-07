// This class links a student to a course.
// It stores the student ID and the course code.
// It provides methods to access these details.
// It also includes a formatted string for display.

public class Enrollment {
    private String studentId;   // Stores the ID of the enrolled student
    private String courseCode;  // Stores the code of the course

    // Constructor that initializes an enrollment with student ID and course code
    public Enrollment(String studentId, String courseCode) {
        this.studentId = studentId;
        this.courseCode = courseCode;
    }

    // Returns the student ID
    public String getStudentId() {
        return studentId;
    }

    // Returns the course code
    public String getCourseCode() {
        return courseCode;
    }

    // Returns a formatted string showing enrollment details
    public String toString() {
        return "Student ID: " + studentId + ", Course Code: " + courseCode;
    }
}