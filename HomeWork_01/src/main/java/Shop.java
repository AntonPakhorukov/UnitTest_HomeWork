import java.util.*;

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
        for (int i = 0; i < size; i++) {
            Random rand = new Random();
            int prise = rand.nextInt(20, 200);
            list.add(new Product("Product " + (i+1), prise));
        }
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
        Collections.sort(list, new Comparator<Product>() {
            public int compare(Product p1, Product p2) {
                return p2.price - p1.price;
            }
        });
    }

    /**
     * Метод извлечения самого дорого продукта из списка
     * @param list Список с продуктами
     * @return Возвращает продукт у которого самая высокая цена
     */
    public static Product getMostExpensiveProduct(List list) {
        Product findProduct = (Product) list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (findProduct.price < ((Product) list.get(i)).price) {
                findProduct = (Product) list.get(i);
            }
        }
        return findProduct;
    }
}
