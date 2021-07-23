package com.example.testdemo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetInfo(){
        String result = restTemplate.getForObject("/getUserInfo?userid=1", String.class);
        Assert.assertEquals(result,"user1");
        Assert.assertNotEquals(result,"user2");
    }
}
