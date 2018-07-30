package cn.he.zhao.spring.controller;

import cn.he.zhao.spring.service.ListenerTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 描述: hello World
 * 控制器
 *
 * @Author HeFeng
 * @Create 2018-05-26 16:18
 */

@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    String index() {
        return "hello world";
    }

    @GetMapping("/login")
    public String hello(Map<String, Object> map) {
        map.put("message", "hello");
        return "/verify/login.ftl";
    }

    @RequestMapping("/hello2")
    public String welcome(Map<String, Object> model) {
        model.put("message", "hello2");
        model.put("str","str_tmp");
        model.put("int",12);
        return "welcome";
    }
}