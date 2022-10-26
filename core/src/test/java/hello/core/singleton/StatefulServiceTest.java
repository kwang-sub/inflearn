package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    void statefulServiceSingleton() {
        StatefulService bean1 = ac.getBean(StatefulService.class);
        StatefulService bean2 = ac.getBean(StatefulService.class);

        int userA = bean1.order("userA", 10000);
        int userB = bean2.order("userB", 20000);

        System.out.println(userA);

        Assertions.assertThat(userA).isEqualTo(10000);

    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}