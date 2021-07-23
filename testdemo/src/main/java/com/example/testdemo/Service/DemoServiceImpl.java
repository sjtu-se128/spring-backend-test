package com.example.testdemo.Service;

import com.example.testdemo.Dao.DemoDao;
import com.example.testdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("demoService")
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoDao demoDao;

    @Override
    public User getInfo(Integer userid){
        System.out.println("User info validated: userid = "+userid);
        return demoDao.findFirstByUserid(userid);
    }
}
