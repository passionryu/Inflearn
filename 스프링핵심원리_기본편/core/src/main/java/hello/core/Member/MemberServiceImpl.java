package hello.core.Member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    // MemberRepository에 무엇이 들어갈지는 생성자를 통해 넣어주면 된다.
    // 이렇게 되면 멤버 서비스는 전적으로 멤버 레포지토리라는 추상화에만 의존하게 된다 - DIP
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입 메서드
     * @param member
     */
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    /**
     * 아이디로 멤버 조회 메서드
     * @param memberId
     * @return
     */
    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
