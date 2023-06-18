package inframachine.trainer.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import inframachine.trainer.model.Domain;
import inframachine.trainer.model.Pagination;
import inframachine.trainer.model.Layers;
import inframachine.trainer.service.DatabaseRepository;
import inframachine.trainer.service.PaginationService;


@Controller
public class HomeController {

    @Value("${title}")
    private String title;

    @Value("${inframachine.imageurl}")
    private String imageurl;

    @Autowired
    private List<Layers> primaryLayer;

    @Autowired
    private List<Layers> secondaryLayer;

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
        model.addAttribute("primaryLayer", primaryLayer);
        model.addAttribute("secondaryLayer", secondaryLayer);

        model.addAttribute("total", databaseRepository.getDatabaseLength());
        model.addAttribute("count", databaseRepository.getMappedLength());

        Page<Domain> domains = databaseRepository.getDomains(pagination.getPage());
        model.addAttribute("domains", domains);
        model.addAttribute("domain", domains.getContent().get(pagination.getItem()));
        model.addAttribute("page", domains.getPageable().getPageNumber());
        model.addAttribute("item", pagination.getItem());

        model.addAttribute("imageurl", imageurl);

        return "home";
    }

}
