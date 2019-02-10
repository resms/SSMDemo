package com.resms.test.ssm.commono.dao.jdbc;

import com.resms.ssm.common.dao.jdbc.impl.JdbcBaseDaoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-mybatis.xml","classpath:activemq.xml"})
public class JdbcBaseDaoTest {
    public class User{};
    public interface UserJdbcDao<User>{}
    public class UserJdbcDaoImpl<User> extends JdbcBaseDaoImpl<User> implements UserJdbcDao{};
    @Test
    public void testGenericTypeName(){
        UserJdbcDao<User> dao = new UserJdbcDaoImpl<User>();

        System.out.println((((UserJdbcDaoImpl) dao).getEntityName()));
    }



}
