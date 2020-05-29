package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IUserDao;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * +=\|
 *
 * @ClassName UserServiceImpl
 * @Description 这个service是springSecurity框架根据配置会执行这个类的方法
 * @Author jiangtao  zhang
 * @Date 2020/4/24 21:33
 * @Version 1.0
 */

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;
    //这个方法是接口里定义的 形参也是固定的
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo userInfo  = null;
        try {
           userInfo = userDao.findByUserName(username);
            System.out.println(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //User是UserDetails的实现类 UserDetails是个接口, 将我们查出来的用户userInfo信息封装到User类里
//        User user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(), getAuthority(userInfo.getRoles()));
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),
                userInfo.getStatus()== 0?false:true,true,true,true, getAuthority(userInfo.getRoles()));
        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> authoritys = new ArrayList();
        for (Role role: roles) {
            authoritys.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return authoritys;
    }

    @Override
    public List<UserInfo> findAllUser() throws Exception {
        List<UserInfo> allUser = userDao.findAllUser();
        return allUser;
    }

    @Override
    public void saveUser(UserInfo user) throws Exception{
        userDao.saveUser(user);
    }

    @Override
    public UserInfo findUserById(String id) throws Exception {
        UserInfo userById = userDao.findUserById(id);
        return userById;
    }

    @Override
    public List<Role> findOtherRole(String id) throws Exception {
        List<Role> otherRole = userDao.findOtherRole(id);
        return  otherRole;
    }

    @Override
    public void addRoleToUser(String userId, String[] ids) throws Exception {
        for (String id:ids) {
            userDao.addRoleToUser(userId,id);
        }
    }
}
