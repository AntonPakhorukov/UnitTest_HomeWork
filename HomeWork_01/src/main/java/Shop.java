import java.util.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Задание 2. (*)
 * Мы хотим улучшить функциональность нашего интернет-магазина.
 * Ваша задача - добавить два новых метода в класс Shop:
 * ● Метод sortProductsByPrice(), который сортирует список продуктов по стоимости.
 * ● Метод getMostExpensiveProduct(), который возвращает самый дорогой продукт.
 * Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов
 * (правильное количество продуктов, верное содержимое корзины).
 * Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
 * Напишите тесты для проверки корректности работы метода sortProductsByPrice
 * (проверьте правильность сортировки). Используйте класс Product для создания
 * экземпляров продуктов и класс Shop для написания методов сортировки и тестов.
 */
public class Shop {
    public static void main(String[] args) {
        List<Product> shop = new ArrayList<>();
        addInListProduct(shop, 5);
        printListProduct(shop);
        System.out.println("=====================");
        sortProductsByPrice(shop);
        printListProduct(shop);
        System.out.println("=====================");
        System.out.println("Самый дорогой товар: " + getMostExpensiveProduct(shop));
    }

    /**
     * Метод рандомного заполнения списка продуктов.
     * Передается пустой список и указывается кол-во продуктов, которое необходимо добавить.
     * @param list Список для заполнения
     * @param size Кол-во продуктов, которое необходимо добавить
     */
    public static void addInListProduct(List list, int size){
        assert size > 0 : "При добавлении продуктов в список, кол-во должно быть больше 0";
        for (int i = 0; i < size; i++) {
            Random rand = new Random();
            int prise = rand.nextInt(20, 200);
            list.add(new Product("Product " + (i + 1), prise));
        }
        assert size == list.size() : "Размер списка не совпадает";
    }

    /**
     * Метод распечатывания списка продуктов
     * @param list список продуктов
     */
    public static void printListProduct(List list){
        for (Object prod : list) {
            System.out.println(prod.toString());
        }
    }
    /**
     * Метод сортировки списка продуктов
     * @param list Список продуктов для сортировки
     */
    public static void sortProductsByPrice(List list){
        assert list.size() > 0 : "Список пустой, сортировка не требуется";
        Collections.sort(list, new Comparator<Product>() {
            public int compare(Product p1, Product p2) {
                return p2.price - p1.price;
            }
        });
        for (int i = 1; i < list.size(); i++) {
            assert ((Product) list.get(i - 1)).price > ((Product) list.get(i)).price : "Сортировка не верна";
        }
    }
    /**
     * Метод извлечения самого дорого продукта из списка
     * @param list Список с продуктами
     * @return Возвращает продукт у которого самая высокая цена
     */
    public static Product getMostExpensiveProduct(List list) {
        assert list.size() > 0 : "Список пустой, выбирать не из чего";
        Product findProduct = (Product) list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (findProduct.price < ((Product) list.get(i)).price) {
                findProduct = (Product) list.get(i);
            }
            assert findProduct.price >= ((Product) list.get(i)).price : "Есть продукты и подороже...";
        }
        return findProduct;

    }
}
