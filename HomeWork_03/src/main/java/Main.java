public class Main {
    public static void main(String[] args) {
        /**
         * Добавьте функцию в класс UserRepository, которая разлогинивает
         * всех пользователей, кроме администраторов. Для этого,
         * вам потребуется расширить класс User новым свойством,
         * указывающим, обладает ли пользователь админскими правами.
         * Протестируйте данную функцию.
         */
        UserRepository repos = new UserRepository();
        for (int i = 0; i < 6; i++) {
            repos.addUser(new User("user" + i, "password" + i, false));
            repos.data.get(i).authenticate("user" + i, "password" + i);
        }
        System.out.println("Репозиторий всех пользователей:");
        repos.data.get(1).setAdmin(true);
        repos.data.get(3).setAdmin(true);
        for (User user : repos.data) {
            System.out.println(user);
        }
        System.out.println("Репозиторий админов:");
        repos.logOut();
        for (User user : repos.data) {
            System.out.println(user);
        }

    }
    /**
     * Задание 1. Напишите тесты, покрывающие на 100% метод evenOddNumber,
     * который проверяет, является ли переданное число четным
     * или нечетным:
     */
    public boolean evenOddNumber(int n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Разработайте и протестируйте метод numberInInterval,
     * который проверяет, попадает ли
     * переданное число в интервал (25;100)
     */
    public boolean numberInInterval(int n) {
        return n > 25 && n < 100;
    }
}
