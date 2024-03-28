package overridetech.jdbc.jpa;

import overridetech.jdbc.jpa.service.UserService;
import overridetech.jdbc.jpa.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService service = new UserServiceImpl();

        service.createUsersTable();

        service.saveUser("A", "A", (byte) 30);
        service.saveUser("B", "B", (byte) 31);
        service.saveUser("C", "C", (byte) 32);
        service.saveUser("D", "D", (byte) 33);

        service.getAllUsers().forEach(System.out::println);

        service.cleanUsersTable();
        service.dropUsersTable();
    }
}
