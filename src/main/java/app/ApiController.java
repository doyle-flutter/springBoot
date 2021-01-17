package app;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.Objects;

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

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/sendNode/{id}")
    public String getApiReq(@PathVariable("id") String id){
        final String API_SERVER = "http://192.168.0.3:3000";
        final String PATH = "/spring";
        final String queryString = "?id="+id;

        WebClient client = WebClient
                .builder()
                .baseUrl(API_SERVER+PATH+queryString)
                .defaultCookie("cook","CookValue")
                .defaultHeader("CustomHeader",id)
                .build();
        WebClient.RequestHeadersSpec<?> req = client.get();
        String response = Objects.requireNonNull(req.exchange().block()).bodyToMono(String.class).block();
        return String.format("{\"result\":\"Node.js\", \"id\" : %s}", response);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/{id}")
    public String getApiNotFound(@PathVariable("id") String id){
        return String.format("{\"result\":\"notFound404\", \"id\" : \"%s\"}", id);
    }
}
