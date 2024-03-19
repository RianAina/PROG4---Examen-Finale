package service;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class endpointTest {

    @GetMapping("/Hello")
    public String test(){
        return "Hello World";
    }
}