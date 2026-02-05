/**
 * Write a description of class Course here.
 *
 * @author (Group 10)
 * @version (05/02/2026)
 */
public class Course {

   
    private String courseCode;
    private String courseName;
    private String instructorName;
    private int creditHours;
    private int maxCapacity;
    private int enrolledStudents;
    private boolean isActive;

    
    public Course() {
        this.courseCode = "Unknown";
        this.courseName = "Unknown";
        this.instructorName = "None";
        this.creditHours = 3;
        this.maxCapacity = 30;
        this.enrolledStudents = 0;
        this.isActive = true;
    }
    
    
    public Course(String courseCode, String courseName, int creditHours, int maxCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        setCreditHours(creditHours);
        setMaxCapacity(maxCapacity);
        this.instructorName = "None";
        this.enrolledStudents = 0;
        this.isActive = true;
    }

    
     public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public boolean isActive() {
        return isActive;
    }
    
    
    public void setCreditHours(int creditHours) {
        if (creditHours >= 1 && creditHours <= 6) {
            this.creditHours = creditHours;
        } else {
            System.out.println("Credit hours must be between 1 and 6.");
        }
    }

    public void setMaxCapacity(int maxCapacity) {
        if (maxCapacity > 0) {
            this.maxCapacity = maxCapacity;
        } else {
            System.out.println("Max capacity must be greater than 0.");
        }
    }

    
    public void assignInstructor(String name) {
        this.instructorName = name;
        System.out.println("Instructor " + name + " assigned to course " + courseCode);
    }

    
    public boolean enrollStudent() {
        if (enrolledStudents < maxCapacity && isActive) {
            enrolledStudents++;
            return true;
        } else {
            System.out.println("Cannot enroll: course full or inactive.");
            return false;
        }
    }

    
    public boolean dropStudent() {
        if (enrolledStudents > 0) {
            enrolledStudents--;
            return true;
        } else {
            System.out.println("No students to drop.");
            return false;
        }
    }

    
     public int getAvailableSeats() {
        return maxCapacity - enrolledStudents;
    }
    
    
    public boolean isFull(){
        return enrolledStudents >= maxCapacity;
    }
    
    
    public void cancelCourse(){
        if (enrolledStudents == 0){
            isActive = false;
            System.out.println("Course " + courseCode + " has been canceled.");
        }
    }

    
    public void displaycourseInfo(){
        System.out.println("\n=== Course Info ===");
        System.out.println("Course Code: " + courseCode);
        System.out.println("Course Name: " + courseName);
        System.out.println("Instructor: " + instructorName);
        System.out.println("Credit Hours: " + creditHours);
        System.out.println("Max Capacity: " + maxCapacity);
        System.out.println("Enrolled Students: " + enrolledStudents);
        System.out.println("Available Seats: " + getAvailableSeats());
        System.out.println("Active: " + (isActive ? "Yes" : "No"));
    }

    public static void main(String[] args) {
        System.out.println("=== University Course Exercise ===\n");

        
        Course course1 = new Course("PT821", "Ibject-Oriented Programming", 3, 40);
        course1.assignInstructor("Dr. Baho");
        course1.enrollStudent();
        course1.enrollStudent();
        course1.displaycourseInfo();

        
        Course course2 = new Course("PT822", "Database Systems", 3, 30);
        course2.assignInstructor("Prof. Miss power");
        for (int i = 0; i < 30; i++) {
            course2.enrollStudent();
        }
        course2.displaycourseInfo();


        
        for (int i = 0; i < 5; i++) {
        boolean enrolled = course1.enrollStudent();
            if (!enrolled) {
                System.out.println("Could not enroll student " + (i + 1) + ": course full or inactive.");
            }
        }

        
        System.out.println("Available seats in " + course1.getCourseCode() + ": " + course1.getAvailableSeats());
        System.out.println("Is " + course1.getCourseCode() + " full? " + (course1.isFull() ? "Yes" : "No"));
        
        for (int i = 0; i < 3; i++) {
            course1.dropStudent();
        }

        
        course1.displaycourseInfo();
        course2.displaycourseInfo();

        System.out.println("\n=== Exercise Complete ===");
    }
}
