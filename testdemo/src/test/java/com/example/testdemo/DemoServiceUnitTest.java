package com.example.testdemo;

import com.example.testdemo.Dao.DemoDao;
import com.example.testdemo.Service.DemoService;
import com.example.testdemo.Service.DemoServiceImpl;
import com.example.testdemo.entity.User;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

public class DemoServiceUnitTest {
    // 要mock的对象
    @Mock
    private DemoDao demoDao;

    // 被mock的对象的使用者
    @InjectMocks
    private DemoServiceImpl demoService;


    @Before
    public void setUp() throws Exception{
        // 对所有注解了@Mock的对象进行模拟
        MockitoAnnotations.initMocks(this);
        Mockito.when(demoDao.findFirstByUserid(1)).thenReturn(new User(1, "test1","test"));
        Mockito.when(demoDao.findFirstByUserid(2)).thenReturn(null);

    }

    @Test
    public void testGetValidInfo(){
        User testUser = demoService.getInfo(1);
        // 检查结果
        Assert.assertThat(testUser.getUsername(), Matchers.is("test1"));
        // 验证调用上面的service 方法后是否 demoDao.getInfo(1) 调用过
        Mockito.verify(demoDao).findFirstByUserid(1);
    }

    @Test
    public void testGetInvalidInfo(){
        User testUser = demoService.getInfo(2);
        // 检查结果
        Assert.assertThat(testUser, Matchers.is(Matchers.nullValue()));
        // 验证调用上面的service 方法后是否 demoDao.getInfo(2) 调用过
        Mockito.verify(demoDao).findFirstByUserid(2);
    }
}
