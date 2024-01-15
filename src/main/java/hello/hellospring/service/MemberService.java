package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * Member Join
     */
    public Long Join(Member member) {

        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    /**
     * Find all joined member
     */
    public List<Member> findMembers() {
        return memberRepository.findByAll();
    }

    /**
     * Find a joined member
     */
    public Optional<Member> findOne(Long memberId) {
       return memberRepository.findById(memberId);
    }

    /**
     * Check Duplicate Member (Using in Join method)
     * @param member
     */
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m -> {
            throw new IllegalStateException("There already has a same member");
        });
    }

}
