package pl.pjatk.maczag.sandbox.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> postStudentWithRequestBody(RuntimeException e) {
        return ResponseEntity.status(404).body("Exception occurred on request. Exception message:" + e.getLocalizedMessage());
    }

}
