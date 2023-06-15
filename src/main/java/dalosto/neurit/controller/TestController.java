package dalosto.neurit.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;


@RestController
public class TestController {

    @PostMapping("/test")
    public String test(HttpServletRequest request, String email, String senha) {
        System.out.println(email);
        System.out.println(senha);
        return "Teste";
    }
}
