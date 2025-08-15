public class Grade {

    private String courseCode;
    public int studentID;
    private int marks;

    public Grade(int studentID, String courseCode, int marks) {
        this.courseCode = courseCode;
        this.marks = marks;
        this.studentID=studentID;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return getStudentID()+":"+getCourseCode()+":"+getMarks();
    }
}
