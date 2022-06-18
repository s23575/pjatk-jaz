package pl.edu.pjatk.jaz.jazs23575nbp.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.net.ConnectException;

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
    // Powyższe, to kody błędów, które może zwrócić NBP, zgodnie z dokumentacją: http://api.nbp.pl/

    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<String> InternalServerError() {
        return ResponseEntity.status(502).body("INTERNAL SERVER ERROR");
    }

    @ExceptionHandler(ConnectException.class)
    public ResponseEntity<String> ConnectException() {
        return ResponseEntity.status(504).body("CONNECT EXCEPTION");
    }

}