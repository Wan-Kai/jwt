package com.nethomework.jwt.controller;

import com.nethomework.jwt.service.AdministratorService;
import com.nethomework.jwt.domain.Administrator;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdministratorService adminService;

    @PostMapping("/register")
    public String register(@RequestBody String body){
        String message = "ok";

        //构建Administrator
        Administrator administrator = parserJson2User(body);

        //处理登录
        try{
            int result = adminService.register(administrator);
            if(result == 1)
                message = "duplicate name";
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return message;
    }

    private Administrator parserJson2User(String body){
        //解析json获取登录信息
        JSONObject object = JSONObject.parseObject(body);
        String name = object.getString("username");
        String password = object.getString("password");

        //构造登录用户
        Administrator administrator = new Administrator();
        administrator.setUsername(name);
        administrator.setPassword(password);

        return administrator;
    }
}
