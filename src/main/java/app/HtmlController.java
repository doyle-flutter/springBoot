package app;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    // res HTML
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/hello")
    public String getApiHTML(Model model){
        model.addAttribute("name", "My Name is James");
        return "hello";
    }
}
