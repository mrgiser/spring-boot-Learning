package cn.he.zhao.spring.event.listener;

import cn.he.zhao.spring.event.MyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 描述:
 * MyLisenter
 *
 * @Author HeFeng
 * @Create 2018-07-27 16:46
 */

@Component
public class MyLisenter implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event) {
        /*
          这里不做处理，只对消息进行透传打印，实际情况，
          可以根据项目进行逻辑进行处理
         */
        event.printMsg(event.getMsg());
    }
}