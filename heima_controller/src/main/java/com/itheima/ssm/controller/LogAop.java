package com.itheima.ssm.controller;

import com.itheima.ssm.domain.SysLog;
import com.itheima.ssm.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * +=\|
 *
 * @ClassName LogAop
 * @Description TODO 日志类也就是 切面类,进行前置通知和后置通知的操作，这个类中会把SysLog封装好
 *@Author jiangtao  zhang
 * @Date 2020/5/2 14:58
 * @Version 1.0
 */
@Component
@Aspect
public class LogAop {

    private Date startTime; // 访问时间
    private Class executionClass;// 访问的类
    private Method executionMethod; // 访问的方法
    // 主要获取访问时间、访问的类、访问的方法

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ISysLogService sysLogService;
    @Before("execution( * com.itheima.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        //访问的开始时间
        startTime = new Date();
        //目标对象的类
        executionClass = jp.getTarget().getClass();
        //3目标对象访问的方法
        //3.1获取方法的名称
        String methodName = jp.getSignature().getName();
        //3.2获取方法的参数
        Object[] args = jp.getArgs();
        if (args == null || args.length == 0  ){
            //方法无参函数  得到方法对象
            executionMethod = executionClass.getMethod(methodName);
        }
        else {
            // 有参数，就将args中所有元素遍历，获取对应的Class,装入到一个Class[]
            Class[] classArgs = new Class[args.length];

            for (int i = 0; i <args.length ; i++) {
                classArgs[i]=args[i].getClass();
            }
            //方法有参函数 得到方法对象
            executionMethod = executionClass.getMethod(methodName, classArgs);
        }

    }


    @After("execution( * com.itheima.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint jp) throws Exception {

        //获取访问时长
        Long executionTime = new Date().getTime() - startTime.getTime();

        //当前执行的类executionClass != SysLogController.class  目的是 如果你查看日志，那你查看的这条路径不用保存到数据库
        if (executionClass != null && executionMethod != null && executionClass != SysLogController.class){
            if (executionClass != null ){
                String url = "";
                //获取类上的RequestMapping的注解对象
                RequestMapping classAnnotation = (RequestMapping) executionClass.getAnnotation(RequestMapping.class);
                //获取类注解对象的value属性组
                String[] classValue = classAnnotation.value();
                if (executionMethod != null){
                    //获取 方法上的RequestMapping的注解对象
                    RequestMapping methodAnnotation = executionMethod.getAnnotation(RequestMapping.class);
                    //获取 方法注解对象的value 属性组
                    String[] methodValue = methodAnnotation.value();

                    //整合类上的value和方法的value ,加起来就是最终的路径
                    url = classValue[0] + methodValue[0];

                    //获取IP
                    String ip = request.getRemoteAddr();
                    //获取操作对象
                    SecurityContext context = SecurityContextHolder.getContext();
                    //1.1这里得到的是Security里面的user 而不是我们自己定义的
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();

                    //将日志相关信息封装到SysLog对象中
                    SysLog sysLog = new SysLog();

                    sysLog.setIp(ip);
                    sysLog.setUrl(url);
                    sysLog.setVisitTime(startTime);
                    sysLog.setExecutionTime(executionTime);
                    sysLog.setUsername(username);
                    sysLog.setMethod("[类名]" + executionClass.getName() + "[方法名]" + executionMethod.getName());
                    // 调用Service，调用dao将sysLog insert数据库
                    sysLogService.save(sysLog);


                }
            }
        }

    }

}
