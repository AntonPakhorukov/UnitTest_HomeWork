import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    Main m;
    @BeforeEach
    void testInit(){
        m = new Main();
    }
    @ParameterizedTest
    @ValueSource(ints = {-22, -12, -4, -2, 0, 2, 4, 16, 34})
    void testEvenOddNumberIsEven(int i){
        assertTrue(m.evenOddNumber(i));
    }
    @ParameterizedTest
    @ValueSource(ints = {-21, -11, -3, -1, 1, 3, 15, 33})
    void testEvenOddNumberIsOdd(int i){
        assertFalse(m.evenOddNumber(i));
    }
    @ParameterizedTest
    @ValueSource(ints = {26, 30, 45, 56, 67, 74, 89, 99})
    void testNumberInIntervalPositive(int i) {
        assertTrue(m.numberInInterval(i));
    }
    @ParameterizedTest
    @ValueSource(ints = {-100,-55, -45, -25, -15, 0, 25, 100, 115})
    void testNumberInIntervalNegative(int i) {
        assertFalse(m.numberInInterval(i));
    }
    @Test
    void testLogOut(){
        UserRepository repo = new UserRepository();
        for (int i = 0; i < 6; i++) {
            repo.addUser(new User("user" + i, "password" + i, false));
            repo.data.get(i).authenticate("user" + i, "password" + i);
        }
        repo.data.get(1).setAdmin(true);
        repo.data.get(3).setAdmin(true);
        repo.logOut();
        assertEquals(2, repo.size());
    }
}
