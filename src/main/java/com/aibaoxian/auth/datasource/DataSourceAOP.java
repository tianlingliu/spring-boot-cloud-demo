package com.aibaoxian.auth.datasource;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * 切面拦截请求执行的方法，动态切换线程需要的上下文依赖数据源
 */
@Aspect
@Component
public class  DataSourceAOP {

    @Pointcut("!@annotation(com.aibaoxian.auth.datasource.Master) " +
            "&& (execution(* com.aibaoxian..*.mapper.*.select*(..)) " +
            "|| execution(* com.aibaoxian..*.mapper..*.get*(..)))")
    public void readPointcut() {
    }

    @Pointcut("@annotation(com.aibaoxian.auth.datasource.Master) " +
            "|| execution(* com.aibaoxian..*.mapper..*.insert*(..)) " +
            "|| execution(* com.aibaoxian..*.mapper..*.add*(..)) " +
            "|| execution(* com.aibaoxian..*.mapper..*.update*(..)) " +
            "|| execution(* com.aibaoxian..*.mapper..*.edit*(..)) " +
            "|| execution(* com.aibaoxian..*.mapper..*.delete*(..)) " +
            "|| execution(* com.aibaoxian..*.mapper..*.remove*(..))")
    public void writePointcut() {
    }

    @Before("readPointcut()")
    public void read() {
        DatabaseContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DatabaseContextHolder.master();
    }


    /**
     * 另一种写法：if...else...  判断哪些需要读从数据库，其余的走主数据库
     */
//    @Before("execution(* com.aibaoxian.auth.service.impl.*.*(..))")
//    public void before(JoinPoint jp) {
//        String methodName = jp.getSignature().getName();
//
//        if (StringUtils.startsWithAny(methodName, "get", "select", "find")) {
//            DatabaseContextHolder.slave();
//        }else {
//            DatabaseContextHolder.master();
//        }
//    }
}
