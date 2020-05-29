package com.itheima.ssm.service.impl;


import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.IOrdersDao;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * +=\|
 *
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author jiangtao  zhang
 * @Date 2020/4/23 12:41
 * @Version 1.0
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrdersDao iOrderDao;

    @Override
    public List<Orders> findAllOrder(Integer page, Integer size) throws Exception {
        PageHelper.startPage(page,size);
        List<Orders> allOrder = iOrderDao.findAll();
        return allOrder;
    }

    @Override
    public Orders findById(String id) throws Exception {
        Orders orders = iOrderDao.findById(id);
        return orders;
    }
}
