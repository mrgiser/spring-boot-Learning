package cn.he.zhao.spring.controller;

import cn.he.zhao.spring.util.SpringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * 描述: hello World
 * 控制器
 *
 * @Author HeFeng
 * @Create 2018-05-26 16:18
 */

@Controller
public class ImageController {

    @RequestMapping(value = "/image", method = RequestMethod.GET)
    public void post(final HttpServletRequest request, HttpServletResponse response) throws IOException {

        // img为图片的二进制流
        File file = new File("E:\\test.jpg");
        FileInputStream fis = new FileInputStream(file);
        byte[] img = new byte[(int) file.length()];
        fis.read(img);
        fis.close();
        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        os.write(img);
        os.flush();
        os.close();
    }
}