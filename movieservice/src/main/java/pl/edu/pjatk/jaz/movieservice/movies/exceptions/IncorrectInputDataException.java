package pl.edu.pjatk.jaz.movieservice.movies.exceptions;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;

public class IncorrectInputDataException extends HttpMessageNotReadableException {
    public IncorrectInputDataException(String msg, Throwable cause, HttpInputMessage httpInputMessage) {
        super(msg, cause, httpInputMessage);
    }
}
