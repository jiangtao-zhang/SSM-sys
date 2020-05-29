package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *功能描述+=|\   users的底层操作
 * @date 2020/4/24
 * @param null
 * @return
*/
public interface IUserDao {
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select =
                    "com.itheima.ssm.dao.IRoleDao.findRoleByUserId"))
    })
    public UserInfo findByUserName(String username) throws Exception;

    @Select("select * from users")
    public List<UserInfo> findAllUser() throws Exception;

    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username}," +
            "#{password},#{phoneNum},#{status})")
    public void saveUser(UserInfo user);

    @Select("select * from users where id = #{id} ")
    @Results({ @Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = List.class, many =
            @Many(select = "com.itheima.ssm.dao.IRoleDao.findRoleByUserId")) })
    public UserInfo findUserById(String id);

    @Select("select * from role where id not in(select roleId from users_role where userId  = #{id})")
    public List<Role> findOtherRole(String id);

    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    public void addRoleToUser(@Param("userId") String userId,@Param("roleId") String roleId) throws  Exception;
}
