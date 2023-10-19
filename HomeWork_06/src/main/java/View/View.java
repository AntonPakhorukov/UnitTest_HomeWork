package View;

import java.util.Scanner;

public class View {
    public static final Scanner scan = new Scanner(System.in);
    private int numMenu = -1;
    private Menu menu;
    public void viewMenu() {
        while (numMenu != 2) {
            numMenu = inputMenu(1, 2, this.numMenu);
            exit(numMenu);
            menu = new Menu();
            menu.inputMenu();
            exit(numMenu);
            numMenu = 2;
            scan.close();
        }
    }
    private int inputMenu (int menuMin, int menuMax, int menuTrue) {
        System.out.println("Выберите действие:\n 1 - Сравнить списки\n 2 - Выйти");
        while (menuTrue < menuMin || menuTrue > menuMax) {
            try {
                String enterParagraph = scan.nextLine();
                menuTrue = Integer.parseInt(enterParagraph);
                if (menuTrue < menuMin || menuTrue > menuMax) {
                    System.out.println("Ошибка ввода пункта меню");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода");
            }
        }
        return menuTrue;
    }
    private void exit(int inputNumberMenu) {
        if (inputNumberMenu == 2) {
            System.out.println("Вы вышли");
//            System.exit(inputNumberMenu);
        }
    }
}

