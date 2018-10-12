package com.venus.beauty.service;

import com.venus.beauty.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface IndexService {
    String login(String username, String password);

    List<User> queryAllUser();

    void visitDemo(HttpServletRequest request);
}
