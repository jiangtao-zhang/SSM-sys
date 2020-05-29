package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;
/**
 *功能描述+=|\ RoleDao底层
 * @date 2020/4/26
 * @param null
 * @return
*/
public interface IRoleDao {

    //根据用户id查询出所有对应的角色
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="roleName",property="roleName"),
            @Result(column="roleDesc",property="roleDesc"),
            @Result(column="id",property="permissions",javaType=java.util.List.class,many=@Many(select="com" +
                    ".itheima.ssm.dao.IPermissionDao.findByRoleId"))
    })
    public List<Role> findRoleByUserId(String userId) throws Exception;

    @Select("select * from role")
    public List<Role> findAll() throws Exception;

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    public  void save(Role role) throws  Exception;

    @Select("select * from role where id = #{roleId} ")
    public Role findRoleById(String roleId) throws Exception;

    @Select("select * from permission where id not in (select permissionId from role_permission where " +
            "roleId=#{roleId})")
    public List<Permission> findOtherPermission(String roleId) throws Exception;

    @Insert("insert into role_permission (roleId,permissionId) values (#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId,@Param("permissionId") String permissionId);
}
