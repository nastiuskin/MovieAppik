package Entities;

import java.io.Serializable;
public class Movie implements Serializable {
    public int id;
    public String title;
    public String original_language;
    public String overview;
    public String media_type;
    public String[] genres;
    public double rating;
    public String release_date;
    //    public String imagePath;
    public String url;

    public Movie(){

    }

    public Movie(String name, String originalLanguage, String overview, String mediaType, String[] genresArray, double rating, String releaseDate, String watchUrl) {
            this.title = name;
            this.original_language = originalLanguage;
            this.overview = overview;
            this.media_type = mediaType;
            this.rating = rating;
            this.release_date = releaseDate;
            this.url = watchUrl;
            setGenres(genresArray);
    }

    public void setGenres(String[] genresArray)
    {
        this.genres = new String[genresArray.length];
        System.arraycopy(genresArray, 0, this.genres, 0, genresArray.length);

    }

    public String[] getGenres()
    {
        return this.genres;
    }


    public String getTitle() { return title;}

    public String getOriginalLanguage() {
        return original_language;
    }

    public String getOverview() {
        return overview;
    }

    public String getMediaType() {
        return media_type;
    }

    public double getRating() {
        return rating;
    }

    public String getReleaseDate() {
        return release_date;
    }

    public String getWatchUrl() {
        return url;
    }
}
