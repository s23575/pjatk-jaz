package pl.pjatk.maczag.sandbox.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.maczag.sandbox.Models.Car;

import java.util.List;

@RestController
@RequestMapping("/test")
public class JustRestController {

    @GetMapping("/hello")
    public ResponseEntity<String> getHello() {
        ResponseEntity<String> helloWorld = ResponseEntity.ok("Hello world");
//        ResponseEntity.BodyBuilder ok = ResponseEntity.ok();
//        ResponseEntity<Object> build = ResponseEntity.ok().build();
//        ResponseEntity<String> abc = ResponseEntity.ok().body("abc");
//        ResponseEntity.BodyBuilder bodyBuilder = ResponseEntity.badRequest();
//        ResponseEntity<Object> build1 = ResponseEntity.badRequest().build();
//        ResponseEntity.status(700).body("przykładowy String");
//        ResponseEntity.status(700).build();
        return helloWorld;
    }

    @GetMapping("/model")
//    @RequestMapping(name = "/model", method = GET) <- Tak w przeszłości to było formułowane
    public ResponseEntity<Car> getCar() {
//        ResponseEntity<Car> car = ResponseEntity.ok(new Car("Testowy",1));
//        return car;
        return ResponseEntity.ok(new Car("Testowy", 1));
    }

    @GetMapping("/hello/{id}")
    public ResponseEntity<String> getHelloWithValue(@PathVariable Integer id) {
        return ResponseEntity.ok("Hello world : id : " + id);
    }

    @GetMapping("/hello2")
    public ResponseEntity<String> getHelloWithParam(@RequestParam String reqParam) {
        return ResponseEntity.ok("Hello world : param : " + reqParam);
    }

    @GetMapping("/hello3")
    public ResponseEntity<String> getHelloWithParam(@RequestParam List<String> reqParam) {
        return ResponseEntity.ok("Hello world : param : " + reqParam.toString());
        // http://localhost:8080/test/hello2?reqParam=test&reqParam=test2&reqParam=test3
    }

//    @GetMapping("/car2")
//    public ResponseEntity<Car> getHelloWithParam(@RequestParam String name, Integer id) {
//        return ResponseEntity.ok(new Car(name, id));
//    }

    @PostMapping("/car2")
    public ResponseEntity<Car> getCarFromBody(@RequestBody Car car) {
        return ResponseEntity.ok(car);
    }

}