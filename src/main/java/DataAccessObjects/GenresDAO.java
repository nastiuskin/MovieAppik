package DataAccessObjects;

import DB.DatabaseManager;
import Entities.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class GenresDAO {

    public static String[] getGenresById(String[] genresIds, Connection conn) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String[] genres = new String[genresIds.length];

        try {
            String sql = "SELECT name FROM genres WHERE id IN (";
            for (int i = 0; i < genresIds.length; i++) {
                sql += "?";
                if (i < genresIds.length - 1) {
                    sql += ",";
                }
            }
            sql += ")";

            statement = conn.prepareStatement(sql);
            for (int i = 0; i < genresIds.length; i++) {
                statement.setInt(i + 1, Integer.parseInt(genresIds[i]));
            }

            resultSet = statement.executeQuery();

            int index = 0;
            while (resultSet.next()) {
                String genre = resultSet.getString("name");
                genres[index] = genre;
                index++;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return genres;
    }
}

