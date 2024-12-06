package hello.core.Member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{


    private static Map<Long,Member> store = new HashMap<>();

    /**
     * 멤버 저장 메서드 - (아이디,멤버 객체) 쌍으로 저장
     * @param member 멤버 객체
     */
    @Override
    public void save(Member member) {
        store.put(member.getId(),member);
    }

    /**
     * 아이디로 멤버 검색 메서드
     * @param memberId 찾고자 하는 멤버의 아이디
     * @return 대상 멤버 객체
     */
    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
