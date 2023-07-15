package infralearning.trainer.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import infralearning.trainer.model.Layers;
import infralearning.trainer.model.TableRow;
import infralearning.trainer.repository.DomainRepository;


@Controller
public class HistoryController {

    @Autowired
    private DomainRepository repository;

    @Autowired
    private List<Layers> layers1;

    @Autowired
    private List<Layers> layers2;


    @GetMapping("/history")
    public String history(Model model) {
        List<TableRow> table = repository.getTable();
        model.addAttribute("table", table);
        model.addAttribute("totalOfRows", table.stream().mapToLong(TableRow::getCount).sum());

        model.addAttribute("layers1", layers1);
        model.addAttribute("layers2", layers2);
        return "history";
    }
}
