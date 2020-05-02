import cn.oyzc.dao.AccountDao;
import cn.oyzc.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    /**
     * 测试查询
     * @throws IOException
     */
    @Test
    public void run1() throws IOException {
        //加载配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //创建SqlSession对象
        SqlSession session = sessionFactory.openSession();
        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //查询所有数据
        List<Account> list = dao.findAll();
        for(Account account : list){
            System.out.println(account);
        }
        //关闭资源
        session.close();
        resourceAsStream.close();
    }

    /**
     * 测试保存
     * @throws IOException
     */
    @Test
    public void run2() throws IOException {
        Account account = new Account();
        account.setName("李四");
        account.setMoney(200.00);
        //加载配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //创建SqlSession对象
        SqlSession session = sessionFactory.openSession();
        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //添加数据
        dao.saveAccount(account);
        //提交事务
        session.commit();
        //关闭资源
        session.close();
        resourceAsStream.close();
    }
}