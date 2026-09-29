package ra.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConection {
    private static final String URL =
            "jdbc:mysql://localhot:3306/db_library_management";
    private static final String USER = "root";
    private static final String PASSWORD ="12345678";
    public  static Connection getConnection ()
            throws SQLException {
        return DriverManager.getConection (
                URL,
                USER,
                PASSWORD
        );
    }
}
