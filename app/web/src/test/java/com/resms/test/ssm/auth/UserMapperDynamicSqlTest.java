package com.resms.test.ssm.auth;

import com.resms.ssm.meta.mybatis.domain.User;
import com.resms.ssm.meta.mybatis.mapper.UserDynamicSqlSupport;
import com.resms.ssm.meta.mybatis.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.where.condition.IsGreaterThan;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

/**
 * @author sam <sam@resms.net>
 * @version 1.0.0.0
 * @ClassName UserMapperDynamicSqlTest
 * @Description TODO
 * @date 2020/2/18 20:20
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-testds-dynamicSql.xml"})
public class UserMapperDynamicSqlTest {
    @Inject
    UserMapper userMapper;

    @Inject
    SqlSessionFactory sqlSessionFactory;

//    @BeforeClass
//    public static void setUp(){
//        System.out.println("before class ...");
//    }
//
//    @AfterClass
//    public static void destroy(){
//        System.out.println("after class ...");
//    }

    @Before
    public void init(){
        System.out.println("init ...");
    }

    @After
    public void dispose(){
        System.out.println("dispose ...");
    }

    @Test
    public void selectByPrimaryKey()
    {
        Optional<User> user = userMapper.selectByPrimaryKey(1l);

        assertEquals("测试",user.get().getUserName());
    }

    @Test
    public void testSelectByExample() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);

            SelectStatementProvider selectStatement = select(UserDynamicSqlSupport.id.as("A_ID"), UserDynamicSqlSupport.userName, UserDynamicSqlSupport.age)
                    .from(UserDynamicSqlSupport.user)
                    .where(UserDynamicSqlSupport.id, isEqualTo(1l))
                    .or(UserDynamicSqlSupport.userName, isNotNull())
                    .build()
                    .render(RenderingStrategies.MYBATIS3);

            List<User> rows = mapper.selectMany(selectStatement);

            assertEquals(3,rows.size());
        }
    }

    @Test
    public void simpleWhere(){
        SelectStatementProvider selectStatement = select(count())
                .from(UserDynamicSqlSupport.user)
//                .where(UserDynamicSqlSupport.userName, isLike("sam%"))
//                .where(UserDynamicSqlSupport.id, isBetween(3l).and(6l))
//                .where(UserDynamicSqlSupport.id, isIn(3l,4l,5l))
//                .where(UserDynamicSqlSupport.id, isNotNull())
                .where(UserDynamicSqlSupport.id, isEqualTo(3l))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        long result = userMapper.count(selectStatement);
        assertEquals(1l,result);
    }

    @Test
    public void complexWhere(){
        SelectStatementProvider selectStatement = select(count())
                .from(UserDynamicSqlSupport.user,"o")
                .where(UserDynamicSqlSupport.id, isGreaterThan(2l))
                .and(UserDynamicSqlSupport.userName, isNotNull(), and(UserDynamicSqlSupport.id, isLessThan(6l)))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        long result = userMapper.count(selectStatement);
        assertEquals(3l,result);
    }

    @Test
    public void subqueries(){
//        SelectStatementProvider selectStatement = select(UserDynamicSqlSupport.id.as("A_ID"), UserDynamicSqlSupport.userName)
//                .from(UserDynamicSqlSupport.user, "u")
//                .where(UserDynamicSqlSupport.id, isIn(select().from(table).where(column2, isEqualTo(3))))
//                .or(column1, isLessThan(d))
//                .build()
//                .render(RenderingStrategies.MYBATIS3);
    }

    @Test
    @Rollback
    public void updateByPrimaryKey(){
        User user = new User();
        user.setId(8l);
        user.setUserName("jack");
        user.setPassword("000000");
        user.setAge(100);

        int result = userMapper.updateByPrimaryKey(user);
        assertEquals(1,result);
    }

    @Test
    @Rollback
    public void updateByExampleSelective(){
        User user = new User();
        user.setAge(88);

        //update t_user set age=88 where id > 5 and (username like '%tom%' or age=18)
        UpdateStatementProvider updateStatement = update(UserDynamicSqlSupport.user)
                .set(UserDynamicSqlSupport.age).equalTo(88)
                .where(UserDynamicSqlSupport.id, isGreaterThan(2l))
                .and(UserDynamicSqlSupport.userName, isNotNull(), and(UserDynamicSqlSupport.id, isLessThan(6l)))
                .build()
                .render(RenderingStrategies.MYBATIS3);

        int result = userMapper.update(updateStatement);
        assertEquals(4,result);
    }
}
