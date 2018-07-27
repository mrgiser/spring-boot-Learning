package cn.he.zhao.spring;

import cn.he.zhao.spring.service.ListenerTestService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 描述:
 * listenerTest
 *
 * @Author HeFeng
 * @Create 2018-07-27 16:52
 */
public class listenerTest  {

    @Autowired
    @Qualifier(value = "listenerService")
    private ListenerTestService listenerTestService;

    @Test
    public void testEvent()
    {
        listenerTestService.publish("测试监听");
    }
}