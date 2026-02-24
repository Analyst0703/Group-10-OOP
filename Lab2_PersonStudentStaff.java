class Person {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return name + " (" + address + ")";
    }
}

class Student extends Person {
    private String program;
    private int year;
    private double fee;

    public Student(String name, String address, String program, int year, double fee) {
        super(name, address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Student[" + super.toString() +
                ", program=" + program +
                ", year=" + year +
                ", fee=" + fee + "]";
    }
}

class Staff extends Person {
    private String department;
    private double salary;

    public Staff(String name, String address, String department, double salary) {
        super(name, address);
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Staff[" + super.toString() +
                ", department=" + department +
                ", salary=" + salary + "]";
    }
}

public class Lab2_PersonStudentStaff {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("  Lab 2: Person, Student, and Staff Hierarchy");
        System.out.println("==============================================\n");

        System.out.println("--- Section 1: Creating Objects ---");

        Person p1 = new Person("Suleiman", "Chwaka, Zanzibar");
        System.out.println("Created Person: " + p1);

        Student s1 = new Student("Tahir Ali", "Kijichi", "BITA", 2, 1500000);
        Student s2 = new Student("Ayman Juma", "Chukwani", "BCS", 1, 2000000);

        System.out.println("Created Student: " + s1);
        System.out.println("Created Student: " + s2);

        Staff st1 = new Staff("Dr. Abdul-Malik", "Tunguu", "IT Department", 3000000);
        System.out.println("Created Staff: " + st1);

        System.out.println("\n--- Section 2: Inheritance in Action ---");

        System.out.println("Student name: " + s1.getName());
        System.out.println("Student address: " + s1.getAddress());
        System.out.println("Student program: " + s1.getProgram());

        System.out.println("\nStaff name: " + st1.getName());
        System.out.println("Staff department: " + st1.getDepartment());

        s1.setAddress("Fumba, Zanzibar");
        System.out.println("\nAfter address change: " + s1);

        System.out.println("\n--- Section 3: Polymorphism ---");

        Person[] people = {
                new Person("Suleiman", "Chwaka, Zanzibar"),
                new Student("Tahir Ali", "Kijichi", "BITA", 2, 1500000),
                new Student("Ayman Juma", "Chukwani", "BCS", 1, 2000000),
                new Staff("Dr. Abdul-Malik", "Tunguu", "IT Department", 3000000)
        };

        System.out.println("All people at SUZA:");
        for (Person p : people) {
            System.out.println(" " + p);
        }

        System.out.println("\n--- Section 4: instanceof and Type Checking ---");

        int studentCount = 0;
        int staffCount = 0;

        for (Person p : people) {

            if (p instanceof Student) {
                Student s = (Student) p;
                System.out.println(s.getName() + " is a student in " +
                        s.getProgram() + " year " + s.getYear());
                studentCount++;

            } else if (p instanceof Staff) {
                Staff st = (Staff) p;
                System.out.println(st.getName() +
                        " is Staff in " + st.getDepartment());
                staffCount++;

            } else {
                System.out.println(p.getName() +
                        " is a person with no specific role.");
            }
        }

        System.out.println("\nSummary: " + studentCount +
                " students and " + staffCount + " staff members.");

        System.out.println("\n==============================================");
        System.out.println("  End of Lab 2");
        System.out.println("==============================================");
    }
}
