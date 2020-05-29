package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.ISysLogDao;
import com.itheima.ssm.domain.SysLog;
import com.itheima.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * +=\|
 *
 * @ClassName SysLogServiceImpl
 * @Description TODO
 * @Author jiangtao  zhang
 * @Date 2020/5/4 15:08
 * @Version 1.0
 */
@Service
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;
    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.saveSysLog(sysLog);
    }

    @Override
    public List<SysLog> findAllSysLog() throws Exception {
        List<SysLog> SysLogAll = sysLogDao.findAll();
        return SysLogAll;
    }


}
