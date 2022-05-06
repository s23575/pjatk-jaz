package pl.edu.pjatk.jaz.movieservice.movies.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.jaz.movieservice.movies.models.Movie;
import pl.edu.pjatk.jaz.movieservice.movies.services.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movieservice")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovieList() {
//        return ResponseEntity.ok(movieService.getMovieList());
        return ResponseEntity.ok(movieService.findAll());
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Integer id) {
//        return ResponseEntity.ok(movieService.getMovieById(id));
        return ResponseEntity.ok(movieService.findById(id));
    }

    @PostMapping("/movies/add")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movieToAdd) {
//        return ResponseEntity.ok(movieService.addMovie(movieToAdd));
        return ResponseEntity.ok(movieService.saveMovie(movieToAdd));
    }
//    {
//        "title": "Szklana pułapka",
//        "originalTitle": "Die Hard",
//        "genre": "ACTION",
//        "yearOfProduction": 1988
//    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Integer id, @RequestBody Movie updatedMovie) {
//        return ResponseEntity.ok(movieService.updateMovie(id, updatedMovie));
        return ResponseEntity.ok(movieService.updatedMovie(id, updatedMovie));
    }
//    {
//        "title": "Szklana pułapka",
//        "originalTitle": "Die Hard",
//        "genre": "ACTION",
//        "yearOfProduction": 1988
//    }

    @DeleteMapping("/movies/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "NO CONTENT")
    public ResponseEntity<Void> deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);
        return ResponseEntity.ok().build();
    }
}
