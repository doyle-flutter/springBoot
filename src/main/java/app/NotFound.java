package app;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NotFound implements ErrorController {
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/error")
    public String getApiNotError(){
        return "notFound";
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
