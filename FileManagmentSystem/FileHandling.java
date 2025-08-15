import java.io.*;

public class FileHandling {

    //1.Load Data
    public static void loadStudentData() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Student.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String parts[] = line.split(":");

                String name = parts[0].trim();
                int id = Integer.parseInt(parts[1].trim());

                Main.students.add(new Student(name, id));
            }
            System.out.println("Files Loaded Successfully");
        } catch (IOException e) {
            System.out.println("No Saved Data  , Starting A Fresh .");
        }
    }


    //2.Save Data
    public static void saveStudentData() {
        try {
           BufferedWriter writer = new BufferedWriter(new FileWriter("Student.txt"));
            for (Student student : Main.students) {
                writer.write(student.getStudentName() + ":" + student.getStudentID());
                writer.newLine();
            }
            writer.close();
            System.out.println("Data Saved Successfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void loadCourseData() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Course.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String parts[] = line.split(":");

                String coursecode = parts[0].trim();
                String courseName = parts[1].trim();

                Main.courses.add(new Course(coursecode, courseName));
            }
            System.out.println("Course Files Loaded Successfully");
        } catch (IOException e) {
            System.out.println("No Course Data  , Starting A Fresh .");
        }
    }

    public static void saveCourseData(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Course.txt"));
            for (Course course : Main.courses) {
                writer.write(course.getCourseName() + ":" + course.getCourseCode());
                writer.newLine();
            }
            writer.close();
            System.out.println("Course Data Saved Successfully");
        } catch (IOException e) {
            System.out.println("Course Data Not Saved");
        }
    }


    public static void loadEnrollmentData() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Enrollment.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String parts[] = line.split(":");

                String coursecode = parts[0].trim();
                String studentID = parts[1].trim();

                Main.enrollments.add(new Enrollment(coursecode,studentID));
            }
            System.out.println("Enrollement Files Loaded Successfully");
        } catch (IOException e) {
            System.out.println("No Enrollment Data  , Starting A Fresh .");
        }
    }

    public static void saveEnrollmentData(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Enrollment.txt"));
            for (Enrollment enrollment : Main.enrollments) {
                writer.write(enrollment.getCourseCode() + ":" + enrollment.getStudentID());
                writer.newLine();
            }
            writer.close();
            System.out.println("Enrollment Data Saved Successfully");
        } catch (IOException e) {
            System.out.println("Enrollment Data Not Saved");
        }
    }




    public static void saveGradeData(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Grade.txt"));
            for (Grade grades : Main.grades) {
                writer.write(grades.getStudentID() + ":" + grades.getCourseCode()+":"+ grades.getMarks());
                writer.newLine();
            }
            writer.close();
            System.out.println("Grade Data Saved Successfully");
        } catch (IOException e) {
            System.out.println("Grade Data Not Saved");
        }
    }

    public static void loadGradeData() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Grade.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String parts[] = line.split(":");

                String studentID = parts[0].trim();
                int newstudentID=Integer.parseInt(studentID);
                String courseCode= parts[1].trim();
                String marks=parts[2];
                int newmarks=Integer.parseInt(marks.trim());

                Main.grades.add(new Grade(newstudentID,courseCode,newmarks));
            }
            System.out.println("Grades Files Loaded Successfully");
        } catch (IOException e) {
            System.out.println("No Grades Data  , Starting A Fresh .");
        }
    }


}
