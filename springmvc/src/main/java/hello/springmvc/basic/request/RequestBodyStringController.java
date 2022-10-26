package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyStringController {

    @PostMapping("/request-body-string-v1")
    public void requestBodyString(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String body = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("messageBody = {}", body);
        response.getWriter().write("OK");
    }

    @PostMapping("/request-body-string-v2")
    public void requestBodyString2(InputStream inputStream, Writer responseWriter) throws IOException {
        String body = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("messageBody = {}", body);
        responseWriter.write("OK");
    }

    @PostMapping("/request-body-string-v3")
    public HttpEntity<String> requestBodyString3(RequestEntity<String> httpEntity) throws IOException {
        String body = httpEntity.getBody();
        log.info("messageBody = {}", body);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

    @ResponseBody
    @PostMapping(value = "/request-body-string-v4")
    public HttpEntity<String> requestBodyString4(@RequestBody String body) throws IOException {
        log.info("messageBody = {}", body);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }
}
