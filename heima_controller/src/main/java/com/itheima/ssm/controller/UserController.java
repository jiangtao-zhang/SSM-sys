package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.PortResolverImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * +=\|
 *
 * @ClassName UserController
 * @Description TODO
 * @Author jiangtao  zhang
 * @Date 2020/4/26 23:14
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    //springSecurity中对密码进行加密，加密后才存入数据库
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping("save.do")
    public String saveUser(UserInfo user) throws Exception {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return "redirect:findAll.do";
    }

    @RequestMapping("findAll.do")
    public ModelAndView findAllUser() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<UserInfo> allUser = userService.findAllUser();
        modelAndView.addObject("userList", allUser);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("findById.do")
    public ModelAndView findUserById(String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = userService.findUserById(id);
        modelAndView.addObject("user", userInfo);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }

    //根据用户Id查询出用户 以及 用户未添加的角色
    @RequestMapping("findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //根据Id查询出用户
        UserInfo user = userService.findUserById(id);
        //根据用户ID查询出 用户未添加的角色
        List<Role> roleList = userService.findOtherRole(id);
        modelAndView.addObject("user", user);
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("user-role-add");
        return  modelAndView;
    }

    //给用户增加角色
    @RequestMapping("addRoleToUser.do")
    public String addRoleToUser(String userId,String [] ids) throws Exception {
        userService.addRoleToUser(userId,ids);
        return  "redirect:findAll.do";
    }
}
