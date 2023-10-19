package View;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.function.Try;
import org.mockito.plugins.MockMaker;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class ViewTest {
    View view = mock(View.class);
    Menu menu = mock(Menu.class);
    @Test
    void testView() {
        view.viewMenu();
        verify(view, times(1)).viewMenu();    }
    @Test
    void testViewMenu() throws NumberFormatException {
        boolean exceptionThrow = false;
        try {
            Method inputMenu = View.class.getDeclaredMethod("viewMenu");
            inputMenu.setAccessible(true);
            int iMenu = Integer.parseInt("bred");
            inputMenu.invoke(view, 0, 2, iMenu);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            exceptionThrow = true;
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        assertTrue(exceptionThrow);
    }
    @Test
    void testInputMenu() {
        try {
            Method inputEnter = View.class.getDeclaredMethod("inputMenu", int.class, int.class, int.class);
            inputEnter.setAccessible(true);
            assertEquals(1, inputEnter.invoke(view, 0, 2, 1));
            int iMenu = Integer.parseInt("1");
            assertEquals(1, inputEnter.invoke(view, 0, 2, iMenu));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void testExit() {
        try {
            Method method = View.class.getDeclaredMethod("exit", int.class);
            method.setAccessible(true);
            method.invoke(view, 2);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}