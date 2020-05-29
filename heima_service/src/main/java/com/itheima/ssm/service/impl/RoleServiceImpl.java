package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IRoleDao;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * +=\|
 *
 * @ClassName RoleServiceImpl
 * @Description TODO
 * @Author jiangtao  zhang
 * @Date 2020/4/30 21:11
 * @Version 1.0
 */
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    public List<Role> findAll() throws Exception {
        List<Role> roleAll = roleDao.findAll();
        return roleAll;
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    @Override
    public Role findRoleById(String roleId) throws Exception {
        Role role = roleDao.findRoleById(roleId);
        return role;
    }

    @Override
    public List<Permission> findOtherPermission(String roleId) throws Exception {
        List<Permission> otherPermission = roleDao.findOtherPermission(roleId);
        return otherPermission;
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) {
        for (String permissionId:permissionIds){
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }
}
