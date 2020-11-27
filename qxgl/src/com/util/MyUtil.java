package com.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyUtil {
    private static SqlSession sqlSession;

    static {
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        InputStream inputStream=Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.xml");
        SqlSessionFactory factory=builder.build(inputStream);
        SqlSession sqlSession1=factory.openSession(true);
        sqlSession=sqlSession1;
    }

    public static SqlSession getSqlSession(){
        return sqlSession;
    }
}
