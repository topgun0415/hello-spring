package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

// TDD(Test-Driven Development)
// It is a software development methodology where tests are written before the actual code that needs to be implemented.

public class memoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // This clear method will start after each test finished
    @AfterEach
    public void afterEach() {
        repository.clear();
    }


    // When there is an annotation with @Test, this is just one test
    @Test
    public void save() {
        Member member = new Member();
        member.setName("Philip");
        repository.save(member);
        repository.findById(member.getId());

        Member result = repository.findById(member.getId()).get();

        //Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findByAll();

        assertThat(result.size()).isEqualTo(2);
    }

}

