package com.itheima.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * +=\|
 *
 * @ClassName encode
 * @Description TODO
 * @Author jiangtao  zhang
 * @Date 2020/4/30 13:53
 * @Version 1.0
 */
public class encode {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123");
        System.out.println(encode);

    }
}
