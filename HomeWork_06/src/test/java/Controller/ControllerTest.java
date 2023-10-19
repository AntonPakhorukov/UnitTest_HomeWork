package Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    Controller controller;
    @BeforeEach
    void testInit() {
        controller = new Controller();
    }
    @Test
    void testInputNumber() {
        controller.inputNumber(5);
        assertEquals(5, controller.getList().get(0));

    }
    @ParameterizedTest
    @ValueSource(ints = {5, 8 ,9})
    void testInputTestAnyNumbers(int i){
        controller.inputNumber(i);
        assertEquals(i, controller.getList().get(0));
    }
    @Test
    void testGetList() {
        int[] test = new int[] {3, 5, 6};
        fillList(test, controller);
        assertEquals("[3, 5, 6]", controller.getList().toString());
    }

    @Test
    void testGetSumList() {
        int[] test = new int[] {1, 2, 3, 4 ,5};
        fillList(test, controller);
        assertEquals(3, controller.getSumList());
    }

    @Test
    void testCompareList() {
        Controller controller1 = new Controller();
        int[] testArray1 = new int[] {3, 5, 7, 9};
        fillList(testArray1, controller1);
        Controller controller2 = new Controller();
        int[] testArray2 = new int[] {3, 5, 7, 9};
        fillList(testArray2, controller2);
        assertEquals(0, controller.compareList(controller1.getSumList(), controller2.getSumList()));

        Controller controller3 = new Controller();
        int[] testArray3 = new int[] {2, 4, 6, 8};
        fillList(testArray3, controller3);
        assertEquals(1, controller.compareList(controller1.getSumList(), controller3.getSumList()));

        Controller controller4 = new Controller();
        int[] testArray4 = new int[] {4, 8, 12, 16};
        assertEquals(-1, controller.compareList(controller1.getSumList(), controller4.getSumList()));
    }
    private static void fillList(int[] array, Controller list) {
        for (int i : array) {
            list.inputNumber(i);
        }
    }
}