package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class helloController {

    // Mapping URL
    @GetMapping("hello")
    public String hello(Model model) {
        // attribute data to html "data" = "hello!!"
        model.addAttribute("data", "spring!!");
        // Return value is templates/hello.html
        return "hello";
    }
}
