package DataAccessObjects;

import DB.DatabaseManager;
import Entities.Movie;

import java.sql.*;

public class MovieDAO {
    public static Movie getMovieByName(String movieName) {
        Movie movie = null;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conn = DatabaseManager.getConnection();

            String sql = "SELECT* FROM movies WHERE title = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, movieName);
            resultSet = statement.executeQuery();
            String name = movieName;
            if(resultSet.next()) {
                String originalLanguage = resultSet.getString("original_language");
                String overview = resultSet.getString("overview");
                String mediaType = resultSet.getString("media_type");
                Array genres = resultSet.getArray("genres");
                double rating = resultSet.getDouble("rating");
                String releaseDate = resultSet.getString("release_date");
                String watchUrl = resultSet.getString("url");

                String[] genresArray = null;
                if(genres != null)
                {
                    genresArray = (String[])genres.getArray();
                }

                //GET GENRE NAMES BY ARRAY OF IDS
                genresArray = GenresDAO.getGenresById(genresArray, conn);
                movie = new Movie(name, originalLanguage, overview, mediaType, genresArray, rating, releaseDate, watchUrl);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if(resultSet != null) resultSet.close();
                if(statement != null) statement.close();
                if(conn != null) conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return  movie;
    }
}
