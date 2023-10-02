import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
public class VehicleTest {
    /**
     * Проверка того, что экземпляр объекта Car также является экземпляром транспортного средства
     */
    @Test
    void carIsVehicle(){
        Car car = new Car("Audi", "Q7", 2023);
        assert car instanceof Vehicle : "car is not vehicle";
    }
    /**
     * Проверка того, объект Car создается с 4-мя колесами
     */
    @Test
    void carHaveFourWheels(){
        Car car = new Car("Audi", "Q7", 2023);
        assert 4 == car.getNumWheels() : "the car doesn't have 4 wheels";

    }
    /**
     * Проверка того, объект Motorcycle создается с 2-мя колесами
     */
    @Test
    void motorcycleHaveTwoWheels(){
        Motorcycle motorcycle = new Motorcycle("Audi", "Q7", 2023);
        assert 2 == motorcycle.getNumWheels() : "the motorcycle doesn't have 2 wheels";
    }
    /**
     * Проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive()
     */
    @Test
    void carSpeedInTestDrive() {
        Car car = new Car("Audi", "Q7", 2023);
        car.testDrive();
        assert 60 == car.getSpeed() : "car speed is not 60 in testDrive";
    }
    /**
     * Проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive()
     */
    @Test
    void motorcycleSpeedInTestDrive() {
        Motorcycle motorcycle = new Motorcycle("Kawasaki", "ZZR1000", 2015);
        motorcycle.testDrive();
        assert 75 == motorcycle.getSpeed() : "motorcycle speed is not 75 in testDrive";
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
        assert 0 == car.getSpeed() : "car don't stop after test drive";

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
        assert 0 == motorcycle.getSpeed() : "motorcycle don't stop after test drive";
    }
}
