package Model;

import java.util.ArrayList;
import java.util.List;

public class ListMultiply {
    private List<Integer> list;

    public ListMultiply() {
        this.list = new ArrayList<>();
    }
    public void addNumberInList(int number) {
        list.add(number);
    }
    public List<Integer> getList() {
        return this.list;
    }
    public double middleList() {
        return list.stream().mapToDouble(Integer::intValue).sum() / list.size();
    }
}
