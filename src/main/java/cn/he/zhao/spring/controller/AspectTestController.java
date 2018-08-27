package cn.he.zhao.spring.controller;

import cn.he.zhao.spring.aop.MyTestAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 描述:
 * aspect
 *
 * @Author HeFeng
 * @Create 2018-07-28 12:02
 */
@Controller
public class AspectTestController {

//    @Autowired
//    private HttpServletRequest request;
//
//    @Autowired
//    private HttpServletResponse response;

//    @GetMapping("/aspect")
//    @MyTestAnnotation( msg = "java")
//    String index(Map<String, Object> map) {
//        map.put("test",0);
//        map.put("str","str_tmp");
//        return "welcome";
//    }

    @MyTestAnnotation( msg = "java")
    @RequestMapping("/aspect")
    public String welcome(Map<String, Object> model, HttpServletRequest request) {
        String user = request.getParameter("user");
        System.out.println("user : " + user);

        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        System.out.println("请求开始, 各个参数, url: "+ url + " method:" + method +" uri: " + uri );



        model.put("message", "hello2");
        model.put("str","str_tmp");
        model.put("int",12);
        return "welcome";
    }
}