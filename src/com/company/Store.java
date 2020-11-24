package com.company;

public class Store {
    private String nameShop;
    private String urlShop;
    private User[] usersShop;
    private String authorizedUser;

    public Store(String nameShop, String urlShop, User[] usersShop) {
        this.nameShop = nameShop;
        this.urlShop = urlShop;
        this.usersShop = usersShop;
    }

    public User[] getUsersShop() {
        return usersShop;
    }

    public boolean login(String name, String password) {
        for (int i = 0; i < usersShop.length; i++) {
            if (name.equals(usersShop[i].getLogin()) && password.equals(usersShop[i].getPassword())) {
                authorizedUser = name;
                return true;
            }
        }
        return false;
    }

    void getCurrentUserRights() {
        Person director = Person.DIRECTOR;
        System.out.println(director + ": Директор магазина, может управлять кадрами, и ценами");
        Person administrator = Person.ADMINISTRATOR;
        System.out.println(administrator + ": Администратор магазина, может добавлять товары и редактировать их описание");
        Person manager = Person.MANAGER;
        System.out.println(manager + ": Менеджер магазина, может общаться с клиентами");
        Person client = Person.CLIENT;
        System.out.println(client + ": Клиент магазина, может покупать товары и пользоваться дисконтом");
        Person anonymous = Person.ANONYMOUS;
        System.out.println(anonymous + ": Анонимный пользователь, может покупать товары и/или авторизоваться");

    }

    void logout() {
        authorizedUser = null;
        System.out.println("Пользователь вышел из системы");
    }
}
