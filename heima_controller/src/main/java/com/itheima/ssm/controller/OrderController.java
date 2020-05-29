package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOrderService;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.List;

/**
 * +=\|
 *
 * @ClassName OrderController
 * @Description TODO
 * @Author jiangtao  zhang
 * @Date 2020/4/23 12:40
 * @Version 1.0
 */
@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private IOrderService iOrderService;

    @RequestMapping("/findAll.do")
    public ModelAndView findall(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page
            ,@RequestParam(name = "size",required = true,defaultValue ="4")Integer size) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Orders> allOrder = iOrderService.findAllOrder(page,size);
        PageInfo pageInfo = new PageInfo(allOrder);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("orders-list");
        return modelAndView;
    }
    @RequestMapping("/findById.do")
    public ModelAndView fingById(String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Orders orders = iOrderService.findById(id);
        modelAndView.addObject("orders", orders);
        modelAndView.setViewName("orders-show");
        return modelAndView;
    }

}
