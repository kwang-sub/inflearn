package jpabook.jpashop;

import jpabook.jpashop.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

//    @Test
//    @Transactional
//    @Commit
//    public void testMember() throws Exception {
//        Member member = new Member();
//        member.setUserName("memberA");
//
//        Long saveId = memberRepository.save(member);
//        Member findMember = memberRepository.find(saveId);
//
//        assertThat(findMember.getId()).isEqualTo(member.getId());
//        assertThat(findMember.getUserName()).isEqualTo(member.getUserName());
//        assertThat(findMember).isSameAs(member);
//    }
}