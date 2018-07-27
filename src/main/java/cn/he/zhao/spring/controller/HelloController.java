package cn.he.zhao.spring.controller;

import cn.he.zhao.spring.service.ListenerTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 描述:
 * 测试控制器
 *
 * @Author HeFeng
 * @Create 2018-05-26 16:18
 */

@Controller
public class HelloController {

    @Autowired
    @Qualifier(value = "listenerService")
    private ListenerTestService listenerTestService;

    @RequestMapping("/")
    @ResponseBody
    String index() {
        String str = listenerTestService.publish("测试监听");
        return str;
    }

    @GetMapping("/login")
    public String hello(Map<String, Object> map) {
        map.put("message", "hello");
        return "/verify/login.ftl";
    }

    @RequestMapping("/hello2")
    public String welcome(Map<String, Object> model) {
        model.put("message", "hello2");
        return "welcome";
    }
}