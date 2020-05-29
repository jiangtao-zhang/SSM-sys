package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * +=\|
 *
 * @ClassName PermissionController
 * @Description TODO 权限控制器
 * @Author jiangtao  zhang
 * @Date 2020/5/1 12:35
 * @Version 1.0
 */
@Controller
@RequestMapping("permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;
    @RequestMapping("findAll.do")
    public ModelAndView findAllPermission() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Permission> all = permissionService.findAll();
        modelAndView.addObject("permissionList", all);
        modelAndView.setViewName("permission-list");
        return  modelAndView;
    }

    @RequestMapping("save.do")
    public String savePermission(Permission permission) throws Exception {
        permissionService.save(permission);
        return "redirect:findAll.do";
    }
}

