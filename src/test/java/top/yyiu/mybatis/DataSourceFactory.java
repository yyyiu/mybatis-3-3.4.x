package top.yyiu.mybatis;

import org.apache.ibatis.datasource.pooled.PooledDataSource;

import javax.sql.DataSource;

/**
 * 作用于：
 *
 * @author pc
 * @date 2020/5/4
 */
public class DataSourceFactory {

    public static DataSource getDataSource(){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/leyou?useUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "root";
        DataSource dataSource = new PooledDataSource(driver,url,username,password);
        return dataSource;
    }
}
