package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name);

        return "hello-template";
    }
}
