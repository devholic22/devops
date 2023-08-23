package devholic.devops;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private MemberRepository memberRepository;

    public MemberResponse create(MemberRequest request) {

        Member newMember = Member.from(request.getName());
        memberRepository.save(newMember);

        return MemberResponse.from(newMember.getId(), newMember.getName());
    }

    public MemberResponse find(Long id) {

        Member findMember = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("멤버가 없습니다."));

        return MemberResponse.from(findMember.getId(), findMember.getName());
    }
}
