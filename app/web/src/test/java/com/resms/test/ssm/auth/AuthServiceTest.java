package com.resms.test.ssm.auth;

import com.resms.ssm.auth.service.UserService;
import com.resms.ssm.gen.mybatis.bean.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-ds.xml","classpath:activemq.xml"})
public class AuthServiceTest {

    @Autowired
    protected UserService userService;


    @Before
    public void setUp(){
        System.out.println("init...");
    }
    @After
    public void destroy(){
        System.out.println("destroy...");
    }

    @Test
    public void testSave(){
        User u = userService.getUserById(1l);
        if (null != u)
        {
            userService.delete(1l);

        }

        u = new User();
        u.setId(1l);
        u.setAge(34);
        u.setUserName("sam");
        u.setPassword("123456");

        int i = 0;
        try {
            i = userService.save(u);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("",1,i);
    }
}
