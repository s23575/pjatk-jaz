package pl.edu.pjatk.jaz.nbp.rates.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<String> NotFound() {
        return ResponseEntity.status(404).body("NOT FOUND");
    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<String> BadRequest(HttpClientErrorException e) {
        if (e.getResponseBodyAsString().equals("400 BadRequest - Przekroczony limit 367 dni / Limit of 367 days has " +
                "been exceeded")) {
            return ResponseEntity.status(400).body("BAD REQUEST (EXCEEDED LIMIT OF 367 DAYS)");
        } else {
            return ResponseEntity.status(400).body("BAD REQUEST");
        }
    }

}
