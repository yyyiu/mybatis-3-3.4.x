package top.yyiu.mybatis;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.*;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Test;
import top.yyiu.mybatis.dao.UserMapper;
import top.yyiu.mybatis.plugin.InterceptionPlug;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * 作用于：
 *
 * @author pc
 * @date 2020/5/4
 */
public class TestMybatis {


    /**
     * 使用java配置，不用xml文件
     * @return sqlSessionFactory
     */
    public static SqlSessionFactory initJava() {
        LogFactory.useLog4JLogging();
        DataSource dataSource = DataSourceFactory.getDataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        // configuration.addInterceptor(new InterceptionPlug());// 添加拦截器
        configuration.addMapper(UserMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        return sqlSessionFactory;
    }

    /**
     * 使用xml文件进行配置
     * @return sqlSessionFactory
     * @throws IOException
     */
    public static SqlSessionFactory initXml() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }


    @Test
    public void fun() {
        // SqlSession 是通过 JDK 动态代理的方式为接口生成代理对象的
        SqlSessionFactory sqlSessionFactory = initXml();
        // mybatis的一级缓存是sqlSession级别的缓存，在BaseExecutor中使用PerpetualCache来实现
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.select();
        System.out.println(userMapper.count());
        userMapper.select();
    }

    public void testExecutor(){
        try {
            SqlSessionFactory sqlSessionFactory = initXml();
            SqlSession session = sqlSessionFactory.openSession();
            Configuration configuration = sqlSessionFactory.getConfiguration();
            Executor executor = configuration.newExecutor(new JdbcTransaction(session.getConnection()), ExecutorType.SIMPLE);
            MappedStatement listAllStms = configuration.getMappedStatement("这个是mapper中的查询id，写全路径名称");
            List<Object> list = executor.query(listAllStms, null, RowBounds.DEFAULT, Executor.NO_RESULT_HANDLER);//直接操作数据库
            System.out.println(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
