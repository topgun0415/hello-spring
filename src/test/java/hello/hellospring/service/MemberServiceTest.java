package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clear();
    }

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("Philip");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void joinExceptionValidator() {
        //given
        Member member1 = new Member();
        member1.setName("Ava");

        Member member2 = new Member();
        member2.setName("Ava");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("There already has a same member");

//        try {
//            memberService.join(member2);
//            fail();
//        } catch(IllegalStateException e) {
//            Assertions.assertThat(e.getMessage()).isEqualTo("There already has a same member");
//        }
        //then

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}