package cn.he.zhao.spring.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述:
 * SpringUtil
 *
 * @Author HeFeng
 * @Create 2018-08-05 15:12
 */
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(SpringUtil.applicationContext == null) {
            SpringUtil.applicationContext = applicationContext;
        }
    }

    //获取applicationContext
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    //通过name获取 Bean.
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }

    //通过class获取Bean.
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    //通过name,以及Clazz返回指定的Bean
    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name, clazz);
    }

    public static String getServerPath(final HttpServletRequest request){
        String serverPath = request.getScheme() //当前链接使用的协议
                +"://" + request.getServerName()//服务器地址
                + ":" + request.getServerPort() //端口号
                + request.getContextPath(); //应用名称，如果应用名称为
        return serverPath;
    }

    public static String getServerHost(final HttpServletRequest request){
        String serverHost = request.getServerName(); //服务器地址

        return serverHost;
    }
}