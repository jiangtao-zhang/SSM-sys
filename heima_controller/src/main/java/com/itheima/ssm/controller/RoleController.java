package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IRoleService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * +=\|
 *
 * @ClassName RoleController
 * @Description TODO
 * @Author jiangtao  zhang
 * @Date 2020/4/30 21:08
 * @Version 1.0
 */

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleAll = roleService.findAll();
        modelAndView.addObject("roleList", roleAll);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping("/save.do")
    public String saveRole(Role role) throws Exception{
        roleService.save(role);
        return "redirect:findAll.do";
    }

    //通过role的id 查询出角色信息 以及 这个角色还可以添加的权限
    @RequestMapping("findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id",required = true) String roleId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //通过roleId查询出这个角色信息
        Role role = roleService.findRoleById(roleId);
        //通过roleId查询出 这个角色还能添加的权限
        List<Permission> otherPermission = roleService.findOtherPermission(roleId);
        modelAndView.addObject("role", role);
        modelAndView.addObject("permissionList", otherPermission);
        modelAndView.setViewName("role-permission-add");
        return modelAndView;
    }
    @RequestMapping("addPermissionToRole")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true)String roleId,
                                      @RequestParam(name = "ids",required = true)String []permissionIds){
        roleService.addPermissionToRole(roleId,permissionIds);
        return "redirect:findAll.do";
    }
}
