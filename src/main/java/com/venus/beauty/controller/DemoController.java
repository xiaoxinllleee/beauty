package com.venus.beauty.controller;

import com.venus.beauty.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author lx
 * @time 2018/10/10
 */
@RequestMapping("/demo")
@Controller
public class DemoController {

    Logger logger = LoggerFactory.getLogger(DemoController.class);

    @RequestMapping("/sessionkey")
    @ResponseBody
    public Map<String,Object> sessionke(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = new User();
        user.setUserid(UUID.randomUUID().toString());
        user.setUsername("test");
        user.setPassword("test123");
        session.setAttribute("admin",user);
        Map<String,Object> result = new HashMap<>();
        result.put("admin",request.getSession().getAttribute("admin"));
        return result;
    }

    @RequestMapping("/hello")
    public String hello() throws Exception {
        logger.info(" come in /hello ");
        System.out.println(1/0);
        return "";
    }

    @RequestMapping("/jenkins")
    public String jenkins(){return "jenkins";}
}
