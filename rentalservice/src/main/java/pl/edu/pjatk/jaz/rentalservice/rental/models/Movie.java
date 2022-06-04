package pl.edu.pjatk.jaz.rentalservice.rental.models;

import pl.edu.pjatk.jaz.rentalservice.rental.types.Genre;

public class Movie {
    private Integer id;
    private String title;
    private String originalTitle;
    private Integer yearOfProduction;
    private Genre genre;
    private boolean isAvailable;

    public Movie(Integer id, String title, String originalTitle, Integer yearOfProduction, Genre genre, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.yearOfProduction = yearOfProduction;
        this.genre = genre;
        this.isAvailable = isAvailable;
    }

    public Movie(Integer id, String title, String originalTitle, Genre genre, Integer yearOfProduction) {
        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.genre = genre;
        this.yearOfProduction = yearOfProduction;
    }

    public Movie() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(Integer yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", originalTitle='" + originalTitle + '\'' +
                ", genre=" + genre +
                ", yearOfProduction=" + yearOfProduction +
                '}';
    }
}
