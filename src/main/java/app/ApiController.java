package app;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @CrossOrigin(origins="http://localhost:3000")
    @GetMapping(path = "/")
    public String getApi(){
        return "{\"result\":\"value\"}";
    }
}
