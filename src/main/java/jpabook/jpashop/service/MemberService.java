package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) // readonly default 는 false
@RequiredArgsConstructor // final 이 있는 필드만 채워줌.
//@AllArgsConstructor // 전체 필드 채워주는 생성자 생성.
public class MemberService {

    private final MemberRepository memberRepository;

    // 최신 spring 버전에선 autowired 가 없어도 생성자가 1개 인 경우에는 알아서 auto wired injection 을 해줌.

    // 회원 가입
    @Transactional
    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        // 실무에선 member name 을 unique 제약 조건으로 달기 (멀티 스레드에 의해 중복될 수 있으니)
        if(!memberRepository.findByName(member.getName()).isEmpty())
            throw new IllegalStateException("이미 존재하는 회원입니다.");
    }

    // 회원 전체 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    // 회원 조회
    public Member findMember(Long id){
        return memberRepository.findOne(id);
    }

    @Transactional
    public void update(Long id, String name){
        Member member = memberRepository.findOne(id);
        member.setName(name);
    }
}
