package hello.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpecificationController {
    @RequestMapping("/")
    public String genIndex(){
        //return "index.html";
        return null;
    }
}
