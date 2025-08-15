public class Student {

    private String StudentName;
    private int studentID;

    public Student(String studentName, int studentID) {
        StudentName = studentName;
        this.studentID = studentID;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return getStudentName()+":"+getStudentID();
    }
}
