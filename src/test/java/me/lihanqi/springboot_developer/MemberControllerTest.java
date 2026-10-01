package me.lihanqi.springboot_developer;

import me.lihanqi.Member;
import me.lihanqi.MemberRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MockMvc mockMvc;          // ← 这里加上 @Autowired

    @Test
    void getAllMembers() throws Exception {

        // 준비 (given)
        // 회원 등록
        memberRepository.deleteAll();

        Member m = new Member("SCPARK");
        Member savedMember = memberRepository.save(m);

        // 실행 (when)
        final ResultActions result = mockMvc.perform(
                get("/member")
                        .accept(MediaType.APPLICATION_JSON)
        );

        // 검증 (then)
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value(savedMember.getName()));
    }
}