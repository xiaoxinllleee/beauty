package com.venus.beauty.study;

import redis.clients.jedis.Jedis;

/**
 * @author lx
 * @time 2018/10/12
 */
public class RedisDemo {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        System.out.println("服务运行"+jedis.ping());
    }
}
