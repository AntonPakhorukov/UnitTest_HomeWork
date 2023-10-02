public class Motorcycle extends Vehicle{
    private String company;
    private String model;
    private int yearRelease;
    private int speed;
    private int numWheels;

    public Motorcycle(String company, String model, int yearRelease) {
        this.company = company;
        this.model = model;
        this.yearRelease = yearRelease;
        this.speed = 0;
        this.numWheels = 2;
    }

    public String getCompany() {
        return company;
    }

    public String getModel() {
        return model;
    }

    public int getYearRelease() {
        return yearRelease;
    }

    public int getSpeed() {
        return speed;
    }

    public int getNumWheels() {
        return numWheels;
    }

    @Override
    public void testDrive() {
        this.speed = 75;
    }

    @Override
    public void park() {
        this.speed = 0;
    }

    @Override
    public String toString() {
        return "This motorcycle is " + this.company + " " + this.model + ", released in " + this.yearRelease + " year";
    }
}
