package Controller;

import Model.ListMultiply;

import java.util.List;

public class Controller {
    private final ListMultiply listMultiply;
    public Controller() {
        this.listMultiply = new ListMultiply();
    }
    public void inputNumber (int number) {
        listMultiply.addNumberInList(number);
    }
    public List<Integer> getList() {
        return listMultiply.getList();
    }
    public double getSumList() {
        return listMultiply.middleList();
    }
    public int compareList (double a, double b) {
        return Double.compare(a, b);
    }
}
