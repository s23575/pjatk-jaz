package pl.edu.pjatk.jaz.movieservice.movies.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.edu.pjatk.jaz.movieservice.movies.models.Movie;
import pl.edu.pjatk.jaz.movieservice.movies.types.Genre;

import javax.transaction.Transactional;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE Movie m SET m.title = :title, m.originalTitle = :originaltitle," +
            "m.yearOfProduction= :yearofproduction, m.genre = :genre" +
            " WHERE m.id = :id")
    void updateMovie(String title, String originaltitle, Genre genre, Integer yearofproduction, Integer id);
}
