import static org.assertj.core.api.Assertions.*;
public class Calculator {
    public static void main(String[] args) {
        /**
         * Задание 1.
         * В классе Calculator создайте метод calculateDiscount,
         * который принимает сумму покупки и процент скидки и возвращает сумму с учетом скидки.
         * Ваша задача - проверить этот метод с использованием библиотеки AssertJ.
         * Если метод calculateDiscount получает недопустимые аргументы,
         * он должен выбрасывать исключение ArithmeticException.
         * Не забудьте написать тесты для проверки этого поведения.
         */
        double purchaseAmount = 150;
        int discountAmount = 30;
        System.out.printf("Цена покупки со скидкой = %.2f\n", calculateDiscount(purchaseAmount, discountAmount));
    }
    /**+
     * Метод расчета покупки по дисконту
     * @param purchaseAmount базовая цена
     * @param discountAmount скидка
     * @return итоговая цена с учетом скидки
     */
    public static double calculateDiscount(double purchaseAmount, int discountAmount) {
        assert purchaseAmount > 0 : new ArithmeticException("Цена должна быть больше 0");
        assert discountAmount > 0 && discountAmount < 100 : new ArithmeticException("Скидка должна быть больше 0 и меньше 100");
        return purchaseAmount - ((purchaseAmount * discountAmount)/100);
    }
}
