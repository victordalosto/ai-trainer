package infralearning.trainer.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import infralearning.trainer.model.Domain;
import infralearning.trainer.model.Layers;
import infralearning.trainer.model.Pagination;
import infralearning.trainer.service.DatabaseRepository;


@Controller
public class HomeController {

    @Value("#{systemEnvironment['INFRAMACHINE_IMAGES_URL']}")
    private String imageURL;

    @Autowired
    private List<Layers> layers1;

    @Autowired
    private List<Layers> layers2;

    @Autowired
    private DatabaseRepository databaseRepository;


    @GetMapping("/")
    public String home(Model model, Pagination pagination) {
        return execute(model, pagination);
    }


    private String execute(Model model, Pagination pagination) {
        Page<Domain> domains = databaseRepository.getDomainsInPage(pagination.getPage(),
                                                                   pagination.getLayer1(),
                                                                   pagination.getLayer2());
        model.addAttribute("domains", domains);
        model.addAttribute("domain", domains.getContent().get(pagination.getItem()));

        model.addAttribute("total", databaseRepository.getTableCount());
        model.addAttribute("count", databaseRepository.getTotalOfDomainsmapped());

        model.addAttribute("page", domains.getPageable().getPageNumber());
        model.addAttribute("item", pagination.getItem());

        model.addAttribute("layer1", pagination.getLayer1());
        model.addAttribute("layer2", pagination.getLayer2());

        model.addAttribute("layers1", layers1);
        model.addAttribute("layers2", layers2);

        model.addAttribute("imageurl", imageURL);

        return "home";
    }


}
