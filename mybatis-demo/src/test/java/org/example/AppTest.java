package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.domain.SysUser;
import org.example.mapper.SysUserMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
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

    @Test
    public void testSave() throws IOException {
        InputStream ios = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ios);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);

        SysUser user = SysUser.builder().username("张志斌").password("123456").createDate(new Date()).expireDate(new Date()).build();

        boolean res = userMapper.save(user);

        Assert.assertTrue(res);
    }


    @Test
    public void testUpdate() throws IOException {
        InputStream ios = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ios);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);

        SysUser user = SysUser.builder().username("张志斌22").password("12399999456").createDate(new Date()).expireDate(new Date()).userId(6L).build();

        boolean res = userMapper.update(user);

        Assert.assertTrue(res);
    }

    /***
     * 事务：
     *  可重复读：默认数据库就是这样的
     *  脏读： 不做任何操作（但是默认数据库不允许这样做）
     *  读未提交： 锁行记录
     *  串行化：锁表
     * @throws IOException
     */
    @Test
    public void testDelete() throws IOException {
        InputStream ios = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ios);
        // openSession()  openSession(boolean autocommit)
        // 标识事务是否自动提交
        /**
             * private SqlSession openSessionFromDataSource(ExecutorType execType, TransactionIsolationLevel level, boolean autoCommit) {
                     Transaction tx = null;
                     try {
                         final Environment environment = configuration.getEnvironment();  // mybatis-config.xml 中的environment标签
                         final TransactionFactory transactionFactory = getTransactionFactoryFromEnvironment(environment); // environment标签中的事务标签(transactionFactory)
                         // 如果没有事务标签  那么从Java对象是null 标签，但是从数据库层面，默认使用的可重复度事务
                         tx = transactionFactory.newTransaction(environment.getDataSource(), level, autoCommit);
                        // Executor 执行器 SQL执行都是走此
                         final Executor executor = configuration.newExecutor(tx, execType);
                        // 其实就是执行sql——————返回默认会话对象，配置文件，执行器 ，是否自动提交
                         return new DefaultSqlSession(configuration, executor, autoCommit);
                     } catch (Exception e) {
                        // 其实就是rollback
                         closeTransaction(tx); // may have fetched a connection so lets call close()
                         throw ExceptionFactory.wrapException("Error opening session.  Cause: " + e, e);
                     } finally {
                            // 重置会话对象，里面是一个ThreadLocal对象
                         ErrorContext.instance().reset();
                     }
             }

         */
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);

//        SysUser user = SysUser.builder().username("张志斌22").password("12399999456").createDate(new Date()).expireDate(new Date()).userId(6L).build();

        boolean res = userMapper.delete(6L);

        Assert.assertTrue(res);
    }

}
