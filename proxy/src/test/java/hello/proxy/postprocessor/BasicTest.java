package hello.proxy.postprocessor;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;

@Slf4j
public class BasicTest {
    @Test
    void basicConfig() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(BasicTest.BasicConfig.class);
        A beanA = (BasicTest.A) ac.getBean("beanA");
        beanA.helloA();

        assertThatThrownBy(() -> ac.getBean(B.class))
                .isInstanceOf(NoSuchBeanDefinitionException.class);
    }

    @TestConfiguration
    static class BasicConfig {
        @Bean(name = "beanA")
        public A a() {
            return new A();
        }
    }

    static class A {
        public void helloA() {
            log.info("hello A");
        }
    }
    static class B {
        public void helloB() {
            log.info("hello B");
        }
    }
}
