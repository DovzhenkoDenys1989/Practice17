package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        User user1 = new User("01", "us01", "Ilya", Person.DIRECTOR);
        User user2 = new User("02", "us02", "Ivan", Person.ADMINISTRATOR);
        User user3 = new User("03", "us03", "Kiril", Person.MANAGER);
        User user4 = new User("04", "us04", "Anastasia", Person.CLIENT);
        User user5 = new User(" ", " ", " ", Person.ANONYMOUS);

        Store store = new Store("Bavaria Motors", "www.BM.com.ua", new User[]{user1, user2, user3, user4, user5});
        store.getCurrentUserRights();

        boolean i = tryLogin(store);
        while (!i) {
            i = tryLogin(store);
        }
    }

    static boolean tryLogin(Store store) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин: ");
        String login = scanner.nextLine();
        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();
        store.login(login, password);
        boolean isRegistration = store.login(login, password);

        if (isRegistration) {
            store.getCurrentUserRights();
            store.logout();

        }
        if (!isRegistration) {
            System.out.println("Неверный логин и//или пароль");
        }
        return isRegistration;
    }
}

//        1. Создать класс User (пользователь какой-то системы). Необходимые поля: login,
//        password, name, role
//        2. Создать Enum описывающий должности работников интернет-магазина: директор,
//        администратор, менеджер, клиент, аноним.
//        3. Заменить тип плоя role на тип созданного Enum (по умолчанию поставить анонима)
//        4. Создать класс Store c полями: имя магазина, URL магазина, массив всех пользователей
//        магазина, авторизированный пользователь магазина.
//        5. В классе Store создать метод login в который передается имя и пароль.
//        • В методе необходимо найти пользователя у которого совпадают введенные и
//        сохраненные логин и пароль и присвоить значение этого пользователя полю для
//        авторизированного пользователя.
//        • Если не найден пользователь с таким логином и паролем возвращаем true
//        • Если не найден пользователь с таким логином и паролем возвращаем false.
//        6. В классе Store создать метод void getCurrentUserRights(). В методе, определить
//        текущую должность пользователя и вывести информацию об этом пользователе.
//        • Для директора: «Директор магазина, может управлять кадрами, и ценами»
//        • Для администратора: «Администратор магазина, может добавлять товары и
//        редактировать их описание»
//        • Для менеджера: «Менеджер магазина, может общаться с клиентами»
//        • Для клиента: «Клиент магазина, может покупать товары и пользоваться
//        дисконтом»
//        • Для анонима: «Анонимный пользователь, может покупать товары и\или
//        авторизоваться»
//        7. В классе Store создать метод logout, в котором полю авторизированный пользователь
//        присваивается null, и выводится сообщение: «Пользователь вышел из системы»
//        8. Создать Main класс с main методом. В main методе создать 5 пользователей с разными
//        должностями, логинами и паролями.
//        9. В main методе создать экземпляр класса Store. Проинициализировать список
//        пользователей, имя, url.
//        10. В классе Main создать статический метод без возвращаемого значения tryLogin, в
//        который, в качестве параметра передается ссылка на экземпляр класса Store.
//        • В методе создать Scanner для приема логина пользователя (Предварительно
//        нужно вывести сообщение: «Введите логин:»). Присвоить значение созданной
//        строке login.
//        • создать Scanner для приема пароля пользователя (Предварительно нужно
//        вывести сообщение: «Введите пароль:»). Присвоить значение созданной строке
//        password.
//        • Вызвать метод login у параметра (Store), передав в него login и password
//        • Если метод вернул true: вызываем у store метод getCurrentUserRights и после
//        него logout.
//        • Если метод вернул false, выводим на экран сообщение: «Неверный логин и\или
//        пароль».
//        11. Вызвать метод tryLogin в main методе и обернуть его бесконечным циклом, для
//        многоразового последовательного использования.