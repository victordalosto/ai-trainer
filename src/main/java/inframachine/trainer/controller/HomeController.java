package inframachine.trainer.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import inframachine.trainer.model.Pagination;
import inframachine.trainer.model.Parameter;
import inframachine.trainer.service.DatabaseRepository;
import inframachine.trainer.service.PaginationService;


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

    @Autowired
    private PaginationService paginationService;


    @GetMapping("/")
    public String home(Model model, 
                       Pagination pagination)
    {

        paginationService.fixPagination(pagination);
        
        model.addAttribute("title", title);
        model.addAttribute("parameters", parameters);
        model.addAttribute("classifications", classifications);

        model.addAttribute("total", databaseRepository.getDatabaseLength());
        model.addAttribute("contador", databaseRepository.getMappedLength());
        model.addAttribute("domains", databaseRepository.getDomains(pagination.getPage()));
        model.addAttribute("item", pagination.getItem());

        return "home";
    }

}
