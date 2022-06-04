package pl.edu.pjatk.jaz.movieservice.movies.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.edu.pjatk.jaz.movieservice.movies.models.Movie;
import pl.edu.pjatk.jaz.movieservice.movies.types.Genre;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Optional<Movie> findById(Integer id);

    List<Movie> findAll();

    Movie save(Movie movieToSave);

    @Transactional
    @Modifying
    @Query("UPDATE Movie m SET m.title = :title, m.originalTitle = :originalTitle," +
            "m.yearOfProduction= :yearOfProduction, m.genre = :genre" +
            " WHERE m.id = :id")
    void updateMovie(String title, String originalTitle, Integer yearOfProduction, Genre genre, Integer id);

    void deleteById(Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Movie m SET m.isAvailable = true WHERE m.id = :id")
    void updateAvailabilityTrue(Integer id);
// Long zwraca liczbę zmienionych wierszy - jeżeli nie zmienia żadnego, to 0
    @Transactional
    @Modifying
    @Query("UPDATE Movie m SET m.isAvailable = true")
    void updateAvailabilityTrueAll();

    @Transactional
    @Modifying
    @Query("UPDATE Movie m SET m.isAvailable = false WHERE m.id = :id")
    void updateAvailabilityFalse(Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Movie m SET m.isAvailable = false")
    void updateAvailabilityFalseAll();
}

