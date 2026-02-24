/**
 * Write a description of class Student here.
 *
 * @author (Group 10)
 * @version (12.02.2026)
 */
class Point {

    private double x = 0.0;
    private double y = 0.0;

    //Constructors
    public Point() {
        this.x = 0.0;
        this.y = 0.0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Methods
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double[] getXY() {
        return new double[]{x, y};
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

class MovablePoint extends Point {

    private double xSpeed = 0.0;
    private double ySpeed = 0.0;

    //Constructors
    public MovablePoint() {
        super();
        this.xSpeed = 0.0;
        this.ySpeed = 0.0;
    }

    public MovablePoint(double xSpeed, double ySpeed) {
        super();
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(double x, double y, double xSpeed, double ySpeed) {
        super(x, y); 
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public double getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    public double getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(double xSpeed, double ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public double[] getSpeed() {
        return new double[]{xSpeed, ySpeed};
    }

    public MovablePoint move() {
        setX(getX() + xSpeed);
        setY(getY() + ySpeed);
        return this;
    }

    @Override
    public String toString() {
        return super.toString() +
                " speed=(" + xSpeed + ", " + ySpeed + ")";
    }
}

public class Lab3_PointMovablePoint {

    public static void main(String[] args) {

        System.out.println("  Lab 3: Point and MovablePoint");

        System.out.println("--- Section 1: Point Objects ---");

        Point p1 = new Point();
        System.out.println("Default point: " + p1);

        Point p2 = new Point(3.0, 4.0);
        System.out.println("Point at (3, 4): " + p2);

        p2.setX(5.0);
        p2.setY(6.0);
        System.out.println("After setX(5), setY(6): " + p2);

        double[] coords = p2.getXY();
        System.out.println("getXY() = [" + coords[0] + ", " + coords[1] + "]");

        System.out.println("\n--- Section 2: MovablePoint Objects ---");

        MovablePoint mp1 = new MovablePoint(0.0, 0.0, 2.0, 3.0);
        System.out.println("Initial position: " + mp1);

        System.out.println("X coordinate: " + mp1.getX());
        System.out.println("Y coordinate: " + mp1.getY());

        System.out.println("\n--- Section 3: Movement ---");

        System.out.println("Before move: " + mp1);
        mp1.move();
        System.out.println("After 1st move: " + mp1);
        mp1.move();
        System.out.println("After 2nd move: " + mp1);
        mp1.move();
        System.out.println("After 3rd move: " + mp1);

        mp1.setSpeed(1.0, -1.0);
        System.out.println("\nSpeed changed to (1.0, -1.0)");
        mp1.move();
        System.out.println("After move: " + mp1);
        mp1.move();
        System.out.println("After move: " + mp1);


        System.out.println("\n--- Section 4: Polymorphism ---");

        Point p3 = new MovablePoint(1.0, 1.0, 0.5, 0.5);
        System.out.println("p3 (Point ref): " + p3);
        System.out.println("p3 class: " + p3.getClass().getSimpleName());

        // p3.move(); 
        // ANSWER:
        // No, We can not call move() on p3 because it cannot compile since move() is not defined in Point.

        if (p3 instanceof MovablePoint) {
            MovablePoint mp2 = (MovablePoint) p3;
            mp2.move();
            System.out.println("After downcast and move: " + mp2);
            System.out.println("p3 also changed: " + p3);
        }

        System.out.println("\n--- Section 5: Simple Movement Simulation ---");

        MovablePoint[] points = {
                new MovablePoint(0.0, 0.0, 1.0, 1.0),
                new MovablePoint(10.0, 0.0, -1.0, 0.5),
                new MovablePoint(5.0, 5.0, 0.0, -2.0)
        };

        System.out.println("Starting positions:");
        for (int i = 0; i < points.length; i++) {
            System.out.println("  Point " + (i + 1) + ": " + points[i]);
        }

        for (int step = 1; step <= 5; step++) {
            System.out.println("\nStep " + step + ":");
            for (int i = 0; i < points.length; i++) {
                points[i].move();
                System.out.println("  Point " + (i + 1) + ": " + points[i]);
            }
        }

    }
}


/*
 * QUESTIONS TO ANSWER:
 * 
 * ANSWERS:
 *
 * 1. We can't MovablePoint directly access x and y (e.g., x += xSpeed) because x and y are declared private in the Point class since
 *    private variables are not accessible directly in subclasses.
 *    
 * 2. The advantage of using getters/setters to access parent fields is to makes code more maintainable and secure.
 *
 * 3. Changing mp2 also change p3, because of the downcasting both mp2 and p3 refer to the same object in memory.
 *
 * 4. Yes.
 *    We would need to declare move() in the Point class (possibly as an abstract method).
 *    Then override it in MovablePoint.In that way, polymorphism would allow calling move() using a Point reference.
 */
 