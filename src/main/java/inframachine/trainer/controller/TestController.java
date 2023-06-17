package inframachine.trainer.controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import inframachine.trainer.model.Form;


@RestController
public class TestController {

    @PostMapping("/test/{id}")
    public String test(@PathVariable String id,
                       Form form) {
        return form.toString();
    }
}
