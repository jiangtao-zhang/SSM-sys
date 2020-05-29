package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
/**
 *功能描述+=|\ 产品底层操作
 * @date 2020/4/23
 * @param null
 * @return
*/
import java.util.List;

public interface IProductDao {

    //根据id查询产品
    @Select("select * from product where id=#{id}")
    public  Product findById(String id)throws Exception;
    //查询所有产品信息
    @Select("select * from product")
    public List<Product> findAllProduct() throws Exception;

    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);


}
