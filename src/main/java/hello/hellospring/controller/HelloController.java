package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    // url that requested by client give specific address of webpage
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        model.addAttribute("name", "philip");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template1";
    }


}
