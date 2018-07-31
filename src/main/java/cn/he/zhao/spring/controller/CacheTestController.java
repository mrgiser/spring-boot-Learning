package cn.he.zhao.spring.controller;

import cn.he.zhao.spring.entity.UserEntity;
import cn.he.zhao.spring.enums.UserSexEnum;
import cn.he.zhao.spring.mapper.UserMapper;
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
    private UserMapper userMapper;

    @Autowired
    private CacheManager cacheManager;

    @RequestMapping("/cache")
    @ResponseBody
    UserEntity cache() {


        UserEntity user = new UserEntity("aa", "a123456", UserSexEnum.MAN);
        userMapper.insert(user);
        System.out.println(" id :"+ user.getId());
        UserEntity u1 = userMapper.getOne(user.getId());
        System.out.println("第一次查询：" + u1.getPassWord());

        UserEntity u2 = userMapper.getOne(user.getId());
        System.out.println("第二次查询：" + u2.getPassWord());

        System.out.println(" id :"+ u1.getId());
        u1.setPassWord("987654");
        userMapper.update(u1);
        System.out.println(" id :"+ u1.getId());
        UserEntity u3 = userMapper.getOne(user.getId());
        System.out.println("第三次查询：" + u3.getPassWord());

        return u3;
    }
}