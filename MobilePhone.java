/**
 * Write a description of class MobilePhone here.
 *
 * @author (Group 10)
 * @version (05/02/2026)
 */
public class MobilePhone {

    private String model;
    private String brand;
    private double price;
    private int batteryLevel;
    private boolean isOn;

   public MobilePhone() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.price = 0;
        this.batteryLevel = 100;
        this.isOn = false;
    }

    public MobilePhone(String brand,String model, double price){
        this.brand = brand;
        this.model = model;
        setPrice(price);
        this.batteryLevel = 100;
        this.isOn = false;
    }

    public String getBrand(){
        return brand;
    }
    public String getModel(){
        return model;
    }
    public double getPrice(){
        return price;
    }
    public int getBettryLevel(){
        return batteryLevel;
    }
    public boolean getIsOn(){
        return isOn;
    }

    public void setPrice(double price){
        if(price > 0){
            this.price =price;
        }
        else{
            System.out.println("invalid price");
        }
    }
    public void setBatteryLevel(int batteryLevel) {
        if (batteryLevel >= 0 && batteryLevel <= 100) {
            this.batteryLevel = batteryLevel;
        } else {
            System.out.println("Battery level must be between 0 and 100");
        }
    }

     public void turnOn() {
        if (batteryLevel > 0) {
            isOn = true;
            System.out.println("Phone is ON");
        } else {
            System.out.println("Battery empty! Cannot turn on.");
        }
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Phone is OFF");
    }

    public void makeCall(String contactName) {
        if (isOn && batteryLevel >= 5) {
            System.out.println("Calling " + contactName + "...");
            batteryLevel -= 5;
        } else if (!isOn) {
            System.out.println("Phone is OFF. Turn it on first.");
        } else {
            System.out.println("Battery too low to make a call.");
        }
    }

    public void chargeBattery(int minutes) {
        int addedCharge = minutes * 2;
        batteryLevel += addedCharge;

        if (batteryLevel > 100) {
            batteryLevel = 100;
        }

        System.out.println("Battery charged to " + batteryLevel + "%");
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
        System.out.println("Battery Level: " + batteryLevel + "%");
        System.out.println("Power Status: " + (isOn ? "ON" : "OFF"));
    }

    public static void main(String[] args) {
        System.out.println("=== Mobile Phone Exercise ===\n");
        
        MobilePhone phone1 = new MobilePhone();
        phone1.displayInfo();

        phone1.turnOn();
        phone1.makeCall("Alice");
        phone1.displayInfo();
        
        MobilePhone phone2 = new MobilePhone("Samsung", "Galaxy S23", 1200.00);

        phone2.turnOn();
        
        phone2.makeCall("Baho");
        
        phone2.displayInfo();

        phone2.chargeBattery(10);

        phone2.displayInfo();

        System.out.println("\n=== Exercise Complete ===");
    }
}
