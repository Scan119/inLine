package codesuda.inLine.controller;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc    //MockMvc 에 대한 Autowired 가능
@SpringBootTest
public class BaseControllerTest1 {

    //@Autowired
    //private MockMvc mvc;
    private final MockMvc mvc;

    public BaseControllerTest1(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[view][GET] 기본 페이지 요청")
    @Test
    void testRootMapping() throws Exception {
    //void testRootMapping(@Autowired MockMvc mvc) throws Exception {
        //given

        //when
        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(content().string(CoreMatchers.containsString("Welcome to codesuda bang")))
                .andExpect(view().name("index"))
                .andDo(print());
        //then
    }

}
