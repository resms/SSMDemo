package com.resms.test.ssm.commono.dao.jdbc;

import com.resms.ssm.auth.bean.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-mybatis.xml","classpath:activemq.xml"})
public class JdbcDaoTest {
    @Autowired
    private NamedParameterJdbcDaoSupport jdbcDao;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Before
    public void setUp(){
        System.out.println("setUp...");
    }
    @After
    public void destroy(){
        System.out.println("destroy...");
    }

    @Test
    public void testQuery(){
        String sql = "select id,user_name,password,age from t_user where id=?";

        BeanPropertyRowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        User user = jdbcTemplate.queryForObject(sql, rowMapper,1);

        System.out.println("id=" + user.getId() + ",name="+user.getUserName() + ",pwd=" + user.getPassword() + ",age=" + user.getAge());
    }

    @Test
    public void testQueryList(){
        queryAll();
    }

    private void queryAll(){
        String sql = "select id,user_name,password,age from t_user";

        BeanPropertyRowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        List<User> users = jdbcTemplate.query(sql, rowMapper);
        for(User user : users) {
            System.out.println("id=" + user.getId() + ",name=" + user.getUserName() + ",pwd=" + user.getPassword() + ",age=" + user.getAge());
        }
    }

    @Test
    public void testQueryObject(){
        String sql = "select count(1) from t_user";
        Integer i = jdbcTemplate.queryForObject(sql,Integer.class);
        System.out.println("rows count=" + i);
        queryAll();
    }

    @Test
    public void testJdbcInsert(){
        System.out.println("......testJdbcInsert");
        String sql = "select count(1) from t_user where id=1";
        int num = jdbcTemplate.queryForObject(sql,Integer.class);
        if (num != 0) {
            System.out.println("exists user by id=1");
            sql = "delete from t_user where id=1";
            jdbcTemplate.execute(sql);
            System.out.println("delete user by id=1");
        }
        sql = "insert into t_user(id,user_name,password,age) values (?,?,?,?)";
        int i = jdbcTemplate.update(sql,new Object[]{1,"sam","123456",35});

        System.out.println("insert row:" + i);
        queryAll();
    }

    @Test
    public void testNamedMapInsert(){
        System.out.println("......testNamedMapInsert");
        String sql = "delete from t_user where id=1";
        jdbcTemplate.execute(sql);

        sql = "insert into t_user(id,user_name,password,age) values (:id,:username,:password,:age)";
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("id",1);
        params.put("username","fan");
        params.put("password","123456");
        params.put("age",30);
        jdbcDao.getNamedParameterJdbcTemplate().update(sql,params);
        queryAll();
    }

    @Test
    public void testNamedBeanInsert(){
        System.out.println("......testNamedBeanInsert");
        String sql = "delete from t_user where id=1";
        jdbcTemplate.execute(sql);
        //此处具名参数名称需与bean的属性相同才能映射。本例：userName
        sql = "insert into t_user(id,user_name,password,age) values (:id,:userName,:password,:age)";
        User u = new User();
        u.setId(1l);
        u.setUserName("fan");
        u.setPassword("123456");
        u.setAge(30);
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(u);
        jdbcDao.getNamedParameterJdbcTemplate().update(sql,sqlParameterSource);
        queryAll();
    }

    /**
     * 主键生成
     */
    @Test
    public void testKeyHolder(){
        System.out.println("......testNamedBeanInsert");
        //此处具名参数名称需与bean的属性相同才能映射。本例：userName
        String sql = "insert into t_user(user_name,password,age) values (:userName,:password,:age)";
        User u = new User();
        u.setUserName("tom");
        u.setPassword("654321");
        u.setAge(60);

        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(u);
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcDao.getNamedParameterJdbcTemplate().update(sql,sqlParameterSource,keyHolder);
        int k = keyHolder.getKey().intValue();
        System.out.println(k);
        queryAll();
    }

    @Test
    public void testUpdate(){
        String sql = "update t_user set user_name=? , password=? where id=?";
        int update = jdbcTemplate.update(sql, new Object[]{"mas","654321",1});
        System.out.println(update);
        queryAll();
    }

    @Test
    public void testBatch(){
        List<Object[]> batchArgs=new ArrayList<Object[]>();
        batchArgs.add(new Object[]{"sam7","123456",35});
        batchArgs.add(new Object[]{"sam8","123456",35});
        batchArgs.add(new Object[]{"sam9","123456",35});
        String sql = "insert into t_user (user_name,password,age) values (?,?,?)";
        jdbcTemplate.batchUpdate(sql, batchArgs);
        queryAll();
    }

    public NamedParameterJdbcDaoSupport getJdbcDao() {
        return jdbcDao;
    }

    public void setJdbcDao(NamedParameterJdbcDaoSupport jdbcDao) {
        this.jdbcDao = jdbcDao;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
