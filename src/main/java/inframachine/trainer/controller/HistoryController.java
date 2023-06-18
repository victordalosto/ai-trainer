package inframachine.trainer.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import inframachine.trainer.model.TableRow;
import inframachine.trainer.repository.DomainRepository;


@Controller
public class HistoryController {

    @Autowired
    private DomainRepository repository;


    @GetMapping("/history")
    public String history(Model model) {
        model.addAttribute("table", repository.getTable());
        model.addAttribute("totalOfRows", repository.getTable().stream().mapToLong(TableRow::getCount).sum());
        return "history";
    }
}
