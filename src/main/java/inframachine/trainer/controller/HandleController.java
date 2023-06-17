package inframachine.trainer.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import inframachine.trainer.model.Form;


@Controller
public class HandleController {

    @PostMapping("/test/{id}")
    public String test(@PathVariable String id,
                       Form form,
                       Model model) {
        
        return method(form);
    }

    private String method(Form form) {
        String string = "redirect:" + form.getNextPage();
        System.out.println(string);
        return string;
    }
}
