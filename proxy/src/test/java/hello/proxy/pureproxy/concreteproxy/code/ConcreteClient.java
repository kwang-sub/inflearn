package hello.proxy.pureproxy.concreteproxy.code;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ConcreteClient {

    private ConcreteLogic concreteLogic;

    public void execute() {
        concreteLogic.operation();
    }
}
