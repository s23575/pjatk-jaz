package pl.edu.pjatk.jaz.movieservice.movies.models;

import org.hibernate.annotations.ColumnTransformer;
import pl.edu.pjatk.jaz.movieservice.movies.types.Genre;

import javax.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @Column(name = "originaltitle")
    // Spring / Hibernate zmienia nazwy atrybutów klasy z podkreślnikiem, np. "originalTitle" na "original_title",
    // stąd trzeba wskazać, że "orginalTitle" / "original_title" w aplikacji odpowiada "originaltitle" w bazie danych.
    private String originalTitle;
    @Column(name = "yearofproduction", columnDefinition = "year")
    private Integer yearOfProduction;
    @ColumnTransformer(read = "upper(genre)")
    // Powyższe jest potrzebne, aby enumy z bazy danych, pisane małymi literami, były odpowiednio odczytywane przez
    // aplikację - enumy określone dużymi literami
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @Column(columnDefinition = "bit")
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
