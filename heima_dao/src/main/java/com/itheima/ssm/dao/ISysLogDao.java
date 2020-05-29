package com.itheima.ssm.dao;

import com.itheima.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * +=\|
 *
 * @ClassName ISysLogDao
 * @Description TODO
 * @Author jiangtao  zhang
 * @Date 2020/5/4 15:08
 * @Version 1.0
 */
public interface ISysLogDao {
    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method) values(#{visitTime}," +
            "#{username},#{ip},#{url},#{executionTime},#{method})")
    public void saveSysLog(SysLog sysLog) throws Exception;

    @Select("select * from syslog")
    public  List<SysLog> findAll() throws Exception;
}
