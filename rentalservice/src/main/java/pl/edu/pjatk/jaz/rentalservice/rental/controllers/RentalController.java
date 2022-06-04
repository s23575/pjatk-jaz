package pl.edu.pjatk.jaz.rentalservice.rental.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<Movie> getMovie(@PathVariable Integer id) {
        return ResponseEntity.ok(rentalService.getMovie(id));
    }

    @PutMapping("/movies/return/{id}")
    public ResponseEntity<Movie> returnMovie(@PathVariable Integer id) {
        return ResponseEntity.ok(rentalService.returnMovie(id));
    }

    @PutMapping("/movies/rent/{id}")
    public ResponseEntity<Movie> rentMovie(@PathVariable Integer id) {
        return ResponseEntity.ok(rentalService.rentMovie(id));
    }
}
