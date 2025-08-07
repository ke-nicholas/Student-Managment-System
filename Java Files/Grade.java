// This class stores a student's grade for a specific course.
// It includes the student ID, course code, and the score.
// It provides methods to access these details.
// It also includes a formatted string for display.

public class Grade {
    private String studentId;   // Stores the ID of the student
    private String courseCode;  // Stores the code of the course
    private double score;       // Stores the grade score

    // Constructor that initializes a grade with student ID, course code, and score
    public Grade(String studentId, String courseCode, double score) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.score = score;
    }

    // Returns the student ID
    public String getStudentId() {
        return studentId;
    }

    // Returns the course code
    public String getCourseCode() {
        return courseCode;
    }

    // Returns the grade score
    public double getScore() {
        return score;
    }

    // Updates the grade score
    public void setScore(double score) {
        this.score = score;
    }

    // Returns a formatted string showing grade details
    public String toString() {
        return "Student ID: " + studentId + ", Course Code: " + courseCode + ", Score: " + score;
    }
}