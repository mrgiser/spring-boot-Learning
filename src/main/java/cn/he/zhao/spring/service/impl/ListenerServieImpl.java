package cn.he.zhao.spring.service.impl;

import cn.he.zhao.spring.event.MyEvent;
import cn.he.zhao.spring.service.ListenerTestService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 描述:
 * ListenerServieImpl
 *
 * @Author HeFeng
 * @Create 2018-07-27 16:49
 */
@Service("listenerService")
public class ListenerServieImpl implements ListenerTestService {

    @Resource
    private ApplicationContext applicationContext;

    @Override
    public String publish(String msg) {
        //通过上下文对象发布监听
        applicationContext.publishEvent(new MyEvent(this,msg));
        System.out.println(msg);
        return msg;
    }
}