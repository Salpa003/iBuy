package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class ConnectionManager {
    private static final Properties PROPERTIES = new Properties();

    private static final String USER_KEY="db.user";
    private static final String PASSWORD_KEY="db.password";
    private static final String URL_KEY="db.url";
    private static final String DRIVER_KEY="db.driver";

    static {
        load();
    }

    public static Connection open() {
        try {
            return DriverManager.getConnection(
                    PROPERTIES.getProperty(URL_KEY),
                    PROPERTIES.getProperty(USER_KEY),
                    PROPERTIES.getProperty(PASSWORD_KEY)
            );
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка при открытии соединения с БД");
        }
    }
    private static void load() {
        try {
            PROPERTIES.load(ConnectionManager.class.getClassLoader().getResourceAsStream("application.properties"));
            Class.forName(PROPERTIES.getProperty(DRIVER_KEY));
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при загрузке драйвера или чтении properties");
        }

    }
}
