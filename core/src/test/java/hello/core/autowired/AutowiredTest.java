package hello.core.autowired;

import hello.core.member.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
        ac.getBean(TestBean.class);
    }

    static class TestBean {

        @Autowired(required = false)
        public void setNoBean1(Member member){
            System.out.println("TestBean.setNoBean1 = " + member);
        };

        @Autowired
        public void setNoBean2(@Nullable Member member) {
            System.out.println("TestBean.setNoBean2 = " + member);
        }

        @Autowired
        public void setNoBean3(Optional<Member> member) {
            System.out.println("TestBean.setNoBean3 = " + member);
        }


    }
}
