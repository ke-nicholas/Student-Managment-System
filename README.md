
**Student Management Program**
**Overview**
The Student Management Program is a Java-based CLI application designed to manage student records, course enrollments, and grades. It offers a simple, interactive way to handle academic tasks, making it ideal for learning Java or managing small-scale student data.
Features
•	Register new students with unique IDs and names.
•	Add and manage courses with codes and titles.
•	Enroll students in courses.
•	Record and view grades for students across courses.
•	View all courses, enrollments by course, grades by course, or individual student grades.
•	Case-insensitive search for student IDs and course codes.
•	Capitalize student names for consistent display.

**Prerequisites**
•	Java Development Kit (JDK): Version 8 or higher installed on your computer.
Installation
1.	Download the pre-built JAR file (StudentManagement.jar) from the Releases section of this repository.
2.	Save the JAR file to a directory on your computer.
3.	
**Usage**
**Running the Program**
•	Ensure the JDK is installed and configured (run java -version in your terminal to verify).
•	Open a terminal or command prompt.
•	Navigate to the directory containing StudentManagement.jar using cd (e.g., cd path/to/directory).
•	Run the program with the following command:
text
java -jar StudentManagement.jar
•	The main menu will appear with numbered options.

**Menu Options**
1.	Register Student: Enter a student ID and name to add a new student (e.g., "2629" and "Carol Wangari").
2.	Add Course: Input a course code and title (e.g., "CS101" and "Computer Science").
3.	Enroll Student in Course: Provide a student ID and course code (e.g., "2629" and "CS101").
4.	Record Student Grades: Enter a student ID, course code, and grade (e.g., "2629", "CS101", "85.0").
5.	View All Courses: Lists all registered courses.
6.	View Enrollment by Course: Enter a course code to see enrolled students.
7.	View Grades by Course: Enter a course code to see grades.
8.	View Student Grades: Enter a student ID to view grades (or "No Grades Available").
9.	Exit: Terminates the program.
10.	
**Example Interaction**
text
--- MAIN MENU ---
1. Register Student
2. Add Course
3. Enroll Student in Course
4. Record Student Grades
5. View All Courses
6. View Enrollment by Course
7. View Grades by Course
8. View Student Grades
9. Exit
Select an option: 8
==Available Students==
ID: 2629, Name: Carol Wangari
ID: 2630, Name: Nicholas Mukirai
Enter Student ID: 2629
==Student: Carol Wangari==
English: 90.0
Mathematics: 85.0


**Notes**
•	Case-insensitive: Use any case for IDs or codes (e.g., "cs101" or "CS101").
•	Error Handling: Displays messages like "Student Not Found" if data is missing.
•	Data Storage: In-memory only; resets on restart. Add file I/O for persistence if needed.

**Customization**
•	Modify capitalizeAllNames to adjust name formatting.
•	Extend with features like deleting students or saving data.

**Contributing**
Fork this repository, make improvements, and submit pull requests. Suggestions are welcome!

