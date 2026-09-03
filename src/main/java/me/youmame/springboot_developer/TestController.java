package me.youmame.springboot_developer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "안녕하세요? /test 요청에 대한 응답입니다.";
    }

    @PostMapping("/test")
    public String postTest() {
        return "안녕하세요? /test POST 요청에 대한 응답입니다.";
    }

    @PutMapping("/test")
    public String putTest() {
        return "안녕하세요? /test PUT 요청에 대한 응답입니다.";
    }

    @DeleteMapping("/test")
    public String deleteTest() {
        return "안녕하세요? /test DELETE 요청에 대한 응답입니다.";
    }
}