public class Enrollment {

    private String courseCode;
    private String studentID;

    public Enrollment(String courseCode, String studentID) {
        this.courseCode = courseCode;
        this.studentID = studentID;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return getCourseCode()+":"+ getStudentID();
    }
}
