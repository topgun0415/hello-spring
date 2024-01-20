package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
// This service class is to do something with memoryMemberRepository.
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;

    }

    /**
     * Member Join
     */
    public Long join(Member member) {

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
