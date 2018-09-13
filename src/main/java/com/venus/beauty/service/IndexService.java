package com.venus.beauty.service;

import com.venus.beauty.entity.User;

import java.util.List;
import java.util.Map;

public interface IndexService {
    String login(String username, String password);

    List<User> queryAllUser();
}
