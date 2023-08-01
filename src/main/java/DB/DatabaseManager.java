package DB;

import Entities.Movie;

import java.sql.*;

public class DatabaseManager {
    private static final String DB_Url = "jdbc:postgresql://localhost:5432/Movies";
    private static final String DB_User = "user";
    private static final String DB_Password = "password";

    public static Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
        return DriverManager.getConnection(DB_Url, DB_User, DB_Password);
    }
}

