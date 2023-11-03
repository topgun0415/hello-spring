package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    // 그냥 html을 보여준다. 특히 저 ResponseBody 어노테이션이 핵심
    @GetMapping("hello-string")
    @ResponseBody
    public String helloSrping(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    // 객체를 반환하고 어노테이션으로 ResponseBody가 있으면 기본으로 JSON타입 반환
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;

    }

    static class Hello {
        private String name;

        // 프로퍼티 접근방식
        public String getName() {
            return name;
        }
        public String setName(String name) {
            return this.name = name;
        }
    }

}
