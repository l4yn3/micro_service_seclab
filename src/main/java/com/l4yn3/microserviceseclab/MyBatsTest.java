package com.l4yn3.microserviceseclab;

import com.l4yn3.microserviceseclab.data.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatsTest {

    public static void main(String[] args) throws IOException {
        String resources = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            Student user = sqlSession.selectOne("MyMapper.selectUser", 1);
            System.out.println(user);
        }
        finally {

        }
    }

}
