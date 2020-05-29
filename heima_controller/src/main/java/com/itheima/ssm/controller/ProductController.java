package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * +=\|
 *
 * @ClassName controller
 * @Description TODO
 * @Author jiangtao  zhang
 * @Date 2020/4/22 12:47
 * @Version 1.0
 */
@Controller


@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;



    @RequestMapping("/save.do")
    public String save(Product product)throws Exception{
        productService.save(product);
        return  "redirect:findAll.do";
    }

    @RolesAllowed("ROLE_ADMIN")
    @RequestMapping("/findAll.do")
    public ModelAndView findAllProduct() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> all = productService.findAll();
        modelAndView.addObject("productList", all);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }
}
