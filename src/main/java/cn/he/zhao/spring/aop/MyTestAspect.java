package cn.he.zhao.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 描述:
 * Aspect
 *
 * @Author HeFeng
 * @Create 2018-07-28 11:58
 */

@Aspect
@Component
public class MyTestAspect {
    final static Logger log = LoggerFactory.getLogger(MyTestAspect.class);

    ThreadLocal<Long> beginTime = new ThreadLocal<>();

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @Pointcut("@annotation(myTestAnnotation )")
    public void serviceStatistics(MyTestAnnotation myTestAnnotation) {
    }

    @Before("serviceStatistics(myTestAnnotation)")
    public void doBefore(JoinPoint joinPoint, MyTestAnnotation myTestAnnotation) {
        // 记录请求到达时间
        beginTime.set(System.currentTimeMillis());
        Object[] obj = joinPoint.getArgs();
        for (Object argItem : obj) {
            System.out.println("---->now-->argItem:" + argItem);
            if (argItem instanceof Map) {
                Map paramVO = (Map) argItem;
                paramVO.put("int", 1234);
            }
            System.out.println("---->after-->argItem:" + argItem);
        }
        log.info("msg:{}", myTestAnnotation.msg());
    }

    @After("serviceStatistics(myTestAnnotation)")
    public void doAfter(JoinPoint joinPoint, MyTestAnnotation myTestAnnotation) {
        Object[] obj = joinPoint.getArgs();
        for (Object argItem : obj) {
            System.out.println("---->now-->argItem:" + argItem);
            if (argItem instanceof Map) {
                Map paramVO = (Map) argItem;
                paramVO.put("str", "55555");
            }
            System.out.println("---->after-->argItem:" + argItem);
        }

        log.info("cy666 statistic time:{}, msg:{}", System.currentTimeMillis() - beginTime.get(), myTestAnnotation.msg());
    }
}