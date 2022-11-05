package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // 1. Static
    // url that requested by client give specific address of webpage
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        model.addAttribute("name", "philip");
        return "hello";
    }

    // 2. Template engine
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template1";
    }

    // 3. API with string
    // ResponseBody = If client get access to hello-string then server will return the pure data in body tag
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    // 4. API with JSON
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;

    }

    public static class Hello {
        private String name;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
