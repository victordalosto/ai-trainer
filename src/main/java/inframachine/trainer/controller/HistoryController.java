package inframachine.trainer.controller;
import java.util.List;
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
        List<TableRow> table = repository.getTable();
        model.addAttribute("table", table);
        model.addAttribute("totalOfRows", table.stream().mapToLong(TableRow::getCount).sum());
        return "history";
    }
}
