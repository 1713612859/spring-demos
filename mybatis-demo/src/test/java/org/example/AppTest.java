package org.example;

import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * 测试连接mybatis
     */
    @Test
    public void testConnectMybatis() {
        try {
            InputStream ios = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(ios);

            String s = ErrorContext.instance().toString();
            System.out.println("s = " + s);

//            SqlSession sqlSession = build.openSession();
//            System.out.println("sqlSession = " + sqlSession);

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
