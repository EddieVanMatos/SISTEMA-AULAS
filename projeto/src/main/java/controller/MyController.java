package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    // Rota para um GET request
    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring!";
    }

    // Rota para um POST request
    @PostMapping("/submit")
    public String submitData() {
        return "Data submitted!";
    }
}
