package overridetech.jdbc.jpa;

import overridetech.jdbc.jpa.service.UserService;
import overridetech.jdbc.jpa.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {

        UserService service = new UserServiceImpl();

        service.createUsersTable();

        service.saveUser("A", "B", (byte) 30);
        service.saveUser("B", "C", (byte) 31);
        service.saveUser("C", "D", (byte) 32);
        service.saveUser("D", "E", (byte) 33);
        //service.removeUserById(1);

        service.getAllUsers().forEach(System.out::println);

        service.cleanUsersTable();
        service.dropUsersTable();
    }
}
