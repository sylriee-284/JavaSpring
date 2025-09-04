package vn.hoidanit.laptopshop;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloWorld {

    @GetMapping("/")
    public String index() {
        return "Hello World from Spring Boot, I am Syl1!";
    }

    @GetMapping("/user")
    public String userPage() {
        return "Only users can see this page!";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "only admins can see this page!";
    }

}
 