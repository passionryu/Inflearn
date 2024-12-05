package hello.core.Member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository = new MemberMemberRepository();

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
