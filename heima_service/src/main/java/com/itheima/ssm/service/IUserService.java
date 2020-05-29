package com.itheima.ssm.service;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    public  List<UserInfo> findAllUser() throws Exception;

    void saveUser(UserInfo user) throws  Exception;

    UserInfo findUserById(String id) throws  Exception;

    List<Role> findOtherRole(String id) throws  Exception;

    void addRoleToUser(String userId, String[] ids) throws  Exception;
}
