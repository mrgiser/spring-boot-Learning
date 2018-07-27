package cn.he.zhao.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * 描述:
 * MyEvent
 *
 * @Author HeFeng
 * @Create 2018-07-27 16:45
 */
public class MyEvent extends ApplicationEvent {

    private String msg;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MyEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    /**
     * 自定义监听器触发的透传打印方法
     * @param msg
     */
    public void printMsg(String msg)
    {
        System.out.println("编程事件监听:" + msg);
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}