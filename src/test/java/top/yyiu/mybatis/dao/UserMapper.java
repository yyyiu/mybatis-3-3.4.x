package top.yyiu.mybatis.dao;

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

    @Select("select count(*) from tb_user")
    public int count();

    @Select("select id,username,password from tb_user")
    public List<UserEntity> select();

}