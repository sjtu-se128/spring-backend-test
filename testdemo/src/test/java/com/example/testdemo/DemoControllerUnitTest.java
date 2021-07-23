package com.example.testdemo;


import com.example.testdemo.Controller.DemoController;
import com.example.testdemo.Service.DemoService;
import com.example.testdemo.entity.User;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(DemoController.class)
public class DemoControllerUnitTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private DemoService demoService;

    @Test
    public void testGetInfo() throws Exception{
        // Define what you expect the mock to return
        given(this.demoService.getInfo(1)).willReturn(new User(1,"user1","123123"));

        // Run test
        mvc.perform(MockMvcRequestBuilders.get("/getUserInfo?userid=1"))
                .andExpect(status().isOk()).andExpect(content().string("user1"));
    }
}
