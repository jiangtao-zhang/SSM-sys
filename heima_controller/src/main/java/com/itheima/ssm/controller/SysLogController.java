package com.itheima.ssm.controller;

import com.itheima.ssm.domain.SysLog;
import com.itheima.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * +=\|
 *
 * @ClassName SysLogController
 * @Description TODO
 * @Author jiangtao  zhang
 * @Date 2020/5/3 16:46
 * @Version 1.0
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogController {
    @Autowired
    private ISysLogService sysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAllSysLog() throws Exception {
        List<SysLog> allSysLog = sysLogService.findAllSysLog();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("sysLogs", allSysLog);
        modelAndView.setViewName("syslog-list");
        return modelAndView;
    }
}
