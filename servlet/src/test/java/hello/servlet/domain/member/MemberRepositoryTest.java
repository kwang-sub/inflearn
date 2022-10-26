package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void setup() {
        memberRepository.clearStore();
    }

    @Test
    void save() throws Exception {
        //given
        Member member = new Member("hello", 20);
        //when
        Member saveMember = memberRepository.save(member);
        //then
        Member findMember = memberRepository.findById(saveMember.getId());
        assertThat(findMember).isEqualTo(saveMember);
    }

    @Test
    void findAll() throws Exception {
        //given
        Member member1 = new Member("hello1", 20);
        Member member2 = new Member("hello2", 30);
        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<Member> all = memberRepository.findAll();
        //then
        assertThat(all.size()).isEqualTo(2);
        assertThat(all).contains(member1, member2);
    }
}