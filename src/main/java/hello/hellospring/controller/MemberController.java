package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// Controller 에너테이션이 생성될 경우 스프링 자체에서 객체 컨테이너를 생성해서 만들어둔다. 스프링부트에는 톰캣서버가 내장되어있다.
@Controller
public class MemberController {

    private final MemberService memberService;

    // MemeberService의 객체와 딱 연결시켜주는 에너테이션
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
