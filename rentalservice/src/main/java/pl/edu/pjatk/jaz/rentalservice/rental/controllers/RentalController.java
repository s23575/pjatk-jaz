package pl.edu.pjatk.jaz.rentalservice.rental.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import pl.edu.pjatk.jaz.rentalservice.rental.models.Movie;
import pl.edu.pjatk.jaz.rentalservice.rental.services.RentalService;

@RestController
@RequestMapping("/rentalservice")
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/movies/{id}")
    @ApiOperation(value = "Find movie by ID", notes = "Retrieving the movie by ID", response =
            Movie.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "SUCCESS (MOVIE FOUND)", response = Movie.class),
            @ApiResponse(code = 404, message = "NOT FOUND (MOVIE BY ID)",
                    response = HttpClientErrorException.NotFound.class)
    })
    public ResponseEntity<Movie> getMovie(@PathVariable Integer id) {
        return ResponseEntity.ok(rentalService.getMovie(id));
    }

    @PutMapping("/movies/return/{id}")
    @ApiOperation(value = "Return movie by ID", notes = "Returning the movie by ID", response =
            Movie.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "SUCCESS (MOVIE RETURNED)", response = Movie.class),
            @ApiResponse(code = 404, message = "NOT FOUND (MOVIE BY ID)",
                    response = HttpClientErrorException.NotFound.class)
    })
    public ResponseEntity<Movie> returnMovie(@PathVariable Integer id) {
        return ResponseEntity.ok(rentalService.returnMovie(id));
    }

    @PutMapping("/movies/rent/{id}")
    @ApiOperation(value = "Rent movie by ID", notes = "Renting the movie by ID", response =
            Movie.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "SUCCESS (MOVIE RENTED)", response = Movie.class),
            @ApiResponse(code = 404, message = "NOT FOUND (MOVIE BY ID)",
                    response = HttpClientErrorException.NotFound.class)
    })
    public ResponseEntity<Movie> rentMovie(@PathVariable Integer id) {
        return ResponseEntity.ok(rentalService.rentMovie(id));
    }
}
