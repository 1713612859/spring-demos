package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.domain.SysUser;
import org.example.mapper.SysUserMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * 测试连接mybatis
     */
    @Test
    public void testConnectMybatis() throws IOException, SQLException {

        InputStream ios = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ios);

        Connection connection = sqlSessionFactory.getConfiguration().getEnvironment().getDataSource().getConnection();
        System.out.println(connection);

        ResultSet tableTypes = connection.getMetaData().getTableTypes();
        ResultSetMetaData metaData = tableTypes.getMetaData();
        System.out.println("metaData = " + metaData);

        // 底层执行的方法走的是openSession.xxx()
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Object> list = sqlSession.selectList("org.example.mapper.SysUserMapper.selectList");

        // 执行的是此方法
        //        private <E> List<E> selectList(String statement, Object parameter, RowBounds rowBounds, ResultHandler handler) {
        //            try {
        //                MappedStatement ms = configuration.getMappedStatement(statement);
        //                return executor.query(ms, wrapCollection(parameter), rowBounds, handler);
        //            } catch (Exception e) {
        //                throw ExceptionFactory.wrapException("Error querying database.  Cause: " + e, e);
        //            } finally {
        //                ErrorContext.instance().reset();
        //            }
        //        }

        System.out.println("list = " + list.size());

        SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
        List<SysUser> sysUsers = sysUserMapper.selectList();

        System.out.println("sysUsers = " + sysUsers.size());
    }

}
