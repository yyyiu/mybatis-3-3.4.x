package top.yyiu.mybatis;

import org.apache.ibatis.datasource.pooled.PooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 作用于：
 *
 * @author pc
 * @date 2020/5/4
 */
public class DataSourceFactory {

    final static String DRIVER = "com.mysql.jdbc.Driver";
    final static String URL = "jdbc:mysql://localhost:3306/leyou?useUnicode=true&characterEncoding=utf8";
    final static String USERNAME = "root";
    final static String PASSWORD = "root";

    public static DataSource getDataSource() {
        DataSource dataSource = new PooledDataSource(DRIVER, URL, USERNAME, PASSWORD);
        return dataSource;
    }

    public static void jdbc() {
        String sql = "select id,username,password from mybatisuser";
        try {
            Class.forName(DRIVER);// 执行这里，Driver的实现类会向DriverManager中注册自己
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
            }
            resultSet.close();
            pstm.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
