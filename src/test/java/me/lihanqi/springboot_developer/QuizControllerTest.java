package me.lihanqi.springboot_developer;

import org.aspectj.apache.bcel.classfile.Code;
import tools.jackson.databind.json.JsonMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class QuizControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JsonMapper objectMapper;

    @DisplayName("quiz(): GET /quiz?code=1 -> 응답 코드는 201, 응답 본문은 Created")
    @Test
    void getQuiz1() throws Exception {
        // 준비 given
        final String url = "/quiz";

        // 실행 when
        final ResultActions result =
                mockMvc.perform(get(url).param("code", "1"));

        // 검증 then
        result.andExpect(status().isCreated())
                .andExpect(content().string("Created"));
    }

    @DisplayName("POST: /quiz 요청, 요청 바디에 {value:1}이면 응답 코드는 403, 응답 본문은 Forbidden")
    @Test
    void postQuiz1() throws Exception {
        // 준비 given
        final String url = "/quiz";

        // 실행 when
        final ResultActions result = mockMvc.perform(post(url).param("code","1"));

        // 검증 then
        result.andExpect(status().isForbidden()).andExpect(content().string("Created"));
    }

    @DisplayName("POST: /quiz 요청, 요청 바디에 {'value':2}이면 응답 코드는 200, 응답 본문은 OK!")
    @Test
    void postQuiz2() throws Exception{

    }
}