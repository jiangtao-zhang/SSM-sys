package com.itheima.ssm.service;

import com.itheima.ssm.domain.Orders;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IOrderService {
    List<Orders> findAllOrder(Integer page,Integer size) throws Exception;

    Orders findById(String id)throws  Exception;
}
