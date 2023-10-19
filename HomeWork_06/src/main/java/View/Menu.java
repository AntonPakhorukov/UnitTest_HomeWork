package View;

import Controller.Controller;

import java.util.List;
import java.util.Scanner;


public class Menu {
    private static final Scanner scan = new Scanner(System.in);
    private Controller controllerOne;
    private Controller controllerTwo;
    private Controller controllerThree;
    private int number;
    public Menu() {
        this.controllerOne = new Controller();
        this.controllerTwo = new Controller();
        this.controllerThree = new Controller();
    }
    public void inputMenu() {
        System.out.println("Добавьте числа в первый список: ");
        while (inputNumber()) {
            controllerOne.inputNumber(this.number);
            System.out.print("Добавить еще: ");
        }
        System.out.println("Добавить во второй список: ");
        while (inputNumber()) {
            controllerTwo.inputNumber(this.number);
            System.out.print("Добавить еще: ");
        }
        printList(controllerOne.getList());
        printList(controllerTwo.getList());
        System.out.printf("Первый список: %.2f\n", controllerOne.getSumList());
        System.out.printf("Второй список: %.2f\n", controllerTwo.getSumList());
        printResult(controllerThree.compareList(controllerOne.getSumList(), controllerTwo.getSumList()));
    }
    private boolean inputNumber() {
        try {
            String input = scan.nextLine();
            if (input.isEmpty()) {
                return false;
            }
            this.number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода");
        }
        return true;
    }
    private void printList (List<Integer> list) {
        System.out.print("Список 1: ");
        for (int number : list) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
    private void printResult (int res) {
        if (res == 1) {
            System.out.println("Первый список больше второго");
        } else if (res == -1) {
            System.out.println("Второй список больше первого");
        } else {
            System.out.println("Списки равны");
        }
    }
}
