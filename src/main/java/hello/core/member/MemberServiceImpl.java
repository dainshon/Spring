package hello.core.member;

public class MemberServiceImpl implements MemberService{

    //memberservice에 대한 구현체.

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //MemorymemberRepository에 있는 save 호출됨. 다형성 의해서
    //껍데기 memberRepository를 MemoryMemberRepository로 채운다고 생각해도될듯>

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
