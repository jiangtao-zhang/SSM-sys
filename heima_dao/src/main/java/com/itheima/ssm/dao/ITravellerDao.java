package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;
/**
 *功能描述+=|\
 * @date 2020/4/24
 * @param null
 * @return
*/
import java.util.List;

public interface ITravellerDao {

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId " +
            "=#{id})")
    public List<Traveller> findTravellerByOrdersId(String id) throws Exception;
}
