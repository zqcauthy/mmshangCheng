package com.bjpowernode.controller;

import com.bjpowernode.pojo.Admin;
import com.bjpowernode.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName: AdminAction
 * Package: com.bjpowernode.controller
 * Description:
 *
 * @Author: azz1025@163.com
 * @Date: 2021/12/6 15:20
 * @Version: 1.0
 */
@Controller
@RequestMapping("/admin")
public class AdminAction {
//
    @Autowired
    AdminService adminService;

    //实现登录判断，并进行相应的跳转
    @RequestMapping("/login")
    public String login(String name, String pwd, HttpServletRequest request){
        Admin admin=adminService.login(name,pwd);

        if (admin!=null){
            request.setAttribute("admin",admin);
//            登录成功
            return "main";
        }else {
//            登录失败
            request.setAttribute("errmsg","用户名或者密码不正确！");
            return "login";
        }
    }

}
