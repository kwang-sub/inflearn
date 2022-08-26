package hello.proxy.pureproxy.decorator;

import hello.proxy.pureproxy.decorator.code.DecoratorPatternClient;
import hello.proxy.pureproxy.decorator.code.MessageDecorator;
import hello.proxy.pureproxy.decorator.code.RealComponent;
import hello.proxy.pureproxy.decorator.code.TimeDecorator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorPatternTest {

    @Test
    void noDecorator() throws Exception {
        //given
        RealComponent realComponent = new RealComponent();
        DecoratorPatternClient decoratorPatternClient = new DecoratorPatternClient(realComponent);
        //when
        decoratorPatternClient.execute();
        //then
    }

    @Test
    void decorator1() throws Exception {
        //given
        RealComponent realComponent = new RealComponent();
        MessageDecorator messageDecorator = new MessageDecorator(realComponent);
        DecoratorPatternClient decoratorPatternClient = new DecoratorPatternClient(messageDecorator);
        //when
        decoratorPatternClient.execute();
        //then
    }

    @Test
    void decorator2() throws Exception {
        //given
        RealComponent realComponent = new RealComponent();
        MessageDecorator messageDecorator = new MessageDecorator(realComponent);
        TimeDecorator timeDecorator = new TimeDecorator(messageDecorator);
        DecoratorPatternClient decoratorPatternClient = new DecoratorPatternClient(timeDecorator);
        //when
        decoratorPatternClient.execute();
        //then
    }
}
