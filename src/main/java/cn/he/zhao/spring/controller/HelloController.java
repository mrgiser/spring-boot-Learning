package cn.he.zhao.spring.controller;

import cn.he.zhao.spring.service.ListenerTestService;
import cn.he.zhao.spring.util.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public String welcome(final HttpServletRequest request, @RequestParam(value = "test",required = false)String test, Map<String, Object> model) {

        if(test != null && test.equals("1")){
            return "redirect:/hello";
        }
        model.put("message", "hello2");
        model.put("str","str_tmp");
        model.put("int",12);
//        System.out.println(contextPath);

//        String requestUrl = request.getScheme() //当前链接使用的协议
//                +"://" + request.getServerName()//服务器地址
//                + ":" + request.getServerPort() //端口号
//                + request.getContextPath() //应用名称，如果应用名称为
//                + request.getServletPath() //请求的相对url
//                + "?" + request.getQueryString(); //请求参数

        System.out.println(SpringUtil.getServerPath(request));
        System.out.println(SpringUtil.getServerHost(request));

        return "welcome";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.POST)
    public void post(final HttpServletRequest request,  Map<String, Object> model) {


        model.put("message", "hello2");
        model.put("str","str_tmp");
        model.put("int",12);
        model.put("sc", true);

        System.out.println(SpringUtil.getServerPath(request));
        System.out.println(SpringUtil.getServerHost(request));

    }

    @RequestMapping("/sendError")
    public String sendError(final HttpServletResponse response) throws Exception {

        response.sendError(403);

        return null;
    }
}