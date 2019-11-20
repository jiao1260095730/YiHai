package com.bin.yihai.provider.user.dao;

import com.bin.yihai.entity.user.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
    //新增
    @Insert("insert into t_user(phone, password) values(#{phone}, #{password})")
    int insert(User user);
    //查询
    @Select("select * from t_user where phone = #{name} or email =#{email}")
    User selectByName(String name);
}
