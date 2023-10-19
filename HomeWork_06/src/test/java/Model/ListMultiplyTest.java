package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ListMultiplyTest {
    private ListMultiply listMultiply;

    @BeforeEach
    void testInit(){
        listMultiply = new ListMultiply();
    }

    @Test
    void testAddNumberInList() {
        for (int i = 0; i < 5; i++) {
            listMultiply.addNumberInList(i);
            assertEquals(i, listMultiply.getList().get(i));
        }
        assertEquals(5, listMultiply.getList().size());
    }

    @Test
    void testGetList() {
        listMultiply.addNumberInList(5);
        listMultiply.addNumberInList(7);
        listMultiply.addNumberInList(9);
        assertEquals("[5, 7, 9]", listMultiply.getList().toString());
        assertEquals(ArrayList.class, listMultiply.getList().getClass());
    }

    @Test
    void testMiddleList() {
        listMultiply.addNumberInList(5);
        listMultiply.addNumberInList(7);
        listMultiply.addNumberInList(9);
        assertEquals(7, listMultiply.middleList());
    }
}