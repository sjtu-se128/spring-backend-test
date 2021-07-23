package com.example.testdemo;

import com.example.testdemo.Dao.DemoDao;
import com.example.testdemo.entity.User;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
// Use your own database with this annotation
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DemoDaoUnitTest {
    @Autowired
    private DemoDao demoDao;

    @Test
    public void testSave(){
        User user = new User(2,"user2","111111");
        Assert.assertThat(user.getUsername(), Matchers.is(demoDao.save(user).getUsername()));
    }

}
