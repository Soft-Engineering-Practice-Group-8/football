package com.lhy.travel.controller;

import com.lhy.travel.entity.Result;
import com.lhy.travel.entity.User;
import com.lhy.travel.service.UserService;
import com.lhy.travel.utils.CreateImageCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin // 允许跨域(前后端分离)
@Slf4j // 日志对象
public class UserController {
    @Autowired
    private UserService userService;


     @RequestMapping("login")
    public Result login(@RequestBody  User user,HttpServletRequest request){
        Result result=new Result();
        log.info("user: "+user);
        try {
            User userDB = userService.login(user);
            request.getServletContext().setAttribute(userDB.getId(),userDB);
            result.setMsg("登录成功").setUserId(userDB.getId());
        }catch (Exception e){
            result.setState(false).setMsg(e.getMessage());
        }

         return result;
     }
    @GetMapping("/getImage")

    public Map<String, String> getImage(HttpServletRequest request) throws IOException {
        Map<String, String> result = new HashMap<>();
        CreateImageCode createImageCode = new CreateImageCode();
        // 获取验证码
        String securityCode = createImageCode.getCode();
        // 验证码存入session
        String key = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        request.getServletContext().setAttribute(key, securityCode);
        // 生成图片
        BufferedImage image = createImageCode.getBuffImg();
        //进行base64编码
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", bos);
        String string = Base64Utils.encodeToString(bos.toByteArray());
        result.put("key", key);
        result.put("image", string);
        return result;
    }
}
