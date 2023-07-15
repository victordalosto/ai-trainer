package infralearning.trainer.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import infralearning.trainer.model.Form;
import infralearning.trainer.service.DatabaseRepository;


@Controller
public class PostController {

    @Autowired
    private DatabaseRepository repository;

    
    @PostMapping("/post/{id}")
    public String test(@PathVariable String id, Form form, Model model) {
        repository.save(form, id);
        return "redirect:" + form.getNextPage();
    }
 
}
