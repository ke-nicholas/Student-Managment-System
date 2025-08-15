import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static Scanner scanner = new Scanner(System.in);
    public static List<Student> students = new ArrayList<>();
    public static List<Course> courses = new ArrayList<>();
    public static List<Grade> grades = new ArrayList<>();
    public static List<Enrollment> enrollments = new ArrayList<>();



    public static void main(String[] a) {
        FileHandling.loadStudentData();
        FileHandling.loadCourseData();
        FileHandling.loadEnrollmentData();
        FileHandling.loadGradeData();
        System.out.println("Nb//REMEMBER TO EXIT SO THAT YOU SAVE YOUR WORK");

        while (true) {
            System.out.println("==Welcome To Main Menu:==");
            System.out.println("1.Student Details");
            System.out.println("2.Course Details");
            System.out.println("3.Enrollments Details");
            System.out.println("4.Grades Details");
            System.out.println("0- Exit");

            System.out.println();
            System.out.println("Enter Choice");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("==Student Options== ");
                    System.out.println("1.Register New Student");
                    System.out.println("2.View Students");
                    System.out.println("3.Update Student Details");
                    System.out.println("4.Search Student ");
                    System.out.println("5.Delete Student");
                    System.out.println("0-Exit");
                    System.out.println("Enter Choice:");
                    int answer = scanner.nextInt();
                    scanner.nextLine();
                    if (answer == 1) {
                        registerStudent();
                        break;
                    } else if (answer == 2) {
                        viewStudents();
                        break;

                    } else if (answer == 3) {
                        updateDetails();
                        break;

                    } else if (answer == 0) {
                        System.out.println("Exiting--To-Main Menu");
                        break;
                    }
                    break;
                case 2:
                    System.out.println("==Course Options== ");
                    System.out.println("1.Register New Course");
                    System.out.println("2.View Available Courses");
                    System.out.println("0-Exit");
                    int course = scanner.nextInt();
                    scanner.nextLine();
                    if (course == 1) {
                        addCourse();
                        break;
                    } else if (course == 2) {
                        viewCourses();
                        break;
                    } else if (course == 0) {
                        System.out.println("Exiting--To-Main Menu");
                        break;
                    }
                    break;
                case 3:
                    System.out.println("==Enrollment Options== ");
                    System.out.println("1.Enrol A Student");
                    System.out.println("2.View Course Enrollments");
                    System.out.println("3.View Enrollment By StudentID");
                    System.out.println("0-Exit");
                    int enrollment = scanner.nextInt();
                    scanner.nextLine();
                    if (enrollment == 1) {
                        enrollStudent();
                        break;
                    } else if (enrollment == 2) {
                        viewEnrollments();
                        break;
                    } else if (enrollment == 3) {
                        viewstudentEnrollment();
                        break;
                    } else if (enrollment == 0) {
                        System.out.println("Exiting--To-Main Menu");
                        break;
                    }
                    break;

                case 4:
                    System.out.println("==Grade Section==");
                    System.out.println("1.Record Student Grades");
                    System.out.println("2.View Grades For All Courses");
                    System.out.println("0-Exit");
                    int grade = scanner.nextInt();
                    scanner.nextLine();
                    if (grade == 1) {
                        recordGrades();
                        break;
                    } else if (grade == 2) {
                        viewCourseGrades();
                        break;
                    } else if (grade == 0) {
                        System.out.println("Exiting--To-Main Menu");
                        break;
                    }
                    break;
                case 0:
                    FileHandling.saveStudentData();
                    FileHandling.saveCourseData();
                    FileHandling.saveEnrollmentData();
                    FileHandling.saveGradeData();
                    return;
            }

            System.out.println();
        }


    }//End OF MAIN

    //Register Student
    static void registerStudent() {
        System.out.println("Enter Student Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Student ID:");
        int studentID = scanner.nextInt();
        scanner.nextLine();

        students.add(new Student(name, studentID));
        System.out.println("Student Added Successfully");
    }

    //View Students
    static void viewStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }


    //Update Student Details
    static void updateDetails() {
        System.out.println("Enter Student ID:");
        int studentID = scanner.nextInt();
        scanner.nextLine();
        for (Student student : students) {
            if (studentID == student.getStudentID()) {
                System.out.println(student.getStudentID() + ":" + student.getStudentName() + " -Student Found");
                System.out.println("Enter new Student Name:");
                String name = scanner.nextLine();
                student.setStudentName(name);
                System.out.println("Student Details Updated Sucessfully");

                System.out.println();
                System.out.println("New Student Details:");
                System.out.println(student);
            }
        }


    }

    static void addCourse() {
        System.out.println("==Add New Course==");
        System.out.println("Enter Course Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Course Code:");
        String courseCode = scanner.nextLine().toUpperCase();
        courses.add(new Course(courseCode, name));
        System.out.println("Course Added Sucessfully");

    }

    // 6. View all available courses
    public static void viewCourses() {
        System.out.println("\n--- COURSES ---");
        for (Course courses : courses) {
            System.out.println(courses);
        }
    }


    //3. Enroll a student in a course
    static void enrollStudent() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();

        int newStudentID = Integer.parseInt(studentId);

        boolean studentfound = false;
        boolean coursefound = false;
        boolean studentenrolled = false;
        for (Student student : students) {
            if (student.getStudentID() == newStudentID) {
                System.out.println("Student Found- " + student);
                System.out.print("Enter course code: ");
                String courseCode = scanner.nextLine().toUpperCase();
                studentfound = true;
                for (Course course : courses) {
                    if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                        coursefound = true;
                        for (Enrollment enrollment : enrollments) {
                            if (enrollment.getStudentID().equalsIgnoreCase(studentId) & enrollment.getCourseCode().equalsIgnoreCase(courseCode)) {
                                studentenrolled = true;
                                System.out.println("Student is Already Enrolled in this Course");
                            }
                        }
                        if (!studentenrolled) {
                            enrollments.add(new Enrollment(courseCode, studentId));
                            System.out.println("Enrollment successful.");
                        }
                    }
                }


            }
        }
        if (!studentfound) {
            System.out.println("Student Not Found,Kindly Register !");
        } else if (!coursefound) {
            System.out.println("Course Not Found");
        }


    }

    //7. View students enrolled in a specific course
    public static void viewEnrollments() {
        System.out.println("\n--- AVAILABLE COURSES ---");
        for (Course courses : courses) {
            System.out.println(courses);
        }

        System.out.print("Enter course code to view enrollments: ");
        String courseCode = scanner.nextLine();

        //Loop through the courses
        for (Course courses : courses) {
            //Checks if true
            if (courses.getCourseCode().equalsIgnoreCase(courseCode)) {
                System.out.println("\n--- ENROLLMENTS FOR " + courseCode + "---" + courses.getCourseName());
                break;
            }
        }//End of for loop
        for (Enrollment enrolled : enrollments) {
            if (enrolled.getCourseCode().equalsIgnoreCase(courseCode)) {
                for (Student student : students) {
                    int enrolledID = Integer.parseInt(enrolled.getStudentID());
                    if (student.getStudentID() == enrolledID) {
                        System.out.println(student);
                        break;
                    }
                }//End of for loop-Student
            }//End of if statement-Check course code match

        }//End of for loop -enrollments


    }


    public static void viewstudentEnrollment() {
        System.out.println("===Student Enrollment===");
        System.out.println();
        System.out.println("Available Students:");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println();
        System.out.println("Enter Student Code/ID:");
        int studentID = scanner.nextInt();

        boolean studentfound = false;
        boolean enrolled = false;
        for (Student student : students) {
            if (student.getStudentID() == studentID) {
                studentfound = true;
                for (Enrollment enrollment : enrollments) {
                    int enrolledstudent = Integer.parseInt(enrollment.getStudentID());
                    if (enrolledstudent == studentID) {
                        enrolled = true;
                        for (Course c : courses) {
                            if (c.getCourseCode().equalsIgnoreCase(enrollment.getCourseCode())) {
                                System.out.println(c.getCourseName() + ":" + enrollment.getCourseCode());
                                break;
                            }
                        }

                    }
                }
            }
        }
        if (!studentfound) {
            System.out.println("Student Not Found !!");
        } else if (!enrolled) {
            System.out.println("Student Not Enrolled !!");
        }


    }

    //4.Record grades for students in a selected course
    public static void recordGrades() {
        System.out.println("==Record Student Grade==");
        System.out.println("Enter Student ID:");
        String studentID=scanner.nextLine();
        int newstudentID=Integer.parseInt(studentID);

        boolean studentfound=false;
        boolean studentenrolled=false;
        for (Student student:students){
            if (student.getStudentID()==newstudentID){
                studentfound=true;
                System.out.println("Student Found- "+student.getStudentName());

                System.out.println();
                System.out.println("Enter Course Code:");
                String courseCode=scanner.nextLine().trim().toUpperCase();
                for(Enrollment enrollment:enrollments){
                    if (enrollment.getStudentID().equalsIgnoreCase(studentID)&&enrollment.getCourseCode().equalsIgnoreCase(courseCode)){
                        studentenrolled=true;
                        System.out.println("Hello");
                        boolean coursefound=false;
                        for (Course course:courses){
                            if (course.getCourseCode().equals(courseCode)){
                                coursefound=true;

                                boolean checkgraded=false;

                                for (Grade grade:grades){
                                    if (grade.getStudentID()==newstudentID&&grade.getCourseCode().equals(courseCode)){
                                        System.out.println("Student is Already Graded");
                                        checkgraded=true;
                                        System.out.println();
                                        System.out.println("Would you like to Update Marks:1-YES");
                                        System.out.println("1-YES,2-NO");
                                        int choice=scanner.nextInt();
                                        if (choice==1){
                                            System.out.println("Enter New Marks:");
                                            int marks=scanner.nextInt();
                                            grade.setMarks(marks);
                                            System.out.println("Marks Updated Successfully");

                                        }
                                        else {
                                            System.out.println("Safely Exciting Grade Section");
                                            break;
                                        }
                                        break;
                                    }
                                }
                                if (!checkgraded){
                                    System.out.println("Enter Course Marks:");
                                    int courseMarks=scanner.nextInt();
                                    scanner.nextLine();

                                    grades.add(new Grade(newstudentID,courseCode,courseMarks));
                                    System.out.println("Grade Recorded Successfully");
                                    break;
                                }
                            break;
                            }
                        }
                        if (!coursefound){
                            System.out.println("Course Not Found in List");
                            break;
                        }



                    break;
                    }

                }
                if (!studentenrolled){
                    System.out.println("Student Not Enrolled In Course");
                    break;
                }
                break;
            }
        }
        if (!studentfound){
            System.out.println("Student Not Registered !!");
        }

    }


    //8. View grades for a specific course
    public static void viewCourseGrades() {
        System.out.println("\n--- AVAILABLE COURSES ---");
        for (Course courses : courses) {
            System.out.println(courses);
        }

        System.out.print("Enter course code to view grades: ");
        String courseCode = scanner.nextLine();

        System.out.println("\n--- GRADES FOR " + courseCode + " ---");
        for (Grade grades : grades) {
            if (grades.getCourseCode().equalsIgnoreCase(courseCode)) {
                for (Student student:students){
                    if (student.getStudentID()== grades.getStudentID()){
                        System.out.println(grades.getStudentID()+":"+student.getStudentName()+"- "+ grades.getMarks());
                        break;
                    }
                }

            }
        }
    }


}