package cn.he.zhao.spring.controller;

import cn.he.zhao.spring.domain.User;
import cn.he.zhao.spring.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 描述:
 * cacheTest
 *
 * @Author HeFeng
 * @Create 2018-07-30 17:26
 */
@Controller
public class CacheTestController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CacheManager cacheManager;

    @RequestMapping("/cache")
    @ResponseBody
    User cache() {


        User user = new User("AAA", 10);
        userRepository.save(user);
        User u1 = userRepository.findById(user.getId());
        System.out.println("第一次查询：" + u1.getAge());

        User u2 = userRepository.findById(u1.getId());
        System.out.println("第二次查询：" + u2.getAge());

        u1.setAge(20);
        userRepository.save(u1);
        User u3 = userRepository.findById(u1.getId());
        System.out.println("第三次查询：" + u3.getAge());

        return u3;
    }
}