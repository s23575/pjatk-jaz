package pl.pjatk.maczag.sandbox.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.maczag.sandbox.Models.Student;

@RestController
@RequestMapping("/homework")
public class HomeworkController {

    @GetMapping("/get/{id}/{indeks}/{imie}/{nazwisko}")
    public ResponseEntity<Student> getStudentWithValue(@PathVariable Integer id, @PathVariable String indeks,
                                                       @PathVariable String imie, @PathVariable String nazwisko) {
        return ResponseEntity.ok(new Student(id, indeks, imie, nazwisko));
    }
    // localhost:8080/homework/get/1/s12345/jan/kowalski

    @GetMapping("/get")
    public ResponseEntity<Student> getStudentWithParam(@RequestParam Integer id, @RequestParam String indeks,
                                                       @RequestParam String imie, @RequestParam String nazwisko) {
        return ResponseEntity.ok(new Student(id, indeks, imie, nazwisko));
    }
    // localhost:8080/homework/get?id=1&indeks=s12345&imie=jan&nazwisko=kowalski

    @PutMapping("/put/{id}/{indeks}/{imie}/{nazwisko}")
    public ResponseEntity<Student> putStudentWithValue(@PathVariable Integer id, @PathVariable String indeks,
                                                       @PathVariable String imie, @PathVariable String nazwisko) {
        return ResponseEntity.ok(new Student(id, indeks, imie, nazwisko));
    }
    // localhost:8080/homework/put/1/s12345/jan/kowalski

    @PutMapping("/put")
    public ResponseEntity<Student> putStudentWithRequestBody(@RequestBody Student student) {
        return ResponseEntity.ok(student);
    }
    // localhost:8080/homework/put

    @PutMapping("/put/{id}")
    public ResponseEntity<Student> putStudentWithValueAndRequestBody(@PathVariable Integer id,
                                                                     @RequestBody Student student) {
        return ResponseEntity.ok(new Student(id, student.getIndeks(), student.getImie(), student.getNazwisko()));
    }
    // localhost:8080/homework/put/17

    @PostMapping("/post")
    public ResponseEntity<Student> postStudentWithRequestBody(@RequestBody Student student) {
        return ResponseEntity.ok(student);
    }
    //  localhost:8080/homework/post
    //  {
    //      "id": 18,
    //      "indeks": "s12345",
    //      "imie": "andrzej",
    //      "nazwisko": "nowak"
    //  }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteStudentWithValue(@PathVariable Integer id) {
        return ResponseEntity.status(200).build();
//        return ResponseEntity.status(200).body("Test");
    }
    // localhost:8080/homework/delete/13

}