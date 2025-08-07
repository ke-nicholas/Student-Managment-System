import java.util.*;

public class Main {

    // Static lists to store all data
    static List<Student> students = new ArrayList<Student>();
    static List<Course> courses = new ArrayList<Course>();
    static List<Enrollment> enrollments = new ArrayList<Enrollment>();
    static List<Grade> grades = new ArrayList<Grade>();

    // Main method — entry point of the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Load sample data directly
        students.add(new Student("2629", "Carol Wangari"));
        students.add(new Student("2630","Nicholas Mukirai"));

        courses.add(new Course("C1", "English"));
        courses.add(new Course("C2", "Kiswahili"));
        courses.add(new Course("C3","Mathematics"));
        courses.add(new Course("C4","Agriculture"));

        enrollments.add(new Enrollment("2629","C1"));
        enrollments.add(new Enrollment("2629","C2"));
        enrollments.add(new Enrollment("2629","C3"));
        enrollments.add(new Enrollment("2629","C4"));
        //enrollments.add(new Enrollment("2630","C4"));



        grades.add(new Grade("2629","C1",90));
        grades.add(new Grade("2629","C2",79));
        grades.add(new Grade("2629","C3",65));
        grades.add(new Grade("2629","C4",88));

        String name="Nicholas";


        // Menu loop
        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Register Student");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Student in Course");
            System.out.println("4. Record Student Grades");
            System.out.println("5. View All Students");
            System.out.println("6. View All Courses");
            System.out.println("7. View Enrollment by Course");
            System.out.println("8. View Grades by Course");
            System.out.println("9. View Student Grades");
            System.out.println("10.View Enrollment By Student");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 0) {
                System.out.println("Exiting program...");
                break;
            } else if (choice == 1) {
                registerStudent(scanner);
            } else if (choice == 2) {
                addCourse(scanner);
            } else if (choice == 3) {
                enrollStudent(scanner);
            } else if (choice == 4) {
                recordGrades(scanner);
            } else if (choice == 5) {
                viewStudents();
            } else if (choice == 6) {
                viewCourses();
            } else if (choice == 7) {
                viewEnrollments(scanner);
            } else if (choice == 8) {
                viewCourseGrades(scanner);
            } else if (choice == 9) {
                viewStudentGrades(scanner);
            } else if (choice==10) {
                viewstudentEnrollment(scanner);
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }

    //1. Register a new student
    public static void registerStudent(Scanner scanner) {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        students.add(new Student(id, name));
        System.out.println("Student registered Successfully.");
    }

    //2. Add a new course
    public static void addCourse(Scanner scanner) {
        System.out.print("Enter course code: ");
        String code = scanner.nextLine();
        System.out.print("Enter course title: ");
        String title = scanner.nextLine();
        courses.add(new Course(code, title));
        System.out.println("Course added Successfully.");
    }

    //3. Enroll a student in a course
    public static void enrollStudent(Scanner scanner) {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        enrollments.add(new Enrollment(studentId, courseCode));
        System.out.println("Enrollment successful.");
    }

    //4.Record grades for students in a selected course
    public static void recordGrades(Scanner scanner) {
        System.out.println("\n--- AVAILABLE COURSES ---");
        for (Course courses:courses){
            System.out.println(courses);
        }

        System.out.print("Enter course code to record grades: ");
        String courseCode = scanner.nextLine();

        for (Course courses:courses){
            if (courses.getCode().equalsIgnoreCase(courseCode)){

                System.out.println("Enter Student ID:");
                String studentID=scanner.nextLine();

                boolean enrolled =false;
                for (Enrollment enrollment:enrollments){
                    if (enrollment.getStudentId().equalsIgnoreCase(studentID) & enrollment.getCourseCode().equalsIgnoreCase(courseCode)){
                        System.out.println("Enter Course Grade:");
                        Double courseGrade=scanner.nextDouble();

                        scanner.nextLine();

                        grades.add(new Grade(studentID,courseCode,courseGrade));

                        System.out.println();
                        System.out.println("Student ID:"+studentID+" Course Code:"+courseCode+" Grade:"+courseGrade);
                        System.out.println("Grade Successfully Added");
                        enrolled=true;
                        break;
                    }
                }
                if (!enrolled){
                    System.out.println("Student ID:"+studentID+" is Not Enrolled !!");
                }


            }
        }


    }

    //5. View all registered students
    public static void viewStudents() {
        System.out.println("\n--- STUDENTS ---");
        for (Student students:students) {
            System.out.println(students);
        }
    }





    // 6. View all available courses
    public static void viewCourses() {
        System.out.println("\n--- COURSES ---");
        for (Course courses:courses){
            System.out.println(courses);
        }
    }

    //7. View students enrolled in a specific course
    public static void viewEnrollments(Scanner scanner) {
        System.out.println("\n--- AVAILABLE COURSES ---");
        for(Course courses:courses){
            System.out.println(courses);
        }

        System.out.print("Enter course code to view enrollments: ");
        String courseCode = scanner.nextLine();

        //Loop through the courses
        for(Course courses:courses){
            //Checks if true
            if (courses.getCode().equalsIgnoreCase(courseCode)) {
                System.out.println("\n--- ENROLLMENTS FOR " + courseCode + "---" + courses.getTitle());
                break;
            }
        }//End of for loop
        for (Enrollment enrolled : enrollments) {
            if (enrolled.getCourseCode().equalsIgnoreCase(courseCode)) {
                for (Student student : students) {
                    if (student.getId().equalsIgnoreCase(enrolled.getStudentId())) {
                        System.out.println(student);
                    break;
                    }
                }//End of for loop-Student
            }//End of if statement-Check course code match

        }//End of for loop -enrollments


    }

    //8. View grades for a specific course
    public static void viewCourseGrades(Scanner scanner) {
        System.out.println("\n--- AVAILABLE COURSES ---");
        for(Course courses:courses){
            System.out.println(courses);
        }

        System.out.print("Enter course code to view grades: ");
        String courseCode = scanner.nextLine();

        System.out.println("\n--- GRADES FOR " + courseCode + " ---");
        for (Grade grades:grades) {
            if (grades.getCourseCode().equalsIgnoreCase(courseCode)) {
                System.out.println(grades);
            }
        }
    }

    //9. View all recorded grades
    public static void viewStudentGrades(Scanner scanner) {
        System.out.println("==Available Students==");
        for (Student student:students){
            System.out.println(student);
        }
        //
        System.out.println("Enter Student ID:");
        String studentID=scanner.nextLine();


        boolean studentfound=false;
        for (Student student:students){
            if (student.getId().equalsIgnoreCase(studentID)){
                System.out.println("==Student:"+student.getName()+"==");
                studentfound=true;
                break;
            }

        }//end of loop

        if (!studentfound){
            System.out.println("Student Not Found !!");
        }

        boolean gradesfound=false;
        for (Grade grades:grades){
            if (grades.getStudentId().equalsIgnoreCase(studentID)){
                for(Course courses:courses){
                    if (courses.getCode().equalsIgnoreCase(grades.getCourseCode())){
                        System.out.println(courses.getTitle()+"-"+grades.getScore());
                        gradesfound=true;
                        break;
                    }
                }


            }

        }
        if(!gradesfound){
            System.out.println("No Grades Available !!");
        }





    }//End of Method

    public static void viewstudentEnrollment(Scanner scanner){
        System.out.println("===Student Enrollment===");
        System.out.println();
        System.out.println("Available Students:");
        for (Student student:students){
            System.out.println(student);
        }

        System.out.println();
        System.out.println("Enter Student Code/ID:");
        String studentID=scanner.nextLine();

        boolean studentfound=false;
        boolean enrolled=false;
        for (Student student:students){
            if (student.getId().equalsIgnoreCase(studentID)){
                studentfound=true;
                for (Enrollment enrollment:enrollments){
                    if (enrollment.getStudentId().equalsIgnoreCase(studentID)){
                        enrolled=true;
                        for (Course course:courses){
                            if (course.getCode().equalsIgnoreCase(enrollment.getCourseCode())){
                                System.out.println(course.getTitle()+":Code:"+enrollment.getCourseCode());
                            }
                        }

                    }
                }
            }
        }
        if (!studentfound){
            System.out.println("Student Not Found !!");
        } else if (!enrolled) {
            System.out.println("Student Not Enrolled !!");
        }


    }






 //End of class
}