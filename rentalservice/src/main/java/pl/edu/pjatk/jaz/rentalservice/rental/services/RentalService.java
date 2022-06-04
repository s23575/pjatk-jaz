package pl.edu.pjatk.jaz.rentalservice.rental.services;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.edu.pjatk.jaz.rentalservice.rental.models.Movie;

import java.util.Optional;

@Service
public class RentalService {

    private static final String resourceUrl = "http://localhost:8080/movieservice/movies/";

    public Movie getMovie(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Movie> response = restTemplate
                .exchange(resourceUrl + id, HttpMethod.GET, null, Movie.class);
        return Optional.ofNullable(response.getBody()).orElseThrow();
    }

    public Movie returnMovie(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Movie> response = restTemplate
                .exchange(resourceUrl + "availability/true/" + id, HttpMethod.PUT, null, Movie.class);
        return response.getBody();
    }

    public Movie rentMovie(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Movie> response = restTemplate
                .exchange(resourceUrl + "availability/false/" + id, HttpMethod.PUT, null, Movie.class);
        return response.getBody();
    }

}
