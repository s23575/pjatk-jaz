package pl.edu.pjatk.jaz.movieservice.movies.services;

import org.springframework.stereotype.Service;
import pl.edu.pjatk.jaz.movieservice.movies.exceptions.NotFoundException;
import pl.edu.pjatk.jaz.movieservice.movies.interfaces.MovieRepository;
import pl.edu.pjatk.jaz.movieservice.movies.models.Movie;
import pl.edu.pjatk.jaz.movieservice.movies.types.Genre;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie findById(Integer id) {
        return movieRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie saveMovie(Movie movieToSave) {
        return movieRepository.save(movieToSave);
    }

    public Movie updatedMovie(Integer id, Movie movieToUpdate) {
        movieRepository.updateMovie(movieToUpdate.getTitle(), movieToUpdate.getOriginalTitle(),
                movieToUpdate.getGenre(), movieToUpdate.getYearOfProduction(), id);
        return movieRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteMovie(Integer id) {
        movieRepository.deleteById(id);
    }

// * * *

    public List<Movie> getMovieList() {
        Movie movie1 = new Movie(1, "Deszczowa piosenka", "Singin' in the Rain", Genre.MUSICAL, 1952);
        Movie movie2 = new Movie(2, "Dyktator", "The Great Dictator", Genre.COMEDY, 1940);
        Movie movie3 = new Movie(3, "Siedem", "Seven", Genre.THRILLER, 1995);
        Movie movie4 = new Movie(4, "Komando", "Commando", Genre.ACTION, 1985);

        return List.of(movie1, movie2, movie3, movie4);

    }

    public Movie getMovieById(Integer id) {

        List<Movie> movieList = getMovieList();

        return movieList.stream()
                .filter(movie -> id.equals(movie.getId()))
                .findAny()
                .orElseThrow(NotFoundException::new);
    }

    public Movie addMovie(Movie movieToAdd) {
//        return Optional.ofNullable(movieToAdd).
//                orElseThrow(IncorrectInputDataException::new);

        return movieToAdd;
    }

//    public Movie updateMovie(Integer id, Movie updatedMovie) {
//        Movie movieToUpdate = getMovieById(id);
//        updatedMovie.setId(movieToUpdate.getId());
//        return updatedMovie;
//    }
//
//    public void deleteMovie(Integer id) {
//        getMovieById(id);
//    }

}
