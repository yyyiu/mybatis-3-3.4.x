package top.yyiu.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.yyiu.mybatis.entity.UserEntity;

import java.util.List;

/**
 * 作用于：
 *
 * @author pc
 * @date 2020/5/4
 */
public interface UserMapper {

    @Select("select count(*) from mybatisuser")
    public int count();

    @Select("select id,username,password from mybatisuser where id=?")
    public List<UserEntity> select(@Param("id") int id);

    public int count1();

    @Select("select id,username,password from mybatisuser where username=#{username}")
    public List<UserEntity> selectByName(@Param("username") String username);


}
