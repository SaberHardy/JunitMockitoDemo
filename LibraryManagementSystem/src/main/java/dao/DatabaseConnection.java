package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnection {
    private static Connection connection = null;

    public static Connection getConnection() {
        if(connection==null) {
            try(InputStream inputStream = DatabaseConnection.class.
                    getClassLoader().
                    getResourceAsStream("database.properties")) {

                Properties properties = new Properties();
                properties.load(inputStream);

                String url = properties.getProperty("db.url");
                String username = properties.getProperty("db.username");
                String password = properties.getProperty("db.password");

                connection = DriverManager.getConnection(url, username, password);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
