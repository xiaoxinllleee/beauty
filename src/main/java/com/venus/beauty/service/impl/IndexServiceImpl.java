package com.venus.beauty.service.impl;

import com.venus.beauty.entity.User;
import com.venus.beauty.entity.UserMapper;
import com.venus.beauty.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private UserMapper mapper;
    @Override
    public String login(String username, String password) {
        User user = mapper.selectById(username);
        if (user != null){
            if (user.getPassword().equals(password)){
                return "login";
            }
        }
        return "fail";
    }

    @Override
    public List<User> queryAllUser() {
      return  mapper.selectList(null);
    }
}
