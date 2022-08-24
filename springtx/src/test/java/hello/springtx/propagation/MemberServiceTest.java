package hello.springtx.propagation;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    LogRepository logRepository;

    @Test
    void outerTxOff_success() throws Exception {
        //given
        String username = "outerTxOff_success";
        //when
        memberService.joinV1(username);
        //then
        assertThat(memberRepository.find(username)).isPresent();
        assertThat(logRepository.find(username)).isPresent();
    }

    @Test
    void outerTxOff_fail() throws Exception {
        //given
        String username = "로그예외_outerTxOff_fail";
        //when
        assertThatThrownBy(() ->memberService.joinV1(username))
                .isInstanceOf(RuntimeException.class);
        //then
        assertThat(memberRepository.find(username)).isPresent();
        assertThat(logRepository.find(username)).isEmpty();
    }

    @Test
    void singleTx() throws Exception {
        //given
        String username = "outerTxOff_success";
        //when
        memberService.joinV1(username);
        //then
        assertThat(memberRepository.find(username)).isPresent();
        assertThat(logRepository.find(username)).isPresent();
    }

}