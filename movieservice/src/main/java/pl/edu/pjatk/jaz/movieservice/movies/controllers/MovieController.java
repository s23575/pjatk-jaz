package pl.edu.pjatk.jaz.movieservice.movies.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.jaz.movieservice.movies.exceptions.NotFoundException;
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
    @ApiOperation(value = "Find all movies", notes = "Retrieving the list of movies", response =
            Movie[].class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "SUCCESS", response = Movie[].class)
    })
    public ResponseEntity<List<Movie>> getMovieList() {
//        return ResponseEntity.ok(movieService.getMovieList());
        return ResponseEntity.ok(movieService.findAll());
    }

    @GetMapping("/movies/{id}")
    @ApiOperation(value = "Find movie by ID", notes = "Retrieving the movie by ID", response =
            Movie.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "SUCCESS (MOVIE FOUND)", response = Movie.class),
            @ApiResponse(code = 404, message = "NOT FOUND (MOVIE BY ID)", response = NotFoundException.class)
    })
    public ResponseEntity<Movie> getMovieById(@PathVariable Integer id) {
//        return ResponseEntity.ok(movieService.getMovieById(id));
        return ResponseEntity.ok(movieService.findById(id));
    }

    @PostMapping("/movies/add")
    @ApiOperation(value = "Add movie", notes = "Adding the movie using RequestBody", response =
            Movie.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "SUCCESS (MOVIE ADDED)", response = Movie.class)
    })
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movieToAdd) {
//        return ResponseEntity.ok(movieService.addMovie(movieToAdd));
        return ResponseEntity.ok(movieService.saveMovie(movieToAdd));
    }
//    {
//        "title": "Szklana pułapka",
//        "originalTitle": "Die Hard",
//        "genre": "DRAMA",
//        "yearOfProduction": 1987
//    }


    @PutMapping("/movies/{id}")
    @ApiOperation(value = "Update movie", notes = "Updating the movie by ID", response =
            Movie.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "SUCCESS (MOVIE UPDATED)", response = Movie.class),
            @ApiResponse(code = 404, message = "NOT FOUND (MOVIE TO UPDATE BY ID)", response = NotFoundException.class)
    })
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
    @ApiOperation(value = "Delete movie", notes = "Deleting the movie by ID", response =
            Movie.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "SUCCESS (MOVIE DELETED)"),
            @ApiResponse(code = 404, message = "NOT FOUND (MOVIE TO DELETE BY ID)", response = NotFoundException.class)
    })
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "NO CONTENT")
    public ResponseEntity<Void> deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/movies/availability/true/{id}")
    @ApiOperation(value = "Update movie availability to true", notes = "Updating the movie availability to true by ID",
            response = Movie.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "SUCCESS (MOVIE AVAILABILITY TO TRUE UPDATED)", response = Movie.class),
            @ApiResponse(code = 404, message = "NOT FOUND (MOVIE TO UPDATE AVAILABILITY TO TRUE BY ID)",
                    response = NotFoundException.class)
    })
    public ResponseEntity<Movie> updateMovieAvailabilityTrueById(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.updateAvailabilityTrue(id));
    }

    @PutMapping("/movies/availability/true")
    @ApiOperation(value = "Update all movies availability to true", notes = "Updating all the movies availability to " +
            "true", response = Movie.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "SUCCESS (MOVIES AVAILABILITY TO TRUE UPDATED)", response = Movie.class)
    })
    public ResponseEntity<List<Movie>> updateMovieAvailabilityTrue() {
        return ResponseEntity.ok(movieService.updateAvailabilityTrueAll());
    }

    @PutMapping("/movies/availability/false/{id}")
    @ApiOperation(value = "Update movie availability to false", notes = "Updating the movie availability to false by " +
            "ID", response = Movie.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "SUCCESS (MOVIE AVAILABILITY TO FALSE UPDATED)", response = Movie.class),
            @ApiResponse(code = 404, message = "NOT FOUND (MOVIE TO UPDATE AVAILABILITY TO FALSE BY ID)",
                    response = NotFoundException.class)
    })
    public ResponseEntity<Movie> updateMovieAvailabilityFalseById(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.updateAvailabilityFalse(id));
    }

    @PutMapping("/movies/availability/false")
    @ApiOperation(value = "Update all movies availability to false", notes = "Updating all the movies availability " +
            "to false", response = Movie.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "SUCCESS (MOVIES AVAILABILITY TO FALSE UPDATED)", response = Movie.class)
    })
    public ResponseEntity<List<Movie>> updateMovieAvailabilityFalse() {
        return ResponseEntity.ok(movieService.updateAvailabilityFalseAll());
    }
}
