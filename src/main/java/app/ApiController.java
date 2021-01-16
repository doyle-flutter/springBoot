package app;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController{

    // 정적 Path
    @CrossOrigin(origins="*")
    @GetMapping(path = "/")
    public String getApi(){
        return "{\"result\":\"value\"}";
    }

    // 동적 Path
    @CrossOrigin(origins="*")
    @GetMapping(path = "/data/{id}")
    public String getApiData(@PathVariable("id") String id){
        System.out.println(id);
        return String.format("{\"result\":\"value\", \"id\" : \"%s\"}", id);
    }

    // QueryString
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/qs")
    public String getApiQs(@RequestParam(value="id", defaultValue="no") String id){
        System.out.println(id);
        return String.format("{\"result\":\"value\", \"id\" : \"%s\"}", id);
    }
}
