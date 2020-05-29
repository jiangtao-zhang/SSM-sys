package com.itheima.ssm.utils;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import sun.security.krb5.internal.PAData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * +=\|
 *
 * @ClassName DateUtils
 * @Description TODO
 * @Author jiangtao  zhang
 * @Date 2020/4/22 17:22
 * @Version 1.0
 */
public class DateUtils {

    //日期转换成字符串
    public static String date2string(Date date,String pattern){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String format = simpleDateFormat.format(date);
        return format;
    }
    //字符串转换成日期
    public  static Date string2date(String date,String pattern) throws ParseException {
        SimpleDateFormat simpleFormatter = new SimpleDateFormat(pattern);
        Date parse = simpleFormatter.parse(date);
        return parse;
    }


}
