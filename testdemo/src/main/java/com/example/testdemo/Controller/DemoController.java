package com.example.testdemo.Controller;

import com.example.testdemo.Service.DemoService;
import com.example.testdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/getUserInfo")
    public String getUserName(Integer userid) {
        User temp = demoService.getInfo(userid);
        System.out.println(temp);
        return temp.getUsername();
    }
}
