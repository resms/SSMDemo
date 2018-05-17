package com.resms.ssm.test.dao;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-mybatis.xml","classpath:activemq.xml" })
public class BaseDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

     @Before
     public void setUp() throws Exception {
          String schameSql = getClass().getResource("/db/h2/schema.sql" ).toURI().toString().substring(6);
          String dataSql = getClass().getResource("/db/h2/data.sql" ).toURI().toString().substring(6);

          DataSource dataSource = (DataSource) applicationContext.getBean("dataSource" );
           // System.out.println(dataSource.getUrl());

          Connection conn = dataSource.getConnection();
          Statement st = conn.createStatement();
//           st.execute( "drop all objects;");// 这一句可以不要
           
           st.execute( "runscript from '" + schameSql + "'" );
           st.execute( "runscript from '" + dataSql + "'" );
           st.close();
           conn.close();
     }
     
     @Test
     public void test_1()
     {
    	 
     }
}
