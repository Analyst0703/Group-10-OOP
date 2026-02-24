/**
 * Lab 1: Circle and Cylinder - Inheritance Basics
 * PT821 - Object-Oriented Programming
 * State University of Zanzibar (SUZA)
 *
 * LEARNING OBJECTIVES:
 * - Understand superclass and subclass relationships
 * - Use super() to call parent constructors
 * - Override methods using @Override annotation
 * - Demonstrate upcasting and downcasting
 *
 * INSTRUCTIONS:
 * Complete the following exercises step by step.
 * Follow the TODO comments and implement the required functionality.
 */

// ============================================================
// PART A: The Circle Class (Superclass)
// ============================================================
class Circle {

    // Private instance variables
    private double radius = 1.0;
    private String color = "red";
/*
 * TODO 1: Create a class called "Circle" with:
 */
 public Circle() {
        this.radius = 1.0;
        this.color = "red";
    }

    public Circle(double radius) {
        this.radius = radius;
        this.color = "red";
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public String toString() {
        return "Circle[radius=" + radius + ", color=" + color + "]";
    }
}



// ============================================================
// PART B: The Cylinder Class (Subclass of Circle)
// ============================================================

/*
 * TODO 2: Create a class called "Cylinder" that extends Circle with:
 *
 * Private instance variable:
 *   - height (double, default 1.0)
 *
 * Constructors (each must call super()):
 *   - Cylinder() - default values
 *   - Cylinder(double radius) - calls super(radius)
 *   - Cylinder(double radius, double height) - calls super(radius)
 *   - Cylinder(double radius, double height, String color) - calls super(radius, color)
 *
 * Public methods:
 *   - getHeight(), setHeight(double height)
 *   - getVolume() - returns getArea() * height (uses inherited getArea())
 *   - @Override toString() - returns "Cylinder[Circle[radius=?, color=?], height=?]"
 *     Hint: Use super.toString() to get the Circle part
 */

// Write your Cylinder class here:
class Cylinder extends Circle {

    private double height = 1.0;

    public Cylinder() {
        super();
        this.height = 1.0;
    }

    public Cylinder(double radius) {
        super(radius);
        this.height = 1.0;
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public Cylinder(double radius, double height, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return getArea() * height;
    }

    @Override
    public String toString() {
        return "Cylinder[" + super.toString() + ", height=" + height + "]";
    }
}

// ============================================================
// PART C: Test Driver - Upcasting and Downcasting
// ============================================================

public class Lab1_CircleCylinder {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  Lab 1: Circle and Cylinder Hierarchy");
        System.out.println("========================================\n");

        // ----- Section 1: Basic Object Creation -----
        System.out.println("--- Section 1: Basic Object Creation ---");

        // TODO 3: Create a Circle with radius 5.0 and color "blue"
        // Circle c1 = new Circle(5.0, "blue");
        // System.out.println("Circle: " + c1);
        // System.out.println("Area: " + c1.getArea());
        Circle c1 = new Circle(5.0, "blue");
        System.out.println("Circle: " + c1);
        System.out.println("Area: " + c1.getArea());
        // TODO 4: Create a Cylinder with radius 5.0, height 10.0, color "green"
        // Cylinder cy1 = new Cylinder(5.0, 10.0, "green");
        // System.out.println("\nCylinder: " + cy1);
        // System.out.println("Base Area: " + cy1.getArea());
        // System.out.println("Volume: " + cy1.getVolume());
        Cylinder cy1 = new Cylinder(5.0, 10.0, "green");
        System.out.println("\nCylinder: " + cy1);
        System.out.println("Base Area: " + cy1.getArea());
        System.out.println("Volume: " + cy1.getVolume());
        // ----- Section 2: Upcasting (Subclass to Superclass) -----
        System.out.println("\n--- Section 2: Upcasting ---");

        // TODO 5: Demonstrate upcasting
        // A Cylinder IS-A Circle, so we can assign a Cylinder to a Circle reference
        // Circle c2 = new Cylinder(3.0, 7.0, "yellow");
        // System.out.println("c2 is a: " + c2.getClass().getSimpleName());
        // System.out.println("c2.toString(): " + c2);
        // System.out.println("c2.getArea(): " + c2.getArea());  // Which getArea() is called?
        // System.out.println("c2.getRadius(): " + c2.getRadius());
        Circle c2 = new Cylinder(3.0, 7.0, "yellow");
        System.out.println("c2 is a: " + c2.getClass().getSimpleName());
        System.out.println("c2.toString(): " + c2);
        System.out.println("c2.getArea(): " + c2.getArea());
        System.out.println("c2.getRadius(): " + c2.getRadius());
        // TODO 6: Can we call getVolume() on c2? Why or why not?
        // Try uncommenting the next line. What error do you get?
        // System.out.println("c2.getVolume(): " + c2.getVolume());
        // ANSWER: yes even if it isn't defined in class Circle
        // ----- Section 3: Downcasting (Superclass to Subclass) -----
        System.out.println("\n--- Section 3: Downcasting ---");

        // TODO 7: Demonstrate downcasting
        // We need explicit cast to convert Circle reference back to Cylinder
        // Circle c3 = new Cylinder(4.0, 8.0, "purple");  // Upcast
        // Cylinder cy2 = (Cylinder) c3;                    // Downcast
        // System.out.println("After downcast: " + cy2);
        // System.out.println("Now we can call getVolume(): " + cy2.getVolume());
        Circle c3 = new Cylinder(4.0, 8.0, "purple");
        Cylinder cy2 = (Cylinder) c3;
        System.out.println("After downcast: " + cy2);
        System.out.println("Now we can call getVolume(): " + cy2.getVolume());
        // TODO 8: What happens with invalid downcasting? (ClassCastException)
        // Try uncommenting the next 2 lines. What happens?
        // Circle c4 = new Circle(2.0);
        // Cylinder cy3 = (Cylinder) c4;  // Runtime error! A Circle is NOT a Cylinder
        // ANSWER: it give out it will print becouse you downcast
        // ----- Section 4: instanceof Operator -----
        System.out.println("\n--- Section 4: instanceof Operator ---");

        // TODO 9: Use instanceof to safely check before downcasting
        // Circle[] shapes = {
        //     new Circle(2.0, "red"),
        //     new Cylinder(3.0, 5.0, "blue"),
        //     new Circle(4.0, "green"),
        //     new Cylinder(1.0, 10.0, "orange")
        // };
        //
        // for (Circle shape : shapes) {
        //     System.out.println(shape);
        //     if (shape instanceof Cylinder) {
        //         Cylinder temp = (Cylinder) shape;
        //         System.out.println("  -> This is a Cylinder! Volume = " + temp.getVolume());
        //     } else {
        //         System.out.println("  -> This is just a Circle. Area = " + shape.getArea());
        //     }
        // }
        Circle[] shapes = {
                new Circle(2.0, "red"),
                new Cylinder(3.0, 5.0, "blue"),
                new Circle(4.0, "green"),
                new Cylinder(1.0, 10.0, "orange")
        };

        for (Circle shape : shapes) {
            System.out.println(shape);
            if (shape instanceof Cylinder) {
                Cylinder temp = (Cylinder) shape;
                System.out.println("  -> This is a Cylinder! Volume = " + temp.getVolume());
            } else {
                System.out.println("  -> This is just a Circle. Area = " + shape.getArea());
            }
        }


        System.out.println("\n========================================");
        System.out.println("  End of Lab 1");
        System.out.println("========================================");
    }
}

