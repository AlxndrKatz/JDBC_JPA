package overridetech.jdbc.jpa.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import overridetech.jdbc.jpa.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:postgresql://localhost:5432/db_example";
    private static final String USER = "postgres";
    private static final String PASSWORD = "8080";
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String DIALECT = "org.hibernate.dialect.PostgreSQLDialect";
    public static SessionFactory sessionFactory;


    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.setProperty(Environment.DIALECT, DIALECT);
        configuration.setProperty(Environment.DRIVER, DRIVER);
        configuration.setProperty(Environment.URL, URL);
        configuration.setProperty(Environment.USER, USER);
        configuration.setProperty(Environment.PASS, PASSWORD);
        configuration.setProperty(Environment.SHOW_SQL, "true");
        configuration.setProperty(Environment.HBM2DDL_AUTO, "validate");
        configuration.addAnnotatedClass(User.class);

        sessionFactory = configuration.buildSessionFactory();

        return sessionFactory;
    }
}
