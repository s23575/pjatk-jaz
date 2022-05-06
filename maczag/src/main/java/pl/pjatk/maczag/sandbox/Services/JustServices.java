package pl.pjatk.maczag.sandbox.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.pjatk.maczag.sandbox.Models.Car;

import java.util.List;

@Service
public class JustServices {

    public String getHello() {
        return "Hello world";
    }

    public Car getCar() {
        return new Car("Testowy", 1);
    }

    public String getHelloWithValue(Integer id) {
        return "Hello world : id : " + id;
    }

    public String getHelloWithParam(String reqParam) {
        return "Hello world : param : " + reqParam;
    }

    public String getHelloWithParam(List<String> reqParam) {
        return "Hello world : param : " + reqParam.toString();
    }

    public Car getCarFromBody(Car car) {
        return car;
    }

    public void returnRuntimeException() {
        throw new RuntimeException("Test RuntimeException");
    }

    public void returnNullPointerException() {
        throw new NullPointerException("Test NullPointerException");
    }
}
