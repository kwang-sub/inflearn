package hello.proxy.pureproxy.concreteproxy.code;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class TimeProxy extends ConcreteLogic{

    private ConcreteLogic concreteLogic;

    @Override
    public String operation() {
        log.info("TimeDecorator 실행");
        long start = System.currentTimeMillis();
        String result = concreteLogic.operation();
        long end = System.currentTimeMillis();
        log.info("timeDecorator 종료 = {}ms", end - start);
        return result;
    }
}
