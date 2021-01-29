package com.hegong.test;

import com.hegong.dao.AccountDao;
import com.hegong.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author 14767
 */
public class MybatisTest {
    /**
     * 测试查询所有方法
     * @throws Exception
     */
    @Test
    public void run1() throws Exception{
        //加载配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取到代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //查询所有账户信息
        List<Account> list = dao.findAll();
        for (Account account: list ) {
            System.out.println(account);

        }
        //释放资源
        session.close();
        is.close();
    }

    /**
     * 测试保存方法
     * @throws Exception
     */
    @Test
    public void run2() throws Exception{
        Account account = new Account();
        account.setName("lalal");
        account.setMoney(500d);
        //加载配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取到代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //查询所有账户信息
        dao.saveAccount(account);
        //提交事务
        session.commit();
        //释放资源
        session.close();
        is.close();
    }
}
