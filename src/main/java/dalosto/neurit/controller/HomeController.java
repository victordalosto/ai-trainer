package dalosto.neurit.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import dalosto.neurit.model.Parameter;


@Controller
public class HomeController {

    @Autowired
    private List<Parameter> parameters;

    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("parameters", parameters);
        return "home";
    }

}
