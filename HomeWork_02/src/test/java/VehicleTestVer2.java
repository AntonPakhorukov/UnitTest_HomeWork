import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VehicleTestVer2 {
    /**
     * Проверка того, что экземпляр объекта Car также является экземпляром транспортного средства
     */
    @Test
    void carIsVehicle(){
        Car car = new Car("Audi", "Q7", 2023);
        assertInstanceOf(Vehicle.class,car);
    }
    /**
     * Проверка того, объект Car создается с 4-мя колесами
     */
    @Test
    void carHaveFourWheels(){
        Car car = new Car("Audi", "Q7", 2023);
        assertEquals(4, car.getNumWheels());
    }
    /**
     * Проверка того, объект Motorcycle создается с 2-мя колесами
     */
    @Test
    void motorcycleHaveTwoWheels(){
        Motorcycle motorcycle = new Motorcycle("Audi", "Q7", 2023);
        assertEquals(2, motorcycle.getNumWheels());
    }
    /**
     * Проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive()
     */
    @Test
    void carSpeedInTestDrive() {
        Car car = new Car("Audi", "Q7", 2023);
        car.testDrive();
        assertEquals(60, car.getSpeed());
    }
    /**
     * Проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive()
     */
    @Test
    void motorcycleSpeedInTestDrive() {
        Motorcycle motorcycle = new Motorcycle("Kawasaki", "ZZR1000", 2015);
        motorcycle.testDrive();
        assertEquals(75, motorcycle.getSpeed());
    }
    /**
     * Проверить, что в режиме парковки (сначала testDrive, потом park,
     *  * т.е эмуляция движения транспорта) машина останавливается (speed = 0)
     */
    @Test
    void carSpeedAfterTestDriveInParkingCondition() {
        Car car = new Car("Audi", "Q7", 2023);
        car.testDrive();
        car.park();
        assertEquals(0, car.getSpeed());

    }
    /**
     * Проверить, что в режиме парковки (сначала testDrive, потом park
     *  * т.е эмуляция движения транспорта) мотоцикл останавливается (speed = 0)
     */
    @Test
    void motorcycleSpeedAfterTestDriveInParkingCondition(){
        Motorcycle motorcycle = new Motorcycle("Kawasaki", "ZZR1000", 2015);
        motorcycle.testDrive();
        motorcycle.park();
        assertEquals(0, motorcycle.getSpeed());
    }
}
