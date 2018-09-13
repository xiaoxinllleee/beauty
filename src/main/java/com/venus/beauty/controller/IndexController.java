package com.venus.beauty.controller;

import com.venus.beauty.entity.User;
import com.venus.beauty.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 用于页面跳转的控制器
 * */

@Controller
public class IndexController {
    @Autowired
    private IndexService service;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String username, String password){
        return service.login(username,password);
    }

    @RequestMapping("/myuser")
    public String getUserView(){return "user";}


    @RequestMapping("/queryAllUser")
    public String queryAllUser(Model model) {
        List<User> list = service.queryAllUser();
        model.addAttribute("users",list);
        return "user";
    }
}
