package dalosto.neurit.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import dalosto.neurit.model.Parameter;
import dalosto.neurit.service.DatabaseRepository;


@Controller
public class HomeController {

    @Value("${title}")
    private String title;

    @Autowired
    private List<Parameter> parameters;

    @Autowired
    private List<Parameter> classifications;

    @Autowired
    private DatabaseRepository databaseRepository;


    @GetMapping("/")
    public String home(Model model, 
                      @RequestParam(defaultValue = "1") int page,
                      @RequestParam(defaultValue = "1") int item)
    {
        model.addAttribute("title", title);
        model.addAttribute("parameters", parameters);
        model.addAttribute("classifications", classifications);

        model.addAttribute("total", databaseRepository.getDatabaseLength());
        model.addAttribute("contador", databaseRepository.getMappedLength());
        model.addAttribute("domains", databaseRepository.getDomains(page));

        return "home";
    }

}
