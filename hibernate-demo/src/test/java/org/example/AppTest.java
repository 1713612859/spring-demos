package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.io.Serializable;
import java.util.Date;

/**
 * Unit test for simple App.
 */
@Slf4j
public class AppTest {

        /**
         * 查询数据库数据
         */
        @Test
        public void testQuery() {
                //Hibernate 加载核心配置文件（有数据库连接信息）
                Configuration configuration = new Configuration().configure();
                //创建一个 SessionFactory 用来获取 Session 连接对象
                SessionFactory sessionFactory = configuration.buildSessionFactory();
                //获取session 连接对象
                Session session = sessionFactory.openSession();
                //开始事务
                Transaction transaction = session.beginTransaction();
                //根据主键查询 user 表中的记录
                Users user = session.get(Users.class, 4);
                log.info("user is  {} ", user);
                //提交事务
                transaction.commit();
                //释放资源
                session.close();
                sessionFactory.close();

        }

        /**
         * 保存数据
         */
        @Test
        public void testInsert() {
                //加载 Hibernate 核心配置文件
                Configuration configuration = new Configuration().configure();
                //创建一个 SessionFactory 用来获取 Session 连接对象
                SessionFactory sessionFactory = configuration.buildSessionFactory();
                //获取session 连接对象
                Session session = sessionFactory.openSession();
                //开始事务
                Transaction transaction = session.beginTransaction();
                //创建实体类对象
                Users user = new Users();
                user.setAge(18);
                user.setUsername("编程帮新增用户");
                user.setFullName("编程帮新增用户111");
                user.setAvatar("编程帮新增用户/ax.jpg");
                user.setCreateTime(new Date());
                user.setPassword("654321");
                user.setEmail("14234567@qq.com");
                //向 user 表中插入数据,返回值为新增数据的主键 id
                Serializable save = session.save(user);
                log.info("新增数据的主键 id {} :"+save);
                //提交事务
                transaction.commit();
                //释放资源
                session.close();
                sessionFactory.close();
        }
}
