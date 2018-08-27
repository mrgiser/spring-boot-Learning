package cn.he.zhao.spring.controller;

import cn.he.zhao.spring.controller.vo.TestVo;
import cn.he.zhao.spring.util.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    public static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

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
    public String welcome(final HttpServletRequest request,final HttpServletResponse response, @RequestParam(value = "test",required = false)String test, Map<String, Object> model) {

        HttpSession tmp_session = request.getSession(false);
        if (tmp_session != null){
            LOGGER.info("session id" + tmp_session.getId());
            LOGGER.info(tmp_session.getAttribute("user").toString());
        }

        LOGGER.info(request.getHeader("user"));

        HttpSession session = request.getSession(true);
        session.setAttribute("user","user_id");

        Cookie cookie = new Cookie("majun", "xiaoya");
        cookie.setMaxAge(10000); //设置cookie的过期时间是10s
        response.addCookie(cookie);

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
    public Map post(final HttpServletRequest request, final HttpServletResponse response, Map<String, Object> model) {

        HttpSession tmp_session = request.getSession(false);
        if (tmp_session != null){
            LOGGER.info("session id" + tmp_session.getId());
            LOGGER.info(tmp_session.getAttribute("user").toString());
        }
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            LOGGER.info("cookie name "+ cookie.getName());
            LOGGER.info("cookie value "+cookie.getValue());
        }


        HttpSession session = request.getSession(true);
        session.setAttribute("user","user_id");

        Cookie cookie = new Cookie("testCookie", "jhkgsdgflkytigklhgilgiugbughiugiu");
        cookie.setMaxAge(10000); //设置cookie的过期时间是10s
        response.addCookie(cookie);



        model.put("message", "hello2");
        model.put("str","str_tmp");
        model.put("int",12);
        model.put("sc", true);

        System.out.println(SpringUtil.getServerPath(request));
        System.out.println(SpringUtil.getServerHost(request));

        return model;
    }

    @RequestMapping("/sendError")
    public String sendError(final HttpServletResponse response) throws Exception {

        response.sendError(403);

        return null;
    }
}