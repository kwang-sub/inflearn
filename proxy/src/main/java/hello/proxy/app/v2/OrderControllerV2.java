package hello.proxy.app.v2;

import hello.proxy.app.v1.OrderControllerV1;
import hello.proxy.app.v1.OrderServiceV1;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@RequestMapping
@ResponseBody
@RequiredArgsConstructor
public class OrderControllerV2 implements OrderControllerV1 {

    private final OrderServiceV2 orderService;

    @GetMapping("/v2/request")
    public String request(String itemId) {
        orderService.orderItem(itemId);
        return "ok";
    }

    @GetMapping("/v2/no-log")
    public String noLog() {
        return null;
    }
}