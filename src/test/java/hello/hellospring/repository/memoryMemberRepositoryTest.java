package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class memoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("Philip");
        repository.save(member);

        repository.findById(member.getId());

        Member result = repository.findById(member.getId()).get();
        Assertions.assertEquals(member, null);
    }
}
