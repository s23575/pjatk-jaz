package pl.edu.pjatk.jaz.movieservice.movies.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> getMovieById() {
        return ResponseEntity.status(404).body("NOT FOUND");
//        return ResponseEntity.status(404).build();
    }

    @ExceptionHandler({IncorrectInputDataException.class, HttpMessageNotReadableException.class})
    public ResponseEntity<String> addOrUpdateMovie() {
        return ResponseEntity.status(400).body(("BAD REQUEST"));
//        return ResponseEntity.status(400).build();
    }
}
