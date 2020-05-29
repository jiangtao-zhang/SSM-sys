package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;
/**
 *功能描述+=|\  会员
 * @date 2020/4/24
 * @param null
 * @return
*/
public interface IMemberDao {

    @Select("select * from member where id = #{id}")
    public Member fingById(String id) throws Exception;
}
